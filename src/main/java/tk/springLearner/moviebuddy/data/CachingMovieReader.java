package tk.springLearner.moviebuddy.data;

import com.github.benmanes.caffeine.cache.Cache;
import tk.springLearner.moviebuddy.domain.Movie;
import tk.springLearner.moviebuddy.domain.MovieReader;

import java.util.List;
import java.util.Objects;

public class CachingMovieReader implements MovieReader {

    private final Cache<String, List<Movie>> cache;
    private final MovieReader target;

    public CachingMovieReader(Cache<String, List<Movie>> cache, MovieReader target) {
        this.cache = cache;
        this.target = target;
    }

    @Override
    public List<Movie> loadMovies() {
        //캐시된 데이터가 있으면 즉시 반환 처리
        List<Movie> movies = cache.getIfPresent("csv.movies");
        if(Objects.nonNull(movies) && movies.size()>0){
            return movies;
        }

        //캐시된 데이터가 없으면, 대상 객체에 명령을 위임하고, 반환 받은 값을 캐시에 저장후 반환 처리
        movies = target.loadMovies();

        cache.put("csv.movies", movies);

        return null;
    }

    public List<Movie> getCachedData(){
        List<Movie> movies = cache.getIfPresent("csv.movies");
        return movies;
    }
}
