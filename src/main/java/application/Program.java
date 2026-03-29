package application;

import car.CarRepository;
import command.classes.Executer;
import command.interfaces.Command;
import exception.CarCreateException;
import exception.CommandException;
import exception.FileException;
import file.management.car.CarReader;
import file.management.car.CarWriter;
import file.management.customer.CustomerReader;
import file.management.customer.CustomerWriter;
import file.management.rental.RentalReader;
import file.management.rental.RentalWriter;

import java.util.Scanner;

/**
 * Main program loop for the Car Rental System command-line interface.
 */

public class Program {

    /**
     * Starts the interactive command loop until user types 'exit'.
     */

    public static void run() {
        System.out.println("Welcome to the Car Rental System!");
        Scanner console=new Scanner(System.in);

        while (true){
            System.out.print("> ");
            String line = console.nextLine().trim();

            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");
            try {
                Command cmd = Executer.executable(line);
                cmd.execute(line);
            } catch (CommandException c) {
                System.out.println("CommandException: "+c.getMessage());
            }
            catch (CarCreateException carCreateException){
                System.out.println("CarCreateException: "+carCreateException.getMessage());
            }
            catch (FileException f){
                System.out.println("FileException: "+f.getMessage());
                System.exit(0);
            }catch (Exception e){
                System.out.println("Unknown exception: "+e.getMessage());
            }
        }

        System.out.println("Goodbye!");
    }

    public static void initProgram(){
        try {
            CarReader.readFromFile();
            CustomerReader.readFromFile();
            RentalReader.readFromFile();
        }catch (FileException e){
            System.out.println("FileException: " + e.getMessage());
            System.exit(0);
        }
    }

    public static void endProgram(){
        try {
            CarWriter.writeToFile();
            CustomerWriter.writeToFile();
            RentalWriter.writeToFile();
        }catch (FileException e){
            System.out.println("FileException: " + e.getMessage());
            System.exit(0);
        }
    }

}
