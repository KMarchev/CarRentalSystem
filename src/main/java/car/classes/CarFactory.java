package car.classes;

import exception.CarCreateException;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CarFactory {
    private static final Map<String, Class<? extends Car>> carList=new HashMap<>();

    static {
        carList.put("SUV", SUV.class);
        carList.put("Sedan", Sedan.class);
        carList.put("Hatchback", Hatchback.class);
    }

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

    public static boolean isValidType(String type){
        Class<? extends Car> car = carList.get(carList.get(type));
        return car != null;
    }
}
