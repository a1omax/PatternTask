package patterns.example.customers;


import patterns.example.rentals.Rental;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Customer implements Serializable {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;

    }

    public void addRental(Rental rental){
        if (!rentals.contains(rental)){
            rentals.add(rental);
        }
    }
    public void removeRental(Rental rental){
        rentals.remove(rental);
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals(){
        return rentals;
    }

    public double getTotalAmount(){
        double totalAmount = 0;
        for (Rental rental: rentals){
            totalAmount += rental.getAmount();
        }
        return totalAmount;
    }
    public double getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental: rentals){
            frequentRenterPoints+=rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

}