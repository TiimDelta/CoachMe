package Delta.CoachMeSpring.user;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User implements UserDetails{
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private int numOfPets;
    @Column(unique=true)
    private String email;

    @Transient
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Transient
    @JsonIgnore
    @Override
    public String getPassword() {
        return null;
    }

    @Transient
    @JsonIgnore
    @Override
    public String getUsername() {
        return getEmail();
    }

    @Transient
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Transient
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Transient
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Transient
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}

