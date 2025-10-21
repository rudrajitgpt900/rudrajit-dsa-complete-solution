package rudy.flipkart.machineround.model;

public class Customer {

    private final long customerId;
    private final String customerName;
    private String email;
    private String phoneNo;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Customer(long customerId, String name) {
        this.customerId = customerId;
        this.customerName = name;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
