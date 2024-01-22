package patterns.example;

import patterns.example.movietype.ChildrenType;
import patterns.example.movietype.MovieType;
import patterns.example.movietype.NewReleaseType;
import patterns.example.movietype.RegularType;
import patterns.example.views.console.ConsoleView;
import patterns.example.views.html.HtmlView;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Rental> rentals = new ArrayList<>();

        MovieType NEW_RELEASE = new NewReleaseType();
        MovieType CHILDREN_TYPE = new ChildrenType();
        MovieType REGULAR_TYPE = new RegularType();

        MovieCatalogue movieCatalogue = MovieCatalogue.getInstance();
        movieCatalogue.addMovie(new Movie.Builder("Rambo", REGULAR_TYPE).build());
        movieCatalogue.addMovie(new Movie.Builder("Lord of the Rings", NEW_RELEASE).build());
        movieCatalogue.addMovie(new Movie.Builder("Harry Potter", CHILDREN_TYPE).director("Quentin Jerome Tarantino").build());

        rentals.add(new Rental(movieCatalogue.findByTitle("Rambo").get(0), 1));
        rentals.add(new Rental(movieCatalogue.findByMovieType(NEW_RELEASE).get(0), 4));
        rentals.add(new Rental(movieCatalogue.findByDirector("Quentin Jerome Tarantino").get(0),5));

        Customer customer = new Customer("John Doe", rentals);

        System.out.println(new HtmlView().generateRecordOutput(customer));
        System.out.println();
        System.out.println(new ConsoleView().generateRecordOutput(customer));
    }
}