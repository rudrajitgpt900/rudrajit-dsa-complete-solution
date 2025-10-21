package rudy.flipkart.machineround.dashboard;

import rudy.flipkart.machineround.model.Driver;

public class DriverDashboardTotalOrderBased extends DashBoard{
    Driver driver;

    public DriverDashboardTotalOrderBased(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void showTopDriver() {
        BaseStrategy baseStrategy = new TotalOrderBased(driver);
        baseStrategy.addDriver(driver);
        baseStrategy.getTopDriver();
    }
}
