package org.z1key.projects.entity;

import javax.persistence.*;

/**
 * Created by User on 21.01.2017.
 */

@Entity
@Table(name = "addresses")
public class Address implements DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String country;

    @Column
    private String state;

    @Column
    private String region;

    @Column
    private String city;

    @Column
    private String street;

    @Column(name = "house_line_1")
    private String houseLine1;

    @Column(name = "house_line_2")
    private String getHouseLine2;

    @Column(name = "postal_code")
    private String postalCode;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address", fetch = FetchType.EAGER)
    private Contact contact;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseLine1() {
        return houseLine1;
    }

    public void setHouseLine1(String houseLine1) {
        this.houseLine1 = houseLine1;
    }

    public String getGetHouseLine2() {
        return getHouseLine2;
    }

    public void setGetHouseLine2(String getHouseLine2) {
        this.getHouseLine2 = getHouseLine2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (id != address.id) return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (state != null ? !state.equals(address.state) : address.state != null) return false;
        if (region != null ? !region.equals(address.region) : address.region != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (houseLine1 != null ? !houseLine1.equals(address.houseLine1) : address.houseLine1 != null) return false;
        if (getHouseLine2 != null ? !getHouseLine2.equals(address.getHouseLine2) : address.getHouseLine2 != null)
        if (contact != null && address.getContact() != null ? !(contact.getId() == address.getContact().getId()) : address.getContact() != null)
            return false;
        return postalCode != null ? postalCode.equals(address.postalCode) : address.postalCode == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (houseLine1 != null ? houseLine1.hashCode() : 0);
        result = 31 * result + (getHouseLine2 != null ? getHouseLine2.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        return result;
    }
}
