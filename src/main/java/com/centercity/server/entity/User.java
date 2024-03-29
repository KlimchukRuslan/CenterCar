package com.centercity.server.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "t_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=2, message = "Не меньше 5 знаков")

    private String username;
    @Size(min=2, message = "Не меньше 5 знаков")

    private String email;
    @Size(min=2, message = "Не меньше 5 знаков")

    private String pone_number;

    @Size(min=2, message = "Не меньше 5 знаков")

    private String driver_code;

    @Size(min=2, message = "Не меньше 5 знаков")

    private String password;
    @Size(min=2, message = "Не меньше 5 знаков")

    private String kurator;
    @Size(min=2, message = "Не меньше 5 знаков")

    @Transient
    private String passwordConfirm;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
    public User() {
    }

    public String getPone_number() {
        return pone_number;
    }

    public void setPone_number(String pone_number) {
        this.pone_number = pone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriver_code() {
        return driver_code;
    }

    public void setDriver_code(String driver_code) {
        this.driver_code = driver_code;
    }

    public String getKurator() {
        return kurator;
    }

    public void setKurator(String kurator) {
        this.kurator = kurator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}

