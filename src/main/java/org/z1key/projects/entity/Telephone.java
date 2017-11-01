package org.z1key.projects.entity;

import javax.persistence.*;

/**
 * Created by User on 21.01.2017.
 */

@Entity
@Table(name = "telephones")
public class Telephone implements DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    private long id;

    @Column(name = "country_code", nullable = false)
    private int countryCode;

    @Column(name = "region_code", nullable = false)
    private int regionCode;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "contacts_id")
    private Contact contact;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(int regionCode) {
        this.regionCode = regionCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Telephone telephone = (Telephone) o;

        if (id != telephone.id) return false;
        if (countryCode != telephone.countryCode) return false;
        if (regionCode != telephone.regionCode) return false;
        return number == telephone.number;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + countryCode;
        result = 31 * result + regionCode;
        result = 31 * result + number;
        return result;
    }
}
