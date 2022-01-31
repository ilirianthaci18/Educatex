package com.educatex.lms.repository;

import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {

    @Query("SELECT professor FROM Professor professor WHERE professor.name= :firstName")
    List<Professor> findAllByFirstName(@Param("firstName") String firstName);

    @Query("SELECT COUNT (professor) FROM Professor professor")
    Integer countProfessors();

}
