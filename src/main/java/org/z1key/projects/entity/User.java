package org.z1key.projects.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.z1key.projects.entity.Role.ROLE_ADMIN;
import static org.z1key.projects.entity.Role.ROLE_SUPERADMIN;

/**
 * Created by User on 10.01.2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User implements DomainObject {

    private static final long serialVersionUID = 1L;
    
    public User(){}
    public User(String login, String password, String email, Role role) {
        this.roles = new HashSet<Role>(){{add(role);}};
        this.login = login;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    protected long id;

    @Column(name = "firstname")
    protected String firstName;

    @Column(name = "middlename")
    protected String middleName;

    @Column(name = "lastname")
    protected String lastName;

    @Column(name = "email", nullable = false, unique = true)
    protected String email;

    @ManyToMany(cascade = CascadeType.ALL)
    protected Set<Role> roles;

    @Column(name = "login", nullable = false, unique = true)
    protected String login;

    @Column(name = "password", nullable = false)
    protected String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isAdmin() {
        for (Role role : getRoles()) {
            if (ROLE_ADMIN.getName().equals(role.getName()) || ROLE_SUPERADMIN.getName().equals(role.getName())) return true;
        }
        return false;
    }
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role : getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User that = (User) o;

        if (id != that.id) return false;
        if (!firstName.equals(that.firstName)) return false;
        if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (!email.equals(that.email)) return false;
        return login.equals(that.login);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + lastName.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  "id:" + id +
                ", firstName:'" + firstName + '\'' +
                ", middleName:'" + middleName + '\'' +
                ", lastName:'" + lastName + '\'' +
                ", login:'" + login + '\'' +
                ", password:'" + password + '\'' +
                '}';
    }
}
