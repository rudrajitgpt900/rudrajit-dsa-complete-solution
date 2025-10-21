package rudy.flipkart.machineround.dashboard;

import rudy.flipkart.machineround.model.Driver;

import java.util.List;

public abstract class BaseStrategy {
    private Driver driver;
    BaseStrategy(Driver driver){
        this.driver = driver;
    }
    public abstract List<Driver>getTopDriver();
    public abstract void addDriver(Driver driver);


}
