package tk.springLearner.moviebuddy.data;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;
import tk.springLearner.moviebuddy.domain.Movie;
import tk.springLearner.moviebuddy.domain.MovieReader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CachingMovieReaderTest {

    @Test
    void caching(){
        Cache<String, List<Movie>> cache = Caffeine.newBuilder()
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build();

        MovieReader target = new DummyMovieReader();
        CachingMovieReader cachingMovieReader = new CachingMovieReader(cache,target);
        List<Movie> movies = cachingMovieReader.loadMovies();
        Assertions.assertThat(cachingMovieReader.getCachedData()).isNotNull();
        Assertions.assertThat(cachingMovieReader.loadMovies()).isEqualTo(movies);
    }

    class DummyMovieReader implements MovieReader{

        @Override
        public List<Movie> loadMovies() {
            return new ArrayList<>();
        }
    }

}