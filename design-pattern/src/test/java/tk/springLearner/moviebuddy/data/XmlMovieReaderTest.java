package tk.springLearner.moviebuddy.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import tk.springLearner.moviebuddy.MovieBuddyFactory;
import tk.springLearner.moviebuddy.MovieBuddyProfile;
import tk.springLearner.moviebuddy.domain.Movie;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles(MovieBuddyProfile.XML_MODE)
@SpringJUnitConfig(MovieBuddyFactory.class)
class XmlMovieReaderTest {

    @Autowired
    XmlMovieReader movieReader;


    @Test
    void NotEmpty_LoadedMovies()
    {
        List<Movie> movies = movieReader.loadMovies();
        assertThat(movies.size()).isEqualTo(1375);
    }

}