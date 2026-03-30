package car.classes;

import exception.CarCreateException;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory class used to create different types of {@link car.classes.Car} objects.
 * <p>
 * It maps a car type (e.g. {@link car.classes.SUV}, {@link car.classes.Sedan}) to its corresponding class
 * and creates instances dynamically.
 */
public class CarFactory {
    private static final Map<String, Class<? extends Car>> carList=new HashMap<>();

    static {
        carList.put("SUV", SUV.class);
        carList.put("Sedan", Sedan.class);
        carList.put("Hatchback", Hatchback.class);
    }

    /**
     * Creates a {@link car.classes.Car} object based on the provided parameters.
     * The car type is expected at index 4 in the params array.
     *
     * @param params array containing car data
     * @return a new {@link car.classes.Car} instance of the specified type
     * @throws Exception if the type is invalid or object creation fails
     */
    public static Car createCar(String[] params) throws Exception {
        Class<? extends Car> car=carList.get(params[4]);
        if(car!=null){
            try{
                return car.getDeclaredConstructor(String[].class).newInstance((Object) params);
            }catch(NoSuchMethodException e){
                throw new NoSuchMethodException("Constructor not found for the car: " + params[4]);
            }
            catch (InvocationTargetException e){
                if (e.getCause() instanceof CarCreateException) {
                    throw (CarCreateException) e.getCause();
                }
                throw new Exception("Constructor threw: " + e.getCause());
            }
            catch (Exception e){
                throw new Exception("Unknown error; " + e.getCause());
            }
        }
        return null;
    }

    /**
     * Checks if the given car type is supported by the factory.
     *
     * @param type the car type to check
     * @return true if the type exists, false otherwise
     */
    public static boolean isValidType(String type){
        Class<? extends Car> car = carList.get(type);
        return car != null;
    }
}
