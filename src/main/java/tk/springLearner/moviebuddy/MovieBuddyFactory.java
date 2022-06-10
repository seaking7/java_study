package tk.springLearner.moviebuddy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import tk.springLearner.moviebuddy.domain.CsvMovieReader;
import tk.springLearner.moviebuddy.domain.MovieFinder;
import tk.springLearner.moviebuddy.domain.MovieReader;

@Configuration
@Import({MovieBuddyFactory.DomainModuleConfig.class, MovieBuddyFactory.DataSourceModuleConfig.class})
public class MovieBuddyFactory {

    @Configuration
    static class DomainModuleConfig{
        @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)   //요청시 마다 다른 Bean 이 필요할때
        public MovieFinder movieFinder(MovieReader movieReader){
            return new MovieFinder(movieReader);
        }
    }

    @Configuration
    static class DataSourceModuleConfig{
        @Bean
        public MovieReader movieReader(){
            return new CsvMovieReader();
        }
    }



}
