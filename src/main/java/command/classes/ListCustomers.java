package command.classes;

import car.CarRepository;
import command.interfaces.Command;
import customer.CustomerRepository;

import java.util.Scanner;

public class ListCustomers implements Command {
    @Override
    public void execute(String args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        CustomerRepository repository = CustomerRepository.getInstance();


        System.out.print("List of all customers:\n");

        repository.getCustomerList().forEach(car -> System.out.println(car.toString()));

        System.out.println();
    }
}
