package rudy.flipkart.machineround.repository;

import rudy.flipkart.machineround.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepository {

    private static final Map<Long, Customer>customerRepo = new HashMap<>();

    public static Customer addCustomer(long id , String name){
        if(customerRepo.containsKey(id)){
            return null;
        }
        Customer customer = new Customer(id , name);
        customerRepo.put(id , customer);
        return customer;
    }

    public static void deleteCustomer(long id){
        customerRepo.remove(id);
    }

    public static Map<Long , Customer>getCustomerRepo(){ return customerRepo;}
}
