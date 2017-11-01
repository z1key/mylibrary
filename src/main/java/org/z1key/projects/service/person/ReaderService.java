package org.z1key.projects.service.person;

import org.z1key.projects.entity.Reader;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 22.01.2017.
 */
public interface ReaderService {
    Reader persist(Reader object);

    List<Reader> getAll();

    Reader get(long id);

    Reader get(String login);

    Reader getByTicket(String ticket);



    List<Reader> search(String firstName, String middleName, String lastName);

    List<Reader> search(String firstName, String middleName, String lastName, Date birthdate);

    void delete(Reader object);
}
