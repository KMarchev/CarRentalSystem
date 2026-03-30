package car.classes;

/**
 * Represents a Sedan type car.
 * <p>
 * This class extends {@link car.classes.Car} and uses the base class constructor
 * to initialize its properties.
 */
public class Sedan extends Car{

    /**
     * Creates a Sedan object using the given parameters.
     *
     * @param params array containing car data
     */
    public Sedan(String[] params) {
        super(params);
    }

}
