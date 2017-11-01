package org.z1key.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.z1key.projects.entity.BookDefinition;

/**
 * Created by User on 21.01.2017.
 */
public interface BookDefinitionRepository extends JpaRepository<BookDefinition, Long> {

}
