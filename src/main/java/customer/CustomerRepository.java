package customer;

import customer.classes.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private List<Customer> customerList = new ArrayList<>();
    private static CustomerRepository customerRepository;

    private CustomerRepository(){

    }

    public static CustomerRepository getInstance(){
        if(customerRepository==null){
            customerRepository=new CustomerRepository();
        }
        return customerRepository;
    }

    public boolean addCustomer(Customer customer){
        return customerList.add(customer);
    }

    public boolean removeCustomerById(int id){
        for(Customer customer:customerList){
            if(customer.getId()==id){
                customerList.remove(customer);
                return true;
            }
        }
        return false;
    }

    public List<Customer> getCustomerList(){
        return customerList;
    }

    public int searchById(int id){
        for(int i=0;i<customerList.size();i++){
            if(customerList.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
}
