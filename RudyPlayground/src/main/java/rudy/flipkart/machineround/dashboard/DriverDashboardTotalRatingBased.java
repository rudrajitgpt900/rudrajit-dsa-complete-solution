package rudy.flipkart.machineround.dashboard;

import rudy.flipkart.machineround.model.Driver;

public class DriverDashboardTotalRatingBased extends DashBoard{

    Driver driver;

    public DriverDashboardTotalRatingBased(Driver driver) {
        this.driver = driver;
    }
    @Override
    public void showTopDriver() {
        BaseStrategy baseStrategy = new TotalOrderBased(driver);
        baseStrategy.addDriver(driver);
        baseStrategy.getTopDriver();
    }
}
