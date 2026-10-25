package rudy.flipkart.machineround.dashboard;

import rudy.flipkart.machineround.model.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TotalRatingBased extends BaseStrategy{

    PriorityQueue<Driver> drivers = new PriorityQueue<>((a, b)-> b.getRating()- a.getRating());

    TotalRatingBased(Driver driver) {
        super(driver);
    }

    @Override
    public List<Driver> getTopDriver() {
        List<Driver> driverList = new ArrayList<>();
        while(!this.drivers.isEmpty()){
            driverList.add(this.drivers.poll());
        }
        return driverList;
    }

    @Override
    public void addDriver(Driver driver) {
    this.drivers.add(driver);
    }
}
