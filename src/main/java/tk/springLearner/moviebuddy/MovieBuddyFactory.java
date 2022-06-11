package tk.springLearner.moviebuddy;

import org.springframework.context.annotation.*;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import tk.springLearner.moviebuddy.data.CsvMovieReader;
import tk.springLearner.moviebuddy.data.XmlMovieReader;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

@Configuration
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

        @Profile(MovieBuddyProfile.CSV_MODE)
        @Bean
        public CsvMovieReader csvMovieReader() throws FileNotFoundException, URISyntaxException {
            CsvMovieReader movieReader = new CsvMovieReader();
            movieReader.setMetadata("movie_metadata.csv");
            return movieReader;
        }

        @Profile(MovieBuddyProfile.XML_MODE)
        @Bean
        public XmlMovieReader xmlMovieReader(Unmarshaller unmarshaller) throws FileNotFoundException, URISyntaxException {
            XmlMovieReader movieReader = new XmlMovieReader(unmarshaller);
            movieReader.setMetadata("movie_metadata.xml");
            return movieReader;
        }
    }

}
