# Car Rental System

## Overview
This project is a Java-based Car Rental System.  
It allows managing different types of cars, validating input data, and handling rentals between cars and customers.

---

## Features
- Support for multiple car types (SUV, Sedan, Hatchback)
- Dynamic object creation using a Factory
- Input validation with custom exception handling
- Rental management with return date tracking
- Reading from .csv files during program initializing
- Writing to .csv files after program has ended
- Methods for adding, removing and editing cars
- Methods for adding and removing customers
- Methods for adding and removing rentals

---

## Project Structure

### 1. Car
- `Car` (abstract class)
  - Defines common properties:
    - id
    - maker
    - model
    - year
    - type
    - availability
  - Handles base validation logic

- Subclasses:
  - `SUV`
  - `Sedan`
  - `Hatchback`

Each subclass extends `Car` and uses the base constructor while allowing extension.

---

### 2. CarFactory
- Factory class for creating car objects
- Maps car type `String` - `Class<? extends Car>`
- Instantiates objects dynamically
- Handles constructor errors and validation exceptions

---

### 3. Customer
- Represents a customer
- Stores:
    - id
    - name

---

### 4. Rental
- Represents a rental transaction
- Stores:
  - `Car` ID
  - `Customer` ID
  - Expected return date
- Formats output for display
- Connects with repositories to fetch related data

---

### 5. Repositories
- `CarRepository`
- `CustomerRepository`
- `RentalRepository`

Used to:
- Store and retrieve cars, customers and rentals
- Provide data for rental display

---

### 6. Validation & Exceptions
- `ValueValidator` validates:
  - IDs
  - Names
  - Years
  - Dates
- `CarCreateException` is thrown when invalid data is provided
- `CommandException` is thrown when user input is invalid or rental that uses the car exists
- `FileException` is thrown when there was an error while trying to read/write a file

---

## Logic Flow

1. Input is provided as a `String[]`
2. `CarFactory` reads the car type (index 4)
3. The correct subclass is selected from a map
4. The `CarFactory` creates the appropriate subclass of `Car`
5. The `Car` constructor validates base fields
6. Subclasses handle any additional validation
7. A `Rental` object links a car and a customer
8. Data is displayed in a formatted way

---

## Example Flow
Input - CarFactory - Car Created - Rental Created - Output

---

## Error Handling

- Invalid arguments for car creation - `CarCreateException`
- Invalid input - `CommandException`
- Invalid file read/write - `FileException`
- Reflection issues handled in factory
- Safe validation before object creation

---

## Design Decisions

- `Car` constructor is **protected** to enforce inheritance
- Subclass constructors are **public** for factory usage
- Reflection is used to keep factory flexible and extensible

---

## Author
KMarchev 
