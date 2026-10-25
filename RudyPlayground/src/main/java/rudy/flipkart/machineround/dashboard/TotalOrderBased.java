package rudy.flipkart.machineround.dashboard;

import rudy.flipkart.machineround.model.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TotalOrderBased extends BaseStrategy{

    PriorityQueue<Driver> drivers = new PriorityQueue<>((a, b)-> b.getTotalOrderDelivered()- a.getTotalOrderDelivered());
    TotalOrderBased(Driver driver) {
        super(driver);
    }

    public void addDriver(Driver driver){
        this.drivers.add(driver);
    }

    public List<Driver> getTopDriver(){
        List<Driver> driverList = new ArrayList<>();
        while(!this.drivers.isEmpty()){
            driverList.add(this.drivers.poll());
        }
        return driverList;
    }
}
