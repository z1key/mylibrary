package org.z1key.projects.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 21.01.2017.
 */
@Entity
@Table(name = "readers")
public class Reader extends User {
    private static final long serialVersionUID = 1L;
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "ticket")
    private String ticket;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
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
        if (!(o instanceof Reader)) return false;
        if (!super.equals(o)) return false;

        Reader reader = (Reader) o;

        if (id != reader.id) return false;
        if (birthDate != null ? !birthDate.equals(reader.birthDate) : reader.birthDate != null) return false;
        if (ticket != null ? !ticket.equals(reader.ticket) : reader.ticket != null) return false;
        return organization != null ? organization.equals(reader.organization) : reader.organization == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (ticket != null ? ticket.hashCode() : 0);
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", birthDate:" + birthDate +
                ", ticket:" + ticket +
                ", organization:" + organization +
                '}';
    }
}
