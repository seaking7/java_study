package tk.springLearner.moviebuddy.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import tk.springLearner.moviebuddy.MovieBuddyFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(MovieBuddyFactory.class)
class JaxbMovieReaderTest {
    JaxbMovieReader movieReader;

    @Autowired
    public JaxbMovieReaderTest(JaxbMovieReader movieReader) {
        this.movieReader = movieReader;
    }

    @Test
    void NotEmpty_LoadedMovies()
    {
        List<Movie> movies = movieReader.loadMovies();
        assertThat(movies.size()).isEqualTo(1375);
    }

}