package tk.springLearner.moviebuddy.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tk.springLearner.moviebuddy.MovieBuddyFactory;
import tk.springLearner.moviebuddy.MovieBuddyProfile;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles(MovieBuddyProfile.CSV_MODE)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MovieBuddyFactory.class)
public class MovieFinderTest {

	final MovieFinder movieFinder;

	@Autowired
	public MovieFinderTest(MovieFinder movieFinder) {
		this.movieFinder = movieFinder;
	}

	@Test
	void notEmpty_directedBy(){
		List<Movie> movies = movieFinder.directedBy("Michael Bay");
		assertThat(movies.size()).isEqualTo(3);
	}

	@Test
	void notEmpty_ReleasedYearBy(){
		List<Movie> movies = movieFinder.releasedYearBy(2015);
		assertThat(movies.size()).isEqualTo(225);
	}
	
}
