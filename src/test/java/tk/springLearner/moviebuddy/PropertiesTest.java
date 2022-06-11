package tk.springLearner.moviebuddy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class PropertiesTest {

    @Test
    void LoadPropertiesFile() throws IOException {
        Properties config = new Properties();
        config.load(Files.newInputStream(Paths.get("./src/test/resources/config.properties")));

        assertThat(config.size()).isEqualTo(1);
        assertThat(config.get("name")).isEqualTo("taekyung");

    }
}
