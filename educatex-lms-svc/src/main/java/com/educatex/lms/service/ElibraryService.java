package com.educatex.lms.service;

import com.educatex.lms.common.dto.AssignmentDTO;
import com.educatex.lms.common.dto.BookDTO;
import com.educatex.lms.common.dto.ElibraryDTO;
import com.educatex.lms.common.dto.TrainingDTO;
import com.educatex.lms.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ElibraryService {

    List<ElibraryDTO> getAllElibrary();

    Elibrary getElibraryById(Long id);

    Elibrary saveElibrary(Elibrary elibrary);

    void deleteElibrary(Long id);

    void addStudentToElibrary(Long elibraryId,Long studentId);

    void addBookToElibrary(Long elibraryId, Long bookId);

    void addTrainingToElibrary(Long elibraryId,Long trainingId);

    void addAssignmentToElibrary(Long elibraryId,Long assignmentId);

    Book getBookById(Long id);

    Book saveBook(Book book);

    List<BookDTO> showBookByAuthor(String name);

    Set<BookDTO> showBookByCourse(String name);

    void addRatingToTraining(Long ratingId,Long trainingId);

    Training getTrainingById(Long id);

    Rating getRatingById(Long ratingId);

    void deleteRating(Long id);

    Training addTraining(Training training);

    void deleteTraining(Long id);

    Assignment addAssignment(Assignment assignment);

    void deleteAssignment(Long id);

    void deleteAllRatings();

    void deleteAllAssignments();

    void deleteAllBooks();

    void deleteAllTrainings();

    List<TrainingDTO> getAllTrainings();

    Rating addRatingDb(Rating rating);

    void addRatingToBook(Long bookId,Long ratingId);

    List<BookDTO> getAllBooks();

    List<TrainingDTO> findByTrainingIdAndCreatedAt(LocalDate date);

    List<AssignmentDTO> findByAssignmentCreatedAt(LocalDate date);

    Integer countTrainings();

    Integer countBooks();

    Integer countAssignments();
}
