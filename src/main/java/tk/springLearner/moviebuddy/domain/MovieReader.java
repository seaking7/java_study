package tk.springLearner.moviebuddy.domain;

import tk.springLearner.moviebuddy.domain.Movie;

import java.util.List;

public interface MovieReader {

    public List<Movie> loadMovies();
}
