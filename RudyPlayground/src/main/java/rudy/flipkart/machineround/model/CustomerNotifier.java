package rudy.flipkart.machineround.model;

import rudy.flipkart.machineround.constants.NotificationType;
import rudy.flipkart.machineround.notification.BaseNotification;
import rudy.flipkart.machineround.service.CustomerService;

import java.util.Objects;

public class CustomerNotifier  {

    private Customer customer;
    private Order orderDetails;

    public Order getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Order orderDetails) {
        this.orderDetails = orderDetails;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    private NotificationType notificationType;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    public CustomerNotifier(long customerId, String name , Order order) {
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.getCustomer(customerId);
        if(Objects.nonNull(customer)){
            this.customer = customer;
        }
        else{
            this.customer = new Customer(customerId,name);
        }
        this.notificationType = NotificationType.EMAIL;
        this.orderDetails = order;
    }

    public CustomerNotifier(Customer customer, Order order){
        this.customer = customer;
        this.orderDetails = order;
        this.notificationType = NotificationType.EMAIL;

    }


}
