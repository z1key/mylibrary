package org.z1key.projects.service.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.z1key.projects.entity.Reader;
import org.z1key.projects.repository.ReaderRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 21.01.2017.
 */
@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    @Transactional
    @Override
    public Reader persist(Reader object) {
        return readerRepository.saveAndFlush(object);
    }

    @Override
    public List<Reader> getAll() {
        return readerRepository.findAll();
    }

    @Override
    public Reader get(long id) {
        return readerRepository.findOne(id);
    }

    @Override
    public Reader get(String login) {
        return readerRepository.getByLogin(login);
    }

    @Override
    public Reader getByTicket(String ticket) {
        return readerRepository.getByTicket(ticket);
    }

    @Override
    public List<Reader> search(String firstName, String middleName, String lastName) {
        return readerRepository.findByName(firstName, middleName, lastName);
    }

    @Override
    public List<Reader> search(String firstName, String middleName, String lastName, Date birthdate) {
        return readerRepository.findByNameAndDate(firstName,middleName,lastName,birthdate);
    }

    @Override
    public void delete(Reader object) {
        readerRepository.delete(object);
    }
}
