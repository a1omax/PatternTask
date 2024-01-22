package patterns.example;

import java.util.List;
public class Customer {
    private final String name;
    private final List<Rental> rentals;

    public Customer(String name, List<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
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
            totalAmount += rental.getMovie().getMovieType().getAmount(rental.getDaysRented());
        }
        return totalAmount;
    }
    public double getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental: rentals){
            frequentRenterPoints+=rental.getMovie().getMovieType().getFrequentRenterPoints(rental.getDaysRented());
        }
        return frequentRenterPoints;
    }

}