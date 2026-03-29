package command.classes;

import command.interfaces.Command;
import customer.CustomerRepository;
import exception.CommandException;

import java.util.Scanner;

public class RemoveCustomer implements Command {
    @Override
    public void execute(String args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        CustomerRepository repository = CustomerRepository.getInstance();

        System.out.print("ID of customer you want to remove: ");
        int id=scanner.nextInt();
        scanner.nextLine();
        if(repository.searchById(id)==-1){
            throw new CommandException("No customer found with ID: "+id);
        }

        repository.removeCustomerById(id);
        System.out.println("Customer removed successfully.");
    }
}
