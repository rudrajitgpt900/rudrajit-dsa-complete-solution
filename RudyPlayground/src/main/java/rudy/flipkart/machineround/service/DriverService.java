package rudy.flipkart.machineround.service;

import rudy.flipkart.machineround.constants.DriverStatus;
import rudy.flipkart.machineround.model.Customer;
import rudy.flipkart.machineround.model.Driver;
import rudy.flipkart.machineround.repository.CustomerRepository;
import rudy.flipkart.machineround.repository.DriverRepository;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class DriverService {

    public  Driver onboardDriver(long id , String name){
      Driver newDriver = DriverRepository.addDriver(id , name);
      if(Objects.isNull(newDriver)){
          System.out.println("Driver: "+ name+ " already onboarded");
          return DriverRepository.getDriverRepo().get(id);
      }
     System.out.println("Driver onboarded");
     return newDriver;
    }

    public  void setDriverStatus(Driver driver , DriverStatus driverStatus){
        driver.setDriverStatus(driverStatus);
    }
    public  List<Driver> getAvailableDrivers(){
      var driverSet=  DriverRepository.getDriverRepo().values();

      return driverSet.stream().filter(driver -> driver.getDriverStatus().equals(DriverStatus.AVAILABLE)).collect(Collectors.toList());
    }

    public  Map<Long, Driver> getDriverRepo() {return DriverRepository.getDriverRepo();}

    public DriverStatus getDriverStatus(long driverId){
        var repo = DriverRepository.getDriverRepo();
        if(repo.containsKey(driverId)){
          return   DriverRepository.getDriverStatus(driverId);
        }
        return DriverStatus.ON_TRIP;
    }

    public void updateDriver(Driver driver){
        DriverRepository.updateDriver(driver);
    }

}
