package com.educatex.lms.repository;

import com.educatex.lms.model.Assignment;
import com.educatex.lms.model.Book;
import com.educatex.lms.model.Elibrary;
import com.educatex.lms.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ElibraryRepository extends JpaRepository<Elibrary,Long> {

//    Book findBookById(Long id);
//
//    Training findTrainingById(Long id);
//
//    Assignment findAssignmentById(Long id);
//
//    List<Training> findByTrainingIdOrderByCreatedAtDesc();
//
//    List<Assignment> findByAssignmentIdOrderByCreatedAtDesc();
//
//    Training findByTrainingIdAndCreatedAt(Long id , LocalDate date);
//
//    List<Assignment> findByAssignmentCreatedAt(LocalDate date);
//
//    Integer countTrainings();
//
//    Integer countBooks();
//
//    Integer countAssignments();

}
