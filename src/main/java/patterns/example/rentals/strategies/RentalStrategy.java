package patterns.example.rentals.strategies;

import java.io.Serializable;

public interface RentalStrategy extends Serializable {
    double getAmount(int daysRented);
    int getFrequentRenterPoints(int daysRented);
}
