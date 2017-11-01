package org.z1key.projects.service.book;

import org.z1key.projects.entity.BookDefinition;

import java.util.List;

/**
 * Created by User on 22.01.2017.
 */
public interface BookDefinitionService<T extends BookDefinition> {

    void persist(T object);

    T delete(T object);

    T get(int id);

    List<T> search(BookSearchCriteria criteria);

    List<T> getAll();
}
