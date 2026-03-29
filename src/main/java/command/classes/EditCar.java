package command.classes;

import car.CarRepository;
import car.classes.Car;
import car.classes.CarFactory;
import command.interfaces.Command;
import exception.CommandException;
import helper.ValueValidator;

import java.util.Arrays;
import java.util.Scanner;

public class EditCar implements Command {
    @Override
    public void execute(String args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        CarRepository repository = CarRepository.getInstance();

        System.out.print("ID of car you want to change: ");
        int id=scanner.nextInt();
        scanner.nextLine();
        if(repository.searchById(id)==-1){
            throw new CommandException("No car found with ID: "+id);
        }

        System.out.printf("Current Info: %s\nNew Info(ID cannot be changed!) Example - Toyota,Camry,2004,SUV \n",repository.getCar(id).toString());

        String[] params= Arrays.stream(scanner.nextLine().split(",")).map(String::trim).toArray(String[]::new);

        if(!ValueValidator.isValidName(params[0])
                || !ValueValidator.isValidName(params[1])
                || !ValueValidator.isValidYear(params[2])
                || !CarFactory.isValidType(params[3])){
            throw new CommandException("Invalid arguments! Change was not saved.");
        }

        repository.getCar(id).setMaker(params[0]);
        repository.getCar(id).setModel(params[1]);
        repository.getCar(id).setYear(Integer.parseInt(params[2]));
        repository.getCar(id).setType(params[3]);
    }
}
