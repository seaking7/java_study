package tk.springLearner.moviebuddy;

import tk.springLearner.moviebuddy.domain.CsvMovieReader;
import tk.springLearner.moviebuddy.domain.MovieFinder;

public class MovieBuddyFactory {

    public MovieFinder movieFinder(){
        return new MovieFinder(new CsvMovieReader());
    }
}
