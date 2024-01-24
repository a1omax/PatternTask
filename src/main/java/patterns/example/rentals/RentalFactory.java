package patterns.example.rentals;

import patterns.example.movies.Movie;
import patterns.example.rentals.strategies.ChildrenStrategy;
import patterns.example.rentals.strategies.NewReleaseStrategy;
import patterns.example.rentals.strategies.RegularStrategy;
import patterns.example.rentals.strategies.RentalStrategy;

abstract public class RentalFactory {

    public static Rental createRental(Movie movie, int daysRented){

        RentalStrategy rentalStrategy;
        switch (movie.getMovieType()){
            case CHILDREN -> rentalStrategy = new ChildrenStrategy();
            case NEW_RELEASE -> rentalStrategy = new NewReleaseStrategy();
            default -> rentalStrategy = new RegularStrategy();
        }
        return new Rental(movie, daysRented, rentalStrategy);
    }
}
