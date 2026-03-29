package car.classes;

import exception.CarCreateException;
import helper.ValueValidator;

public abstract class Car {
    protected int id;
    protected String maker;
    protected String model;
    protected int year;
    protected String type;
    protected boolean isAvailable;

    public Car(String[] params) {
        if(!validateArguments(params)){
            throw new CarCreateException("Invalid arguments!\n");
        }
        this.id=Integer.parseInt(params[0]);
        this.maker=params[1];
        this.model=params[2];
        this.year=Integer.parseInt(params[3]);
        this.type=params[4];
        this.isAvailable = true;
    }

    public static boolean validateArguments(String[] args){
        return args.length==5
                && ValueValidator.isValidId(args[0])
                && ValueValidator.isValidName(args[1])
                && ValueValidator.isValidName(args[2])
                && ValueValidator.isValidYear(args[3])
                && ValueValidator.isValidName(args[4]);
    }

    public int getId() {
        return id;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString(){
        return String.format("ID:%d, Name:%s %s, Year Made:%d, Type:%s, Availability: %s"
                ,id
                ,maker
                ,model
                ,year
                ,type
                ,isAvailable ? "Available" : "Rented");
    }
}
