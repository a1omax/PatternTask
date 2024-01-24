package patterns.example.movies;

import java.util.List;
import java.util.stream.Collectors;

abstract public class MovieFinder {
    public static List<Movie> findByTitle(List<Movie>movies, String title) {
        return movies.stream().filter(movie -> movie.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }

    public static List<Movie> findByMovieType(List<Movie>movies, MovieType movieType) {
        return movies.stream().filter(movie -> movie.getMovieType().equals(movieType)).collect(Collectors.toList());

    }

    public static List<Movie> findByCountry(List<Movie>movies, String country) {
        return movies.stream().filter(movie -> movie.getCountry().equalsIgnoreCase(country)).collect(Collectors.toList());
    }

    public static List<Movie> findByActor(List<Movie>movies, String actor) {
        return movies.stream().filter(movie -> movie.getActors().contains(actor)).collect(Collectors.toList());
    }

    public static List<Movie> findByDirector(List<Movie>movies, String director) {
        return movies.stream().filter(movie -> movie.getDirector().equalsIgnoreCase(director)).collect(Collectors.toList());
    }

}
