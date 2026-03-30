package customer;

import customer.classes.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class that manages the list of customers.
 */
public class CustomerRepository {
    private List<Customer> customerList = new ArrayList<>();
    private static CustomerRepository customerRepository;

    private CustomerRepository(){

    }

    /**
     * Returns the singleton instance of {@link customer.CustomerRepository}.
     *
     * @return the single instance of {@link customer.CustomerRepository}
     */
    public static CustomerRepository getInstance(){
        if(customerRepository==null){
            customerRepository=new CustomerRepository();
        }
        return customerRepository;
    }

    /**
     * Adds a {@link customer.classes.Customer} to the list.
     *
     * @return true if successful, false otherwise.
     */
    public boolean addCustomer(Customer customer){
        return customerList.add(customer);
    }

    /**
     * Removes a {@link customer.classes.Customer} from the list based on id.
     *
     * @return true if successful, false otherwise.
     */
    public boolean removeCustomerById(int id){
        for(Customer customer:customerList){
            if(customer.getId()==id){
                customerList.remove(customer);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the list of all Customers.
     *
     * @return list of all customers.
     */
    public List<Customer> getCustomerList(){
        return customerList;
    }

    /**
     * Searches for {@link customer.classes.Customer} from the list based on id.
     *
     * @return index of {@link customer.classes.Customer} in the list.
     */
    public int searchById(int id){
        for(int i=0;i<customerList.size();i++){
            if(customerList.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    /**
     * Searches for {@link customer.classes.Customer} from the list based on id.
     *
     * @return {@link customer.classes.Customer} in the list with specified id.
     */
    public Customer getCustomerById(int id){
        return customerList.stream()
                .filter(customer -> customer.getId()==id)
                .findFirst()
                .orElse(null);
    }
}
