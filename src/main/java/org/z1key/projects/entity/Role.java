package org.z1key.projects.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by User on 08.04.2017.
 */
@Entity
@Table(name = "roles")
public class Role implements DomainObject {

    private static final long serialVersionUID = 1L;

    public static final Role ROLE_SUPERADMIN = new Role("SUPERADMIN");
    public static final Role ROLE_ADMIN = new Role("ADMIN");
    public static final Role ROLE_USER = new Role("USER");

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, updatable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.MERGE)
    private Set<User> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
