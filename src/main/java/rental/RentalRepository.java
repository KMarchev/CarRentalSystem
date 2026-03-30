package rental;

import rental.classes.Rental;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class that manages the list of rentals.
 */
public class RentalRepository {
    private List<Rental> rentalList = new ArrayList<>();
    private static RentalRepository repository;

    private RentalRepository(){

    }

    /**
     * Returns the singleton instance of {@link rental.RentalRepository}.
     *
     * @return the single instance of {@link rental.RentalRepository}
     */
    public static RentalRepository getInstance(){
        if(repository==null){
            repository=new RentalRepository();
        }
        return repository;
    }

    /**
     * Adds a {@link rental.classes.Rental} to the list.
     *
     * @return true if successful, false otherwise.
     */
    public boolean addRental(Rental rental){
        return rentalList.add(rental);
    }

    public boolean removeRentalByCarId(int id){
        for(Rental rental : rentalList){
            if(rental.getCarId()==id){
                return rentalList.remove(rental);
            }
        }
        return false;
    }

    /**
     * Returns the list of all Rentals.
     *
     * @return list of all rentals.
     */
    public List<Rental> getRentalList(){
        return rentalList;
    }


    /**
     * Searches for {@link rental.classes.Rental} from the list based on Car id.
     *
     * @return true if {@link rental.classes.Rental} was found in the list, false otherwise.
     */
    public boolean searchByIdForCar(int id){
        for(Rental rental : rentalList){
            if(rental.getCarId()==id){
                return true;
            }
        }
        return false;
    }

    /**
     * Searches for {@link rental.classes.Rental} from the list based on Customer id.
     *
     * @return true if {@link rental.classes.Rental} was found in the list, false otherwise.
     */
    public boolean searchByIdForCustomer(int id){
        for(Rental rental : rentalList){
            if(rental.getCustomerId()==id){
                return true;
            }
        }
        return false;
    }
}
