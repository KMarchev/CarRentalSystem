package car.classes;

/**
 * Represents a Hatchback type car.
 * <p>
 * This class extends {@link car.classes.Car} and uses the base class constructor
 * to initialize its properties.
 */
public class Hatchback extends Car{

    /**
     * Creates a Hatchback object using the given parameters.
     *
     * @param params array containing car data
     */
    public Hatchback(String[] params) {
        super(params);
    }
}
