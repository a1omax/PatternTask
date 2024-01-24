package patterns.example.rentals.strategies;

public class NewReleaseStrategy implements RentalStrategy {

    @Override
    public double getAmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1 + (daysRented > 1?1:0);
    }
}
