package patterns.example;

import patterns.example.movietype.MovieType;

import java.util.*;
import java.util.stream.Collectors;

public class MovieCatalogue {

    private static MovieCatalogue instance = null;
    List<Movie> movies = new ArrayList<>();

    private MovieCatalogue() {
    }

    public static MovieCatalogue getInstance() {
        if (instance == null) {
            instance = new MovieCatalogue();
        }
        return instance;
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }


    public List<Movie> findByTitle(String title) {
        return movies.stream().filter(movie -> movie.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }

    public List<Movie> findByMovieType(MovieType movieType) {
        return movies.stream().filter(movie -> movie.getMovieType().equals(movieType)).collect(Collectors.toList());

    }

    public List<Movie> findByCountry(String country) {
        return movies.stream().filter(movie -> movie.getCountry().equalsIgnoreCase(country)).collect(Collectors.toList());
    }

    public List<Movie> findByActor(String actor) {
        return movies.stream().filter(movie -> movie.getActors().contains(actor)).collect(Collectors.toList());
    }

    public List<Movie> findByDirector(String director) {
        return movies.stream().filter(movie -> movie.getDirector().equalsIgnoreCase(director)).collect(Collectors.toList());
    }

    public List<Movie> getMovies() {
        return this.movies;
    }
}
