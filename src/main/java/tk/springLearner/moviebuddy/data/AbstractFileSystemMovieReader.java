package tk.springLearner.moviebuddy.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.springLearner.moviebuddy.ApplicationException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public abstract class AbstractFileSystemMovieReader {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private String metadata;

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) throws FileNotFoundException, URISyntaxException {
        this.metadata = Objects.requireNonNull(metadata, "metadata is required value");
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        URL metadataURl = ClassLoader.getSystemResource(metadata);
        if (Objects.isNull(metadataURl)) {
            throw new FileNotFoundException(metadata);
        }
        if (!Files.isReadable(Path.of(metadataURl.toURI()))) {
            throw new ApplicationException(String.format("cannot read to metadata [%s]", metadata));
        }
    }

    @PreDestroy
    public void destroy() throws Exception {
        log.info("Destroyed bean");
    }
}
