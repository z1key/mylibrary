package org.z1key.projects.service.person;

import org.z1key.projects.entity.Superuser;

import java.util.List;

/**
 * Created by User on 22.01.2017.
 */
public interface SuperuserService{

    Superuser get(int id);

    Superuser get(String login);

    List<Superuser> search(String firstName, String lastName);

    boolean persist(Superuser object);

    boolean delete(Superuser object);

    Superuser delete(int id);
}
