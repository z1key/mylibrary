package org.z1key.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.z1key.projects.entity.Contact;

/**
 * Created by User on 22.01.2017.
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
