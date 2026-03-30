package car;

import car.classes.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class that manages the list of cars.
 */
public class CarRepository {
    private List<Car> cars=new ArrayList<>();
    private static CarRepository carRepository;

    private CarRepository(){

    }

    /**
     * Returns the singleton instance of {@link car.CarRepository}.
     *
     * @return the single instance of {@link car.CarRepository}.
     */
    public static CarRepository getInstance(){
        if(carRepository==null){
            carRepository=new CarRepository();
        }
        return carRepository;
    }

    /**
     * Adds a {@link car.classes.Car} to the list.
     *
     * @return true if successful, false otherwise.
     */
    public boolean addCar(Car car){
        return cars.add(car);
    }

    /**
     * Removes a {@link car.classes.Car} from the list based on id.
     *
     * @return true if successful, false otherwise.
     */
    public boolean removeCarById(int id) {
        for(Car car : cars){
            if(car.getId()==id){
                cars.remove(car);
                return true;
            }
        }
        return false;
    }

    /**
     * Searches for {@link car.classes.Car} from the list based on id.
     *
     * @return index of {@link car.classes.Car} in the list.
     */
    public int searchById(int id){
        for(int i=0;i<cars.size();i++){
            if(cars.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the list of all Cars that are currently available.
     *
     * @return list of all cars that are currently available.
     */
    public List<Car> getAvailableCarsList(){
        return cars
                .stream()
                .filter(Car::isAvailable)
                .toList();
    }

    /**
     * Searches for {@link car.classes.Car} from the list based on id.
     *
     * @return {@link car.classes.Car} in the list with specified id.
     */
    public Car getCar(int id){
        return cars.stream()
                .filter(car -> car.getId()==id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Returns the list of all Cars.
     *
     * @return list of all cars.
     */
    public List<Car> getCarList(){
        return cars;
    }

    /**
     * Searches for {@link car.classes.Car} from the list based on model name.
     *
     * @return List of {@link car.classes.Car} in the list with specified model name.
     */
    public List<Car> getCarsByModel(String model){
        String searchValue = model.trim().toLowerCase();

        return cars.stream()
                .filter(car -> car.getModel().toLowerCase().equals(searchValue))
                .toList();
    }

    /**
     * Adds a {@link car.classes.Car} to the list at specific index.
     *
     * @param index position you want to insert the Car at.
     * @param car {@link car.classes.Car} you want to insert.
     */
    public void addCarAtIndex(int index, Car car){
        cars.add(index,car);
    }
}
