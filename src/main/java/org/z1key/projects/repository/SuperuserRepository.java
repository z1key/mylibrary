package org.z1key.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.z1key.projects.entity.Superuser;
/**
 * Created by User on 22.01.2017.
 */
public interface SuperuserRepository extends JpaRepository<Superuser, Long> {

}
