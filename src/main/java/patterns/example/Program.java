package patterns.example;

import patterns.example.customers.Customer;
import patterns.example.movies.Movie;
import patterns.example.movies.MovieCatalogue;
import patterns.example.movies.MovieFinder;
import patterns.example.movies.MovieType;
import patterns.example.rentals.RentalFactory;
import patterns.example.views.console.ConsoleView;
import patterns.example.views.html.HtmlView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Program {

    static final String FILE_NAME = "src/main/resources/serialized_data.dat";

    List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        Program program = new Program();
        program.runWithoutLoadingFromFile();

        program.runWithLoadingFromFile();
    }

    public void runWithLoadingFromFile() {

        loadObjectsFromFile();

        // Some new changes here

        createHTMLOutputsForAllCustomers();
        createConsoleOutputForAllCustomers();

        saveObjectsInFile();
    }

    public void runWithoutLoadingFromFile() {
        addSomeMovies();
        addSomeCustomers();

        saveObjectsInFile();
    }


    private boolean loadObjectsFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<Movie> movies = (List<Movie>) in.readObject();
            MovieCatalogue.getInstance().setMovies(movies);
            customers = (List<Customer>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Can't load from file");
            return false;
        }
        return true;
    }

    private boolean saveObjectsInFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(MovieCatalogue.getInstance().getMovies());
            out.writeObject(customers);
        } catch (IOException e) {
            System.err.println("Can't save in file");
            return false;
        }
        return true;
    }

    private void addSomeMovies() {
        MovieCatalogue movieCatalogue = MovieCatalogue.getInstance();
        movieCatalogue.addMovie(new Movie.Builder("Rambo", MovieType.REGULAR).build());
        movieCatalogue.addMovie(new Movie.Builder("Lord of the Rings", MovieType.NEW_RELEASE).build());
        movieCatalogue.addMovie(new Movie.Builder("Harry Potter", MovieType.CHILDREN).director("Quentin Jerome Tarantino").build());
    }

    private void addSomeCustomers() {
        Movie movie;
        MovieCatalogue movieCatalogue = MovieCatalogue.getInstance();

        Customer patric = new Customer("Patric");
        movie = MovieFinder.findByTitle(movieCatalogue.getMovies(), "Rambo").get(0);
        patric.addRental(RentalFactory.createRental(movie, 1));

        Customer john = new Customer("John Doe");
        movie = MovieFinder.findByMovieType(movieCatalogue.getMovies(), MovieType.REGULAR).get(0);
        john.addRental(RentalFactory.createRental(movie, 5));

        movie = MovieFinder.findByDirector(movieCatalogue.getMovies(), "Quentin Jerome Tarantino").get(0);
        john.addRental(RentalFactory.createRental(movie, 4));

        customers.add(patric);
        customers.add(john);
    }

    private void createHTMLOutputsForAllCustomers() {
        for (Customer customer : customers) {
            System.out.println(new HtmlView().generateRecordOutput(customer));
            System.out.println();
        }
    }

    private void createConsoleOutputForAllCustomers() {
        for (Customer customer : customers) {
            System.out.println(new ConsoleView().generateRecordOutput(customer));
            System.out.println();
        }
    }
}
