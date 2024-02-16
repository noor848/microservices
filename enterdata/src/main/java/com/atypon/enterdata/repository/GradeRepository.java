package com.atypon.enterdata.repository;

import com.atypon.enterdata.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryDefinition(idClass = Long.class, domainClass = Grade.class)
public interface GradeRepository extends JpaRepository<Grade, Long> {
}
