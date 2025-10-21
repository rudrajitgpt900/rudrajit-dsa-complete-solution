package rudy.flipkart.machineround.service;

import rudy.flipkart.machineround.constants.DriverStatus;
import rudy.flipkart.machineround.constants.ItemType;
import rudy.flipkart.machineround.constants.OrderStatus;
import rudy.flipkart.machineround.model.*;
import rudy.flipkart.machineround.notification.BaseNotification;
import rudy.flipkart.machineround.notification.EmailNotification;
import rudy.flipkart.machineround.repository.BaseDataStore;
import rudy.flipkart.machineround.repository.DriverRepository;
import rudy.flipkart.machineround.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.*;

/*
* create an order
* cancel an order
* show order status
* show driver status
* pickUp order
* completeOrder
*
* */
public class OrderService {
    private final DriverService driverService = new DriverService();
    private final CustomerService customerService = new CustomerService();
    private long OrderId = 20;

    public Order createOrder(long customerId, Item item) throws IllegalAccessException {
        Customer customer = customerService.getCustomer(customerId);
        if(Objects.isNull(customer)){
            throw new IllegalAccessException("Customer not found with given id :" + customerId);
        }
        if(!BaseDataStore.validate(item)){
            throw new IllegalAccessException("Only suggested Item types are allowed");
        }
        Order newOrder = new Order(OrderId,customerId , item);
        OrderId++;
        OrderRepository.addOrder(newOrder);

        //assignDriver from available driver
        //if driver available update driver status to assigned
        assignDriverIfAvailable(newOrder);

        return newOrder;
    }

    private void assignDriverIfAvailable(Order order){
        List<Driver> availableDrivers = driverService.getAvailableDrivers();
        Driver driverAvailable = availableDrivers.stream().filter(driver -> driver.getDriverStatus().equals(DriverStatus.AVAILABLE)).findFirst().orElse(null);
        if(Objects.nonNull(driverAvailable)){
            order.setAssignedDriver(driverAvailable);
            driverAvailable.setDriverStatus(DriverStatus.ASSIGNED);
            driverService.updateDriver(driverAvailable);
        }
        else{
            putPendingQueue(order);
            System.out.println("No drivers Available rite now, We will assign once the drivers are available");
        }
    }

    public void cancelOrder(long orderId)  {
        Order existingOrder = OrderRepository.getOrderRepo().get(orderId);
        if(Objects.nonNull(existingOrder)){
            if( existingOrder.getOrderStatus().equals(OrderStatus.PICKED_UP) ){
                System.out.println("Order already picked up can't be cancelled now");
                return;
            }
            Customer existingCustomer = customerService.getCustomer(existingOrder.getCustomerId());
            CustomerNotifier customerNotifier = new CustomerNotifier(existingCustomer ,existingOrder);
            existingOrder.setOrderStatus(OrderStatus.CANCELLED);
           // existingOrder.setAssignedDriver(null);
            OrderRepository.updateOrderRepo(existingOrder);
            var driver = existingOrder.getAssignedDriver();
            driverService.setDriverStatus(driver , DriverStatus.AVAILABLE);
            driverService.updateDriver(driver);
            BaseNotification notification = new EmailNotification();
            notification.sendNotification(customerNotifier);

        }
    }

    public void pickUpOrder(Order order ,Driver driver){
        if(order.getOrderStatus().equals(OrderStatus.CANCELLED)){
            System.out.println("Order cant be delivered as its cancelled by user");
            return;
        }
        if(Objects.nonNull(driver)){
            driver.setDriverStatus(DriverStatus.ON_TRIP);
            order.setOrderStatus(OrderStatus.PICKED_UP);
            System.out.println(order.getItemType() +"Picked up by Driver "+ driver.getDriverName());
            driverService.updateDriver(driver);
            OrderRepository.updateOrderRepo(order);

            return;
        }
        else{
            System.out.println("Order cannot be fullfilled rite now all drivers are busy ");
        }

    }

    public void completeOrder(Order order , Driver driver){
        if(order.getOrderStatus().equals(OrderStatus.CANCELLED)){
            System.out.println("Order cant be delivered as its cancelled by user");
            return;
        }
        driver.setTotalOrderDelivered(driver.getTotalOrderDelivered() + 1);
        driverService.setDriverStatus(driver , DriverStatus.COMPLETED);

        order.setOrderStatus(OrderStatus.DELIVERED);
        OrderRepository.updateOrderRepo(order);
        driverService.setDriverStatus(driver , DriverStatus.AVAILABLE);
        driverService.updateDriver(driver);
    }

    public void printOrderStats(long orderId){
        var orderRepo = OrderRepository.getOrderRepo();
        if(orderRepo.containsKey(orderId)){
            Order orderDetails = orderRepo.get(orderId);
            System.out.println(orderDetails);
        }
    }

    public void printDriverStat(long driverId){
        var driverRepo = driverService.getDriverRepo();
        if(driverRepo.containsKey(driverId)){
            System.out.println(driverRepo.get(driverId));
        }
    }

    public void putPendingQueue(Order order) {
        BaseDataStore.pendingOrder.add(order);
        //processPendingOrder();
    }
    public void processPendingOrder(){

        if(BaseDataStore.pendingOrder.isEmpty()) return;
        ArrayDeque<Order> queue =  BaseDataStore.pendingOrder;
        while (!queue.isEmpty()){
            Order pendingOrder = queue.pollFirst();
            LocalDateTime orderPlacedAt = pendingOrder.getPlacedAt();
            LocalDateTime currentTime = LocalDateTime.now();
            assignDriverIfAvailable(pendingOrder);
            if(pendingOrder.getAssignedDriver()== null){
                //
                queue.addFirst(pendingOrder); // it is adding at the back
            }
            else if(currentTime.getMinute() - orderPlacedAt.getMinute() >= 30){
                //queue.remove(pendingOrder);
                cancelOrder(pendingOrder.getOrderId());
            }
            else{
                pickUpOrder(pendingOrder , pendingOrder.getAssignedDriver());
                completeOrder(pendingOrder ,pendingOrder.getAssignedDriver());
            }

        }
    }
}
