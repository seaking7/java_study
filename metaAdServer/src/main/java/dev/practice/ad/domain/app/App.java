package dev.practice.ad.domain.app;

import dev.practice.ad.common.exception.InvalidParamException;
import dev.practice.ad.common.util.TokenGenerator;
import dev.practice.ad.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "m_app")
public class App extends AbstractEntity {
    private static final String PREFIX_PARTNER = "app_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String appId;
    private String appName;
    private String appKey;
    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ENABLE("정상"), STOP("중지"), CLOSE("종료");
        private final String description;
    }

    @Builder
    public App(String appId, String appName) {
        if (StringUtils.isEmpty(appId)) throw new InvalidParamException("empty appId");
        this.appId = appId;
        this.appName = appName;
        this.appKey = TokenGenerator.randomCharacterWithPrefix(PREFIX_PARTNER);
        this.status = Status.ENABLE;
    }

    public void enable() {
        this.status = Status.ENABLE;
    }

    public void disable() {
        this.status = Status.CLOSE;
    }
}
