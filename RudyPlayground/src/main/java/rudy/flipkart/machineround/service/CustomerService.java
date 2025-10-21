package rudy.flipkart.machineround.service;

import rudy.flipkart.machineround.model.Customer;
import rudy.flipkart.machineround.repository.CustomerRepository;

import java.util.Objects;

public class CustomerService {

    public Customer onboardCustomer(long id , String name){
        Customer customer = CustomerRepository.addCustomer(id, name);

        if(Objects.isNull(customer)){
            System.out.println("Customer "+ name+ " already onboarded !!");
            return CustomerRepository.getCustomerRepo().get(id);
        }
        System.out.println("Customer onboarded");
        return customer;
    }

    public Customer getCustomer(long id){
        return CustomerRepository.getCustomerRepo().get(id);
    }
}
