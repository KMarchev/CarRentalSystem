package file.management.car;

import car.CarRepository;
import car.classes.Car;
import car.classes.CarFactory;
import exception.FileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CarReader {

    public static void readFromFile(){
        String filePath="src/main/resource/cars.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] params = line.split(",");
                CarRepository.getInstance().addCar(CarFactory.createCar(Arrays.copyOfRange(params,0,5)));
                if(!params[5].equals("Available") && !params[5].equals("Rented")){
                    throw new FileException("Please make sure your files are written correctly!");
                }
                CarRepository.getInstance().getCar(Integer.parseInt(params[0])).setAvailable(params[5].equals("Available"));
            }
        } catch (Exception e) {
            throw new FileException("Please make sure your files are written correctly!");
        }
    }
}
