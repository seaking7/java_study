package tk.springLearner.moviebuddy.domain;

import lombok.Getter;
import lombok.Setter;
import tk.springLearner.moviebuddy.ApplicationException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class JaxbMovieReader implements MovieReader{

    @Override
    public List<Movie> loadMovies() {

        try{
            final JAXBContext jaxb = JAXBContext.newInstance(MovieMetadata.class);
            final Unmarshaller unmarshaller = jaxb.createUnmarshaller();

            final InputStream content = ClassLoader.getSystemResourceAsStream("movie_metadata.xml");
            final Source source = new StreamSource(content);
            final MovieMetadata metadata = (MovieMetadata) unmarshaller.unmarshal(source);

            
        } catch( JAXBException error){
            throw new ApplicationException("failed to load movies data", error);
        }
        return null;
    }

    @XmlRootElement(name = "moviemetadata")
    public static class MovieMetadata{
        private List<MovieData> movies;

        public List<MovieData> getMovies() {
            return movies;
        }

        public void setMovies(List<MovieData> movies) {
            this.movies = movies;
        }
    }

    @Getter
    @Setter
    public static class MovieData{
        private String title;
        private List<String> genres;
        private String language;
        private String country;
        private int releaseYear;
        private String director;
        private List<String> actors;
        private URL imdbLink;
        private String watchedData;


    }
}
