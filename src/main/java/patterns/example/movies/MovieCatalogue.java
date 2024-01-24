package patterns.example.movies;

import java.util.*;

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

    public void setMovies(List<Movie> movies){
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return this.movies;
    }
}
