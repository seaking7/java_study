package tk.common.domain;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;

public class Member {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String nickname;

    public Member() {
    }

    public Member(String name, String email, String nickname) {
        this.name = name;
        this.email = email;
        this.nickname = nickname;
    }

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }
}
