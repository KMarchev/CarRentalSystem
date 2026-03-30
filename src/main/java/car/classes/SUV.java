package car.classes;

/**
 * Represents a SUV type car.
 * <p>
 * This class extends {@link car.classes.Car} and uses the base class constructor
 * to initialize its properties.
 */
public class SUV extends Car{

    /**
     * Creates an SUV object using the given parameters.
     *
     * @param params array containing car data
     */
    public SUV(String[] params) {
        super(params);
    }

}
