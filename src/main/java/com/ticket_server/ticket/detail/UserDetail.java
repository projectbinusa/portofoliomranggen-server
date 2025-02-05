package com.ticket_server.ticket.detail;

import com.ticket_server.ticket.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetail implements UserDetails {

    private final User user;

    // Constructor
    public UserDetail(User user) {
        this.user = user;
    }

    // Static factory method to create UserDetail from User
    public static UserDetail buildUser(User user) {
        return new UserDetail(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return role as GrantedAuthority
        return Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword(); // Return user's password
    }

    @Override
    public String getUsername() {
        return user.getUsername(); // Return user's username (email)
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Assuming the account doesn't expire
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Assuming the account is never locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Assuming the credentials never expire
    }

    @Override
    public boolean isEnabled() {
        return true; // Assuming the account is always enabled
    }

    // Get the ID of the user (Long type)
    public Long getId() {
        return user.getId(); // Assuming User has a getId() method that returns a Long
    }

    // Get the role of the user (String type)
    public String getRole() {
        return user.getRole(); // Assuming User has a getRole() method that returns a String
    }
}
