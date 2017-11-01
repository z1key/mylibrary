package org.z1key.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.z1key.projects.entity.Reader;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 21.01.2017.
 */
public interface ReaderRepository extends JpaRepository<Reader, Long> {

    @Query("select reader from Reader reader where reader.login = ?1")
    Reader getByLogin(String login);

    @Query("select reader from Reader reader where reader.ticket = ?1")
    Reader getByTicket(String ticket);

    @Query("select reader from Reader reader where reader.firstName like concat(:first, '%') and reader.lastName like concat(:last, '%') and reader.middleName like concat(:middle, '%')")
    List<Reader> findByName(@Param("first") String firstname, @Param(value = "middle") String middle, @Param("last") String lastname);

    @Query("select reader from Reader reader where reader.firstName like concat(:first, '%') and" +
            " reader.lastName like concat(:last, '%') and" +
            " reader.middleName like concat(:middle, '%') and" +
            " reader.birthDate = :birthdate")
    List<Reader> findByNameAndDate(@Param("first") String firstname,
                                   @Param(value = "middle") String middle,
                                   @Param("last") String lastname,
                                   @Param("birthdate") Date birthdate);
}
