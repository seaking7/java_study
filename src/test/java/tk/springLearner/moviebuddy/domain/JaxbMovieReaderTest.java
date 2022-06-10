package tk.springLearner.moviebuddy.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JaxbMovieReaderTest {

    @Test
    void NotEmpty_LoadedMovies()
    {
        JaxbMovieReader movieReader = new JaxbMovieReader();

        List<Movie> movies = movieReader.loadMovies();
        assertThat(movies.size()).isEqualTo(1375);
    }

}