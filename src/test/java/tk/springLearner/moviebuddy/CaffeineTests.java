package tk.springLearner.moviebuddy;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;


public class CaffeineTests {

    @Test
    void useCache() throws InterruptedException {
        Cache<String, Object> cache = Caffeine.newBuilder()
                .expireAfterWrite(200, TimeUnit.MILLISECONDS)
                .maximumSize(100)
                .build();

        String key = "springrunner";
        Object value = new Object();
        Assertions.assertThat(cache.getIfPresent(key)).isNull();

        cache.put(key, value);
        Assertions.assertThat(cache.getIfPresent(key)).isEqualTo(value);

        TimeUnit.MILLISECONDS.sleep(100);
        Assertions.assertThat(cache.getIfPresent(key)).isEqualTo(value);
        TimeUnit.MILLISECONDS.sleep(200);
        Assertions.assertThat(cache.getIfPresent(key)).isNull();
    }
}
