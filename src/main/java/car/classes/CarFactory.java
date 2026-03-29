package car.classes;

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
            catch (Exception e){
                throw new Exception("Unknown error; " + e.getCause());
            }
        }
        return null;
    }
}
