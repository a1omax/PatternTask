package patterns.example.movies;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// todo Save it somewhere
public class Movie implements Serializable {
    private final String title;
    private final MovieType movieType;
    private final String country;
    private final String description;
    private final String director;
    private final List<String> actors = new ArrayList<>();

    private Movie(Builder builder) {
        this.title = builder.title;
        this.movieType = builder.movieType;
        this.country = builder.country;
        this.description = builder.description;
        this.director = builder.director;
        this.actors.addAll(builder.actors);
    }

    public String getTitle() {
        return title;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return director;
    }

    public List<String> getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", movieType=" + movieType +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                '}';
    }

    public static class Builder {
        private String title;
        private MovieType movieType;
        private String country = "";
        private String description = "";
        private String director = "";

        private List<String> actors = new ArrayList<>();

        public Builder(String title, MovieType movieType){
            this.title = title;
            this.movieType = movieType;
        }
        public Builder title(String title){
            this.title = title;
            return this;
        }
        public Builder movieType(MovieType movieType){
            this.movieType = movieType;
            return this;
        }

        public Builder country(String country){
            this.country = country;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder director(String director){
            this.director = director;
            return this;
        }

        public Builder actors(List<String> actors){
            this.actors = actors;
            return this;
        }
        public Movie build(){
            return new Movie(this);
        }
    }

}