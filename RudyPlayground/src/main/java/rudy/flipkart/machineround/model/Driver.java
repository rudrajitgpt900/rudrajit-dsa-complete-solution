package rudy.flipkart.machineround.model;

import rudy.flipkart.machineround.constants.DriverStatus;

public class Driver {

    private long driverId;
    private String driverName;
    private DriverStatus driverStatus;
    private int totalOrderDelivered;
    private int rating;

    public int getTotalOrderDelivered() {
        return totalOrderDelivered;
    }

    public void setTotalOrderDelivered(int totalOrderDelivered) {
        this.totalOrderDelivered = totalOrderDelivered;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Driver(long driverId, String driverName) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverStatus = DriverStatus.AVAILABLE;
    }

    public long getDriverId() {
        return driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", driverStatus=" + driverStatus +
                ", totalOrderDelivered=" + totalOrderDelivered +
                ", rating=" + rating +
                '}';
    }
}
