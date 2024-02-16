package com.atypon.analysis.repository;

import com.atypon.analysis.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RepositoryDefinition(domainClass = Grade.class, idClass = Long.class)
public interface GradeRepository extends JpaRepository<Grade, Long> {

}
