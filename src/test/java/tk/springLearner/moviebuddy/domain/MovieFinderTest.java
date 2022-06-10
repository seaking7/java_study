package tk.springLearner.moviebuddy.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tk.springLearner.moviebuddy.MovieBuddyFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * @author springrunner.kr@gmail.com
 */
public class MovieFinderTest {
	final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MovieBuddyFactory.class);
	final MovieFinder movieFinder = applicationContext.getBean(MovieFinder.class);

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
