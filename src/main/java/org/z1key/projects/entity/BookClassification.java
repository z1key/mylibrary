package org.z1key.projects.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by User on 21.01.2017.
 */
@Entity
@Table(name = "book_classifications")
public class BookClassification implements DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    private long id;

    @Column
    private String name;

    @Column(name = "index1")
    private int index1;

    @Column(name = "sub_index")
    private int subIndex;

    @Column(name = "sub_sub_index")
    private int subSubIndex;

    @Column
    private String description;

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

    public int getIndex1() {
        return index1;
    }

    public void setIndex(int index) {
        this.index1 = index;
    }

    public int getSubIndex() {
        return subIndex;
    }

    public void setSubIndex(int subIndex) {
        this.subIndex = subIndex;
    }

    public int getSubSubIndex() {
        return subSubIndex;
    }

    public void setSubSubIndex(int subSubIndex) {
        this.subSubIndex = subSubIndex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookClassification)) return false;

        BookClassification that = (BookClassification) o;

        if (id != that.id) return false;
        if (index1 != that.index1) return false;
        if (subIndex != that.subIndex) return false;
        if (subSubIndex != that.subSubIndex) return false;
        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + index1;
        result = 31 * result + subIndex;
        result = 31 * result + subSubIndex;
        return result;
    }
}
