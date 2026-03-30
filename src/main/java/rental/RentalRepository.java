package rental;

import rental.classes.Rental;

import java.util.ArrayList;
import java.util.List;

public class RentalRepository {
    private List<Rental> rentalList = new ArrayList<>();
    private static RentalRepository repository;

    private RentalRepository(){

    }

    public static RentalRepository getInstance(){
        if(repository==null){
            repository=new RentalRepository();
        }
        return repository;
    }

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

    public List<Rental> getRentalList(){
        return rentalList;
    }

    public boolean searchByIdForCar(int id){
        for(Rental rental : rentalList){
            if(rental.getCarId()==id){
                return true;
            }
        }
        return false;
    }

    public boolean searchByIdForCustomer(int id){
        for(Rental rental : rentalList){
            if(rental.getCustomerId()==id){
                return true;
            }
        }
        return false;
    }
}
