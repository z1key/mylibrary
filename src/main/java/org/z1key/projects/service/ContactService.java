package org.z1key.projects.service;

import org.z1key.projects.entity.Contact;

/**
 * Created by User on 22.01.2017.
 */
public interface ContactService {

    Contact get(long id);

    boolean persist(Contact contact);

    Contact delete(Contact object);
}
