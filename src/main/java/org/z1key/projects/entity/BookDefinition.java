package org.z1key.projects.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by User on 21.01.2017.
 */
@Entity
@Table(name = "book_definitions")
public class BookDefinition implements DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    private long id;

    @Column
    private String title;

    @Column(name = "alt_title")
    private String altTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "general_author_id")
    private Author generalAuthor;

    @ManyToMany
    @JoinTable(name = "book_definitions_has_authors",
            joinColumns =        @JoinColumn(name = "book_definitions_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authors_id", referencedColumnName = "id"))
    private Set<Author> authors;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, targetEntity = BookDefinition.class)
    @JoinColumn(name = "pub_house_id")
    private PublishHouse publishHouse;

    @Column
    private int year;

//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JoinColumn(name = "book_classification_id", referencedColumnName = "id")
    private BookClassification bookClassification;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

    @Column
    private int edition;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bookDefinition")
    private Set<Book> books;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAltTitle() {
        return altTitle;
    }

    public void setAltTitle(String altTitle) {
        this.altTitle = altTitle;
    }

    public Author getGeneralAuthor() {
        return generalAuthor;
    }

    public void setGeneralAuthor(Author generalAuthor) {
        this.generalAuthor = generalAuthor;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public PublishHouse getPublishHouse() {
        return publishHouse;
    }

    public void setPublishHouse(PublishHouse publishHouse) {
        this.publishHouse = publishHouse;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BookClassification getBookClassification() {
        return bookClassification;
    }

    public void setBookClassification(BookClassification bookClassification) {
        this.bookClassification = bookClassification;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookDefinition)) return false;

        BookDefinition that = (BookDefinition) o;

        if (id != that.id) return false;
        if (year != that.year) return false;
        if (edition != that.edition) return false;
        if (!title.equals(that.title)) return false;
        if (altTitle != null ? !altTitle.equals(that.altTitle) : that.altTitle != null) return false;
        if (generalAuthor != null && that.getGeneralAuthor() != null ? !(generalAuthor.getId() == that.generalAuthor.getId()) : that.generalAuthor != null) return false;
        if (authors != null ? !authors.equals(that.authors) : that.authors != null) return false;
        if (publishHouse != null && that.getPublishHouse() != null ? !(publishHouse.getId() == that.publishHouse.getId()) : that.publishHouse != null) return false;
        if (bookClassification != null && that.getBookClassification() != null ? !(bookClassification.getId() == that.bookClassification.getId()) : that.bookClassification != null)
            return false;
        return genre != null && that.getGenre() != null ? genre.getId() == that.genre.getId() : that.genre == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + (altTitle != null ? altTitle.hashCode() : 0);
        result = 31 * result + (generalAuthor != null ? generalAuthor.hashCode() : 0);
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        result = 31 * result + (publishHouse != null ? publishHouse.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (bookClassification != null ? bookClassification.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + edition;
        return result;
    }
}
