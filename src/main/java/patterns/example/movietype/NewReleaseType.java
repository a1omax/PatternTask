package patterns.example.movietype;

public class NewReleaseType implements MovieType{

    @Override
    public double getAmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1 + (daysRented > 1?1:0);
    }
}
