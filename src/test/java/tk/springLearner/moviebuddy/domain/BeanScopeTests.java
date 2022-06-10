package tk.springLearner.moviebuddy.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tk.springLearner.moviebuddy.MovieBuddyFactory;

public class BeanScopeTests {

    @Test
    void Equals_MovieFinderBean(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MovieBuddyFactory.class);
        MovieFinder movieFinder = applicationContext.getBean(MovieFinder.class);

        Assertions.assertThat(applicationContext.getBean(MovieFinder.class)).isEqualTo(movieFinder);
    }
}
