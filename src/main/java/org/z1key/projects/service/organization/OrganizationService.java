package org.z1key.projects.service.organization;

import org.z1key.projects.entity.Address;
import org.z1key.projects.entity.Contact;
import org.z1key.projects.entity.Organization;

/**
 * Created by User on 22.01.2017.
 */
public interface OrganizationService {

    Iterable<Organization> findByName(String name);

    Organization getById(long id);

    Iterable<Organization> getAll();

    Iterable<Contact> getContacts(Organization org);

    Iterable<Organization> findByContact(Contact contact);

//    Iterable<Organization> findByAddress(Address address);

    void delete(Organization organization);

    Organization save(Organization organization);
}
