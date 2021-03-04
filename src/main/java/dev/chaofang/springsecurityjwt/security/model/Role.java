package dev.chaofang.springsecurityjwt.security.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

public enum Role {
    ADMIN,
    USER;

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        return Set.of(new SimpleGrantedAuthority("ROLE_" + this.name()));
    }
}
