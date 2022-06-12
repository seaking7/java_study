package tk.springLearner.moviebuddy.data;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;
import tk.springLearner.moviebuddy.domain.Movie;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.TimeUnit;

class CsvMovieReaderTest {

    @Test
    void valid_Metadata() throws Exception {

        CsvMovieReader movieReader = new CsvMovieReader();
        movieReader.setMetadata("movie_metadata.csv");
        movieReader.setResourceLoader(new DefaultResourceLoader());

        movieReader.afterPropertiesSet();
    }

    @Test
    void invalid_Metadata() throws Exception {

        CsvMovieReader movieReader = new CsvMovieReader();
        movieReader.setMetadata("invalid.csv");
        movieReader.setResourceLoader(new DefaultResourceLoader());

        Assertions.assertThatThrownBy(movieReader::afterPropertiesSet).isInstanceOf(FileNotFoundException.class);
    }

}