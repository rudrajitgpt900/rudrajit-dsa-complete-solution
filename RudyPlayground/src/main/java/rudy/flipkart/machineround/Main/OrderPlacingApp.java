package rudy.flipkart.machineround.Main;

import rudy.flipkart.machineround.constants.ItemType;
import rudy.flipkart.machineround.model.Customer;
import rudy.flipkart.machineround.model.CustomerNotifier;
import rudy.flipkart.machineround.model.Driver;
import rudy.flipkart.machineround.model.Item;
import rudy.flipkart.machineround.notification.BaseNotification;
import rudy.flipkart.machineround.notification.EmailNotification;
import rudy.flipkart.machineround.service.CustomerService;
import rudy.flipkart.machineround.service.DriverService;
import rudy.flipkart.machineround.service.OrderService;

import java.util.Objects;

public class OrderPlacingApp {

    public static void main(String[] args) throws IllegalAccessException {

        // onboard Customer

        CustomerService customerService = new CustomerService();
        Customer customer1= customerService.onboardCustomer(1, "Rudra");

        Customer customer2 = customerService.onboardCustomer(2, "Akash");
        Customer customer3 = customerService.onboardCustomer(3,"Mou");

        //Onboard Driver
        DriverService driverService = new DriverService();
        Driver driver1 = driverService.onboardDriver(1, "Pankaj");
        Driver driver2 = driverService.onboardDriver(2,"Shobhit");
        Driver driver3 = driverService.onboardDriver(3, "Nabendu");

        //Create Item customer wants to order
        Item item1 = new Item(1, "Jeans", ItemType.CLOTHES);
        Item item2 = new Item(2, "Paracetamol", ItemType.MEDICINES);
        Item item3 = new Item(3,"Sweet dish",ItemType.FOOD);

        //create an order;
        System.out.println("************Create Order****************");
        OrderService orderService = new OrderService();

        var order1= orderService.createOrder(1,item1);
//        CustomerNotifier customerNotifier1 = new CustomerNotifier(customer1 , order1);
//        BaseNotification notification = new EmailNotification();
//        notification.sendNotification(customerNotifier1);


        //var order2= orderService.createOrder(1,item2);
        //var order3= orderService.createOrder(1,item3);


        orderService.pickUpOrder(order1, order1.getAssignedDriver()); //We are trying to pick the order based on assigned driver
        //notification.sendNotification(customerNotifier1);

       //If order is already picked then we cant cancel it, else cancel the order and update repo

        //orderService.pickUpOrder(order2, order2.getAssignedDriver());
        //orderService.pickUpOrder(order3, order3.getAssignedDriver());

        orderService.cancelOrder(order1.getOrderId());

        orderService.completeOrder(order1 , order1.getAssignedDriver());
       // notification.sendNotification(customerNotifier1);

        //orderService.completeOrder(order2 , order2.getAssignedDriver());

        orderService.processPendingOrder(); //If incase few order were not assigned a driver due to there unavailibilty thn put them in DLQ and apply retry mechanism

        System.out.println("**************Getting Stats***********");
        orderService.printOrderStats(order1.getOrderId());
        orderService.printDriverStat(order1.getAssignedDriver().getDriverId());
       // orderService.printOrderStats(order3.getOrderId());

    }
}
