package rudy.flipkart.machineround.repository;

import rudy.flipkart.machineround.constants.DriverStatus;
import rudy.flipkart.machineround.model.Customer;
import rudy.flipkart.machineround.model.Driver;

import java.util.HashMap;
import java.util.Map;

public class DriverRepository {

    private static final Map<Long, Driver> driverRepo = new HashMap<>();

    public static Driver addDriver(long id , String name){
        if(driverRepo.containsKey(id)){

            return null;
        }

        Driver driver = new Driver(id , name);
        driverRepo.put(id , driver);
        return driver;
    }

    public void deleteDriver(long id){
        driverRepo.remove(id);
    }

    public static Map<Long , Driver>getDriverRepo(){ return driverRepo;}

    public static DriverStatus getDriverStatus(long id){
       return driverRepo.get(id).getDriverStatus();
    }

    public static void updateDriver(Driver driver){
        long driverID = driver.getDriverId();
        if(driverRepo.containsKey(driverID)){
            Driver existingDriver = driverRepo.get(driverID);
            existingDriver.setDriverStatus(driver.getDriverStatus());
            existingDriver.setTotalOrderDelivered(driver.getTotalOrderDelivered());
            driverRepo.put(driverID , existingDriver);
        }
    }
}
