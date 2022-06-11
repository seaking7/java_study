package tk.springLearner.moviebuddy.data;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class CsvMovieReaderTest {

    @Test
    void valid_Metadata() throws Exception {
        CsvMovieReader movieReader = new CsvMovieReader();
        movieReader.setMetadata("movie_metadata.csv");

        movieReader.afterPropertiesSet();
    }

    @Test
    void invalid_Metadata() throws Exception {
        CsvMovieReader movieReader = new CsvMovieReader();
        movieReader.setMetadata("invalid.csv");

        Assertions.assertThatThrownBy(movieReader::afterPropertiesSet).isInstanceOf(FileNotFoundException.class);
    }

}