package com.educatex.lms.repository;

import com.educatex.lms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("SELECT student FROM Student student WHERE student.iRregullt= :rregullt") //TODO not returning
    List<Student> findAllRegularStudents(@Param("rregullt") boolean rregullt);

    @Query("SELECT student FROM Student student WHERE student.name= :firstName")
    List<Student> findAllByFirstName(@Param("firstName") String firstName);

    @Query("SELECT student FROM Student student WHERE student.lastName= :lastName")//TODO not returning
    List<Student> findAllByLastName(@Param("lastName") String lastName);

    @Query("SELECT COUNT (student) FROM Student student")
    Integer countStudents();

}
