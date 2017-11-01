package org.z1key.projects.service.book;

import org.springframework.stereotype.Service;
import org.z1key.projects.entity.BookDefinition;

import java.util.List;

/**
 * Created by User on 21.01.2017.
 */
@Service("bookService")
public class BookServiceImpl implements BookDefinitionService {

    @Override
    public void persist(BookDefinition bookDefinition) {

    }

    @Override
    public BookDefinition delete(BookDefinition bookDefinition) {
        return null;
    }

    @Override
    public List<BookDefinition> search(BookSearchCriteria criteria) {
        return null;
    }

    @Override
    public List<BookDefinition> getAll() {
        return null;
    }

    @Override
    public BookDefinition get(int id) {
        return null;
    }
}
