package file.management.car;

import car.CarRepository;
import car.classes.Car;
import exception.FileException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class CarWriter {
    public static void writeToFile(){
        String filePath="src/main/resource/cars.csv";
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath))) {
            br.write("Id,Make,Model,Year,Type,Status");
            br.newLine();
            for(Car car : CarRepository.getInstance().getCarList()){
                br.write(String.format("%d,%s,%s,%d,%s,%s",car.getId(),car.getMaker(),car.getModel(),car.getYear(),car.getType(), car.isAvailable() ? "Available" : "Rented"));
                br.newLine();
            }
        } catch (Exception e) {
            throw new FileException("Please make sure your files are written correctly!");
        }
    }
}
