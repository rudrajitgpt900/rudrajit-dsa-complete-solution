package rudy.flipkart.machineround.repository;

import rudy.flipkart.machineround.model.Customer;
import rudy.flipkart.machineround.model.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OrderRepository {

    private static final Map<Long, Order> orderRepo = new HashMap<>();

    public static void addOrder(Order order){
        if(orderRepo.containsKey(order.getOrderId())){
            System.out.println("Order "+ order+ " already placed !!");
            return;
        }
        orderRepo.put(order.getOrderId() , order);
    }

    public static void deleteOrder(long id){
        orderRepo.remove(id);
    }

    public static Map<Long,Order>getOrderRepo(){return orderRepo;}

    public static void updateOrderRepo(Order orderUpdate){
        Order order = orderRepo.get(orderUpdate.getOrderId());
        if(Objects.isNull(order)) return;
        order.setOrderStatus(orderUpdate.getOrderStatus());
        order.setAssignedDriver(orderUpdate.getAssignedDriver());
        orderRepo.put(order.getOrderId(), order);
    }

}
