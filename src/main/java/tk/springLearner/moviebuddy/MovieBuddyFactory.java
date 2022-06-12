package tk.springLearner.moviebuddy;



import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import tk.springLearner.moviebuddy.data.CachingMovieReader;
import tk.springLearner.moviebuddy.data.CsvMovieReader;
import tk.springLearner.moviebuddy.domain.Movie;
import tk.springLearner.moviebuddy.domain.MovieReader;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@PropertySource("/application.properties")
@ComponentScan(basePackages = "tk.springLearner")
@Import({MovieBuddyFactory.DomainModuleConfig.class, MovieBuddyFactory.DataSourceModuleConfig.class})
public class MovieBuddyFactory {



    @Bean
    public Jaxb2Marshaller jaxb2Marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("tk.springLearner");
        return marshaller;
    }

    @Configuration
    static class DomainModuleConfig{
    }

    @Configuration
    static class DataSourceModuleConfig{

        private final Environment environment;

        public DataSourceModuleConfig(Environment environment) {
            this.environment = environment;
        }

        @Profile(MovieBuddyProfile.CSV_MODE)
        @Bean
        public CsvMovieReader csvMovieReader() throws FileNotFoundException, URISyntaxException {

            CsvMovieReader movieReader = new CsvMovieReader();
            movieReader.setMetadata(environment.getProperty("movie.metadata"));
            return movieReader;
        }

        @Primary
        @Bean
        public MovieReader cachingMovieReader(){
            Cache<String, List<Movie>> cache = Caffeine.newBuilder()
                    .expireAfterWrite(3, TimeUnit.SECONDS)
                    .build();
            CsvMovieReader target = new CsvMovieReader();
            return new CachingMovieReader(cache, target);
        }

//        @Profile(MovieBuddyProfile.XML_MODE)
//        @Bean
//        public XmlMovieReader xmlMovieReader(Unmarshaller unmarshaller) throws FileNotFoundException, URISyntaxException {
//            XmlMovieReader movieReader = new XmlMovieReader(unmarshaller);
//            movieReader.setMetadata("movie_metadata.xml");
//            return movieReader;
//        }
    }

}
