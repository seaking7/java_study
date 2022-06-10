package tk.springLearner.moviebuddy.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import tk.springLearner.moviebuddy.ApplicationException;
import tk.springLearner.moviebuddy.MovieBuddyProfile;
import tk.springLearner.moviebuddy.domain.Movie;
import tk.springLearner.moviebuddy.domain.MovieReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Profile(MovieBuddyProfile.XML_MODE)
@Repository
public class JaxbMovieReader implements MovieReader {

    @Override
    public List<Movie> loadMovies() {

        try{
            final JAXBContext jaxb = JAXBContext.newInstance(MovieMetadata.class);
            final Unmarshaller unmarshaller = jaxb.createUnmarshaller();

            final InputStream content = ClassLoader.getSystemResourceAsStream("movie_metadata.xml");
            final Source source = new StreamSource(content);
            final MovieMetadata metadata = (MovieMetadata) unmarshaller.unmarshal(source);

            return metadata.toMovies();
            
        } catch( JAXBException error){
            throw new ApplicationException("failed to load movies data", error);
        }
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

        public List<Movie> toMovies(){
            return movies.stream().map(MovieData::toMovie).collect(Collectors.toList());
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
        private String watchedDate;

        public Movie toMovie(){
            String title = getTitle();
            List<String> genres = getGenres();
            String language = getLanguage();
            String country = getCountry();
            int releaseYear = getReleaseYear();
            String director = getDirector();
            List<String> actors = getActors();
            URL imdbLink = getImdbLink();
            String watchedDate = getWatchedDate();

            return Movie.of(title, genres, language, country, releaseYear, director, actors, imdbLink, watchedDate);
        }

    }
}
