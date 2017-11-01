package org.z1key.projects.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by User on 21.01.2017.
 */

@Entity
@Table(name = "pub_houses")
public class PublishHouse extends Organization implements DomainObject {
    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "publishHouse", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<BookDefinition> bookDefinitions;

    public Set<BookDefinition> getBookDefinitions() {
        return bookDefinitions;
    }

    public void setBookDefinitions(Set<BookDefinition> bookDefinitions) {
        this.bookDefinitions = bookDefinitions;
    }
}
