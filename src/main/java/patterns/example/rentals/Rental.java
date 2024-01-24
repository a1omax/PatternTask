package patterns.example.rentals;


import patterns.example.movies.Movie;
import patterns.example.rentals.strategies.RentalStrategy;

import java.io.Serializable;


public class Rental implements Serializable {
    private final Movie movie;
    private final int daysRented;
    private final RentalStrategy rentStrategy;
    Rental(Movie movie, int daysRented, RentalStrategy rentStrategy) {
        this.movie = movie;
        this.daysRented = daysRented;
        this.rentStrategy = rentStrategy;

    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getAmount(){
        return rentStrategy.getAmount(this.daysRented);
    }
    public int getFrequentRenterPoints(){
        return rentStrategy.getFrequentRenterPoints(this.daysRented);
    }
}
