package com.educatex.lms.repository;

import com.educatex.lms.model.Assignment;
import com.educatex.lms.model.Book;
import com.educatex.lms.model.Elibrary;
import com.educatex.lms.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface ElibraryRepository extends JpaRepository<Elibrary, Long> {

    @Query("SELECT training FROM Training training WHERE training.date= :date ")
    List<Training> findByTrainingIdAndCreatedAt(@Param("date") LocalDate date);

    @Query("SELECT assignment FROM Assignment assignment WHERE assignment.date= :date ")
    List<Assignment> findByAssignmentCreatedAt(@Param("date") LocalDate date);

    @Query("SELECT book FROM Book book WHERE book.author=   :name")
    List<Book> showBookByAuthor(@Param("name") String name);

    @Query("SELECT book FROM Book book WHERE book.course.id= :id")
    Set<Book> showBookByCourse(@Param("id") Long id);

    @Query("SELECT course.id FROM Course course WHERE course.courseName= :name")
    Long selectCourseByName(@Param("name") String name);

    @Query("SELECT COUNT (training) FROM Training training")
    Integer countTrainings();

    @Query("SELECT COUNT (book) FROM Book book")
    Integer countBooks();

    @Query("SELECT COUNT (assignment) FROM Assignment assignment")
    Integer countAssignments();
}
