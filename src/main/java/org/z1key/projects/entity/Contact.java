package org.z1key.projects.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by User on 21.01.2017.
 */
@Entity
@Table(name = "contacts")
public class Contact implements DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addresses_id")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact")
    private Set<Telephone> telephoneSet;

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Telephone> getTelephoneSet() {
        return telephoneSet;
    }

    public void setTelephoneSet(Set<Telephone> telephoneSet) {
        this.telephoneSet = telephoneSet;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        if (id != contact.id) return false;
        if (address != null ? !address.equals(contact.address) : contact.address != null) return false;
        return telephoneSet != null ? telephoneSet.equals(contact.telephoneSet) : contact.telephoneSet == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (telephoneSet != null ? telephoneSet.hashCode() : 0);
        return result;
    }
}
