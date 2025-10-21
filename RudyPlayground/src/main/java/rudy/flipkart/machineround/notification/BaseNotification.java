package rudy.flipkart.machineround.notification;

import rudy.flipkart.machineround.model.Customer;
import rudy.flipkart.machineround.model.CustomerNotifier;

public abstract class BaseNotification {

    public abstract void sendNotification(CustomerNotifier customerNotifier);
}
