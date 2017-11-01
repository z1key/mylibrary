package org.z1key.projects.service.book;

import org.z1key.projects.entity.Author;
import org.z1key.projects.entity.BookClassification;
import org.z1key.projects.entity.Genre;
import org.z1key.projects.entity.PublishHouse;

import java.util.List;

/**
 * Created by User on 21.01.2017.
 */
public class BookSearchCriteria {

    private List<Author> authors;

    private String title;

    private int year;

    private PublishHouse publishHouse;

    private Genre genre;

    private BookClassification classification;
}
