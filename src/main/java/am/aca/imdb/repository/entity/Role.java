package am.aca.imdb.repository.entity;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

public enum  Role implements GrantedAuthority {
    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
