package rudy.flipkart.machineround.notification;

import rudy.flipkart.machineround.constants.NotificationType;
import rudy.flipkart.machineround.constants.OrderStatus;
import rudy.flipkart.machineround.model.Customer;
import rudy.flipkart.machineround.model.CustomerNotifier;

public class EmailNotification extends BaseNotification{


    @Override
    public void sendNotification(CustomerNotifier customerNotifier) {
        if(customerNotifier.getNotificationType().equals(NotificationType.EMAIL)){
            sendEmail(customerNotifier);
        }
    }

    private void sendEmail(CustomerNotifier customerNotifier) {
        String emailId = customerNotifier.getCustomer().getEmail();
        /*
        Perform email oprtn thru some vendor
        * */
        OrderStatus orderStatus = customerNotifier.getOrderDetails().getOrderStatus();
        System.out.println("Sent EMAIL to customer: "+ customerNotifier.getCustomer().getCustomerName());
        System.out.println("Having Order status:: "+ orderStatus);
    }
}
