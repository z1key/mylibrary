package org.z1key.projects.entity;

import javax.persistence.*;

/**
 * Created by User on 24.01.2017.
 */
@Entity
@Table(name = "books")
public class Book implements DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "book_definition")
    private BookDefinition bookDefinition;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BookDefinition getBookDefinition() {
        return bookDefinition;
    }

    public void setBookDefinition(BookDefinition bookDefinition) {
        this.bookDefinition = bookDefinition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        return bookDefinition.getId() == book.bookDefinition.getId();

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + bookDefinition.hashCode();
        return result;
    }
}
