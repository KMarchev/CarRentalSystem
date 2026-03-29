package car;

import car.classes.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private List<Car> cars=new ArrayList<>();
    private static CarRepository carRepository;

    private CarRepository(){

    }

    public static CarRepository getInstance(){
        if(carRepository==null){
            carRepository=new CarRepository();
        }
        return carRepository;
    }

    public boolean addCar(Car car){
        return cars.add(car);
    }

    public boolean removeCarById(int id) {
        for(Car car : cars){
            if(car.getId()==id){
                cars.remove(car);
                return true;
            }
        }
        return false;
    }

    public int searchById(int id){
        for(int i=0;i<cars.size();i++){
            if(cars.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    public List<Car> getAvailableCarsList(){
        return cars
                .stream()
                .filter(Car::isAvailable)
                .toList();
    }

    public Car getCar(int id){
        return cars.stream()
                .filter(car -> car.getId()==id)
                .findFirst()
                .orElse(null);
    }

}
