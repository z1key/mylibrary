package org.z1key.projects.service.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.z1key.projects.entity.Contact;
import org.z1key.projects.entity.Organization;
import org.z1key.projects.repository.OrganizationRepository;

/**
 * Created by User on 02.02.2017.
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;
    @Override
    public Iterable<Organization> findByName(String name) {
        return organizationRepository.findByName(name);
    }

    @Override
    public Organization getById(long id) {
        return organizationRepository.findOne(id);
    }

    @Override
    public Iterable<Organization> getAll() {
        return organizationRepository.findAll();
    }

    @Override
    public Iterable<Contact> getContacts(Organization org) {
        return organizationRepository.getContacts(org);
    }

    @Override
    public Iterable<Organization> findByContact(Contact contact) {
        return organizationRepository.findByContact(contact);
    }

    @Override
    public void delete(Organization organization) {
        organizationRepository.delete(organization);
    }

    @Override
    public Organization save(Organization organization) {
        return organizationRepository.saveAndFlush(organization);
    }
}
