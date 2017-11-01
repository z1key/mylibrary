package org.z1key.projects.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by User on 21.01.2017.
 */
@Entity
@Table(name = "authors")
public class Author implements DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "pseudo_firstname")
    private String pseudoFirstName;

    @Column(name = "pseudo_lastname")
    private String pseudoLastName;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "birthdate")
    private Date   birthDate;

    @Column(name = "deathdate")
    private Date   deathDate;

    @ManyToMany
    @JoinTable(name = "book_definitions_has_authors",
                joinColumns = @JoinColumn(name = "authors_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "book_definitions_id", referencedColumnName = "id"))
    private Set<BookDefinition> bookDefinitionSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudoFirstName() {
        return pseudoFirstName;
    }

    public void setPseudoFirstName(String pseudoFirstName) {
        this.pseudoFirstName = pseudoFirstName;
    }

    public String getPseudoLastName() {
        return pseudoLastName;
    }

    public void setPseudoLastName(String pseudoLastName) {
        this.pseudoLastName = pseudoLastName;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public Set<BookDefinition> getBookDefinitionSet() {
        return bookDefinitionSet;
    }

    public void setBookDefinitionSet(Set<BookDefinition> bookDefinitionSet) {
        this.bookDefinitionSet = bookDefinitionSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

        if (id != author.id) return false;
        if (pseudoFirstName != null ? !pseudoFirstName.equals(author.pseudoFirstName) : author.pseudoFirstName != null)
            return false;
        if (pseudoLastName != null ? !pseudoLastName.equals(author.pseudoLastName) : author.pseudoLastName != null)
            return false;
        if (firstName != null ? !firstName.equals(author.firstName) : author.firstName != null) return false;
        if (middleName != null ? !middleName.equals(author.middleName) : author.middleName != null) return false;
        if (lastName != null ? !lastName.equals(author.lastName) : author.lastName != null) return false;
        if (birthDate != null ? !birthDate.equals(author.birthDate) : author.birthDate != null) return false;
        return deathDate != null ? deathDate.equals(author.deathDate) : author.deathDate == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (pseudoFirstName != null ? pseudoFirstName.hashCode() : 0);
        result = 31 * result + (pseudoLastName != null ? pseudoLastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (deathDate != null ? deathDate.hashCode() : 0);
        return result;
    }
}
