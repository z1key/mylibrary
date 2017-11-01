package org.z1key.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.z1key.projects.entity.Address;
import org.z1key.projects.entity.Contact;
import org.z1key.projects.entity.Organization;

import java.util.List;

/**
 * Created by User on 22.01.2017.
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    @Query("select org from Organization org where org.fullName like concat(:name, '%')")
    List<Organization> findByName(@Param("name") String name);

    @Query("select org.contacts from Organization org where org = :org")
    Iterable<Contact> getContacts(@Param("org") Organization org);

    @Query("select org from Organization org where :contact member of org.contacts")
    Iterable<Organization> findByContact(@Param("contact") Contact contact);

    @Query("select org from Organization org join fetch org.contacts con where :address member of con")
    Iterable<Organization> findByAddress(Address address);
}
