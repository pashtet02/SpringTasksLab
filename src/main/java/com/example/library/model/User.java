package com.example.library.model;

import com.example.library.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "user_sequence",
            sequenceName = "user_sequence",
        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "user_sequence")
    private long id;

    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;

    private String password;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name="user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    private double fine;
    private String userLocale;
    private String firstName;
    private String lastName;
    private Boolean locked = false;
    private Boolean enabled = false;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> lst = new ArrayList<>();
        for (Role role: roles) {
            lst.add(new SimpleGrantedAuthority(role.name()));
        }
        return lst;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
    @Override
    public String getPassword(){
        return password;
    }
    @Override
    public String getUsername(){
        return username;
    }

    public User(String username, String email, String password, Set<Role> roles, double fine, String userLocale, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.fine = fine;
        this.userLocale = userLocale;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
