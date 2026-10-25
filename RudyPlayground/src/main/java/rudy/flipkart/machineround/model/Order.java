package rudy.flipkart.machineround.model;

import rudy.flipkart.machineround.constants.DriverStatus;
import rudy.flipkart.machineround.constants.OrderStatus;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {

    private long orderId;
    private long customerId;
    private Item itemType;
    private String pickUpLocation;
    private  String dropLocation;
    private Driver assignedDriver;
    private LocalDateTime placedAt;
    private OrderStatus orderStatus;

    public Order(long orderId, long customerId , Item item){
        this.orderId =orderId;
        this.customerId = customerId;
        this.itemType = item;
        this.assignedDriver= null;
        this.orderStatus = OrderStatus.PLACED;
        this.placedAt = LocalDateTime.now();
    }

    public Order(long orderId, long customerId, Item itemType, String pickUpLocation, String dropLocation, Driver assignedDriver, LocalDateTime placedAt) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.itemType = itemType;
        this.pickUpLocation = pickUpLocation;
        this.dropLocation = dropLocation;
        this.assignedDriver = assignedDriver;
        this.placedAt = placedAt;
        this.orderStatus = OrderStatus.PLACED;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Item getItemType() {
        return itemType;
    }

    public void setItemType(Item itemType) {
        this.itemType = itemType;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public Driver getAssignedDriver() {
        return assignedDriver;
    }

    public void setAssignedDriver(Driver assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    public LocalDateTime getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(LocalDateTime placedAt) {
        this.placedAt = placedAt;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", itemType='" + itemType + '\'' +
                ", pickUpLocation='" + pickUpLocation + '\'' +
                ", dropLocation='" + dropLocation + '\'' +
                ", assignedDriver=" + assignedDriver +
                ", placedAt=" + placedAt +
                ", orderStatus=" + orderStatus +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && customerId == order.customerId && assignedDriver == order.assignedDriver && Objects.equals(itemType, order.itemType) && Objects.equals(pickUpLocation, order.pickUpLocation) && Objects.equals(dropLocation, order.dropLocation) && Objects.equals(placedAt, order.placedAt) && orderStatus == order.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, itemType, pickUpLocation, dropLocation, assignedDriver, placedAt, orderStatus);
    }
}


