package com.educatex.lms.service;

import com.educatex.lms.common.dto.BookDTO;
import com.educatex.lms.common.dto.ElibraryDTO;
import com.educatex.lms.common.dto.TrainingDTO;
import com.educatex.lms.exception.NotFoundException;
import com.educatex.lms.model.*;
import com.educatex.lms.repository.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.educatex.lms.common.mappers.ElibraryMapper.*;
import static com.educatex.lms.common.mappers.TrainingMapper.*;
import static com.educatex.lms.common.mappers.BookMapper.toBookDTO;

@AllArgsConstructor
@Slf4j
@Service
public class ElibraryServiceImpl implements ElibraryService {

    private StudentService studentService;
    private ElibraryRepository elibraryRepository;
    private RatingRepository ratingRepository;
    private TrainingRepository trainingRepository;
    private AssignmentRepository assignmentRepository;
    private BookRepository bookRepository;


    @Override
    public Elibrary saveElibrary(Elibrary elibrary) {
        return elibraryRepository.save(elibrary);
    }

    @Override
    public List<ElibraryDTO> getAllElibrary() {

        List<Elibrary> elibraries = elibraryRepository.findAll();
        List<ElibraryDTO> elibraryDTOS = new ArrayList<>();

        elibraries.stream().forEach(elibrary -> {
            elibraryDTOS.add(toElibraryDTO(elibrary));
        });

        return elibraryDTOS;
    }

    @Override
    public List<TrainingDTO> getAllTrainings() {
        List<Training> trainings = trainingRepository.findAll();
        List<TrainingDTO> trainingDTOS = new ArrayList<>();

        trainings.stream().forEach(training -> {
            trainingDTOS.add(toTrainingDTO(training));
        });

        return trainingDTOS;
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> {
            log.error("Book could not be found , id : ", id);
            return new NotFoundException("Book with id " + id + "not found");
        });
    }

    @Override
    public Elibrary getElibraryById(Long id) {
        return elibraryRepository.findById(id).orElseThrow(() -> {
            log.error("Elibrary could not be found , id : ", id);
            return new NotFoundException("Elibrary with id " + id + "not found");
        });

    }

    @Override
    public Training getTrainingById(Long trainingId) {
        return trainingRepository.findById(trainingId).orElseThrow(() -> {
            log.error("Training could not be found , id : ", trainingId);
            return new NotFoundException("Training with id " + trainingId + "not found");
        });
    }

    @Override
    public Rating getRatingById(Long ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(() -> {
            log.error("Assignment could not be found , id : ", ratingId);
            return new NotFoundException("Assignment with id " + ratingId + "not found");
        });

    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getMostRatedBook() {
        return null;
    } //TODO

    @Override
    public List<Book> showBookByAuthor(String name) {
        return null;
    } //TODO

    @Override
    public Set<Book> showBookByCourse(String name) {
        return null;
    } //TODO

    @Override
    public Set<Training> showTrainingByCourse(String name) {
        return null;
    } //TODO

    @Override
    public Set<Assignment> showAssignmentByCourse(String name) {
        return null;
    } //TODO

    @Override
    public Training addTraining(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public Rating addRatingDb(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Assignment addAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public void deleteElibrary(Long id) {
        elibraryRepository.deleteById(id);
    }

    @Override
    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }

    @Override
    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }

    @Override
    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }

    @Override
    public void deleteAllRatings() {
        ratingRepository.deleteAll();
    }

    @Override
    public void deleteAllAssignments() {
        assignmentRepository.deleteAll();
    }

    @Override
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }

    @Override
    public void deleteAllTrainings() {
        trainingRepository.deleteAll();
    }


    @Override
    public void addStudentToElibrary(Long elibraryId, Long studentId) {
        Student student = studentService.getStudentdById(studentId);

        Elibrary elibrary = getElibraryById(elibraryId);

        elibrary.addStudents(student);

        saveElibrary(elibrary);
    }

    @Override
    public void addBookToElibrary(Long elibraryId, Long bookId) {
        Elibrary elibrary = getElibraryById(elibraryId);
        Book book = getBookById(bookId);

        elibrary.addBooks(book);

        saveElibrary(elibrary);
    }

    @Override
    public void addTrainingToElibrary(Long elibraryId, Long trainingId) {
        Elibrary elibrary = getElibraryById(elibraryId);
        Training training = getTrainingById(trainingId);

        elibrary.addTraining(training);

        saveElibrary(elibrary);
    }

    @Override
    public void addAssignmentToElibrary(Long elibraryId, Long assignmentId) {
        Elibrary elibrary = getElibraryById(elibraryId);
        Assignment assignment = assignmentRepository.findById(assignmentId).orElseThrow(() -> {
            log.error("Assignment could not be found , id : ", assignmentId);
            return new NotFoundException("Assignment with id " + assignmentId + "not found");
        });

        elibrary.addAssignment(assignment);

        saveElibrary(elibrary);
    }

    @Override
    public void addRatingToTraining(Long ratingId, Long trainingId) {
        Rating rating = getRatingById(ratingId);

        Training training = getTrainingById(trainingId);

        training.addRatingToTraining(rating);

        trainingRepository.save(training);
    }

    @Override
    public void addRatingToBook(Long bookId, Long ratingId) {
        Book book = getBookById(bookId);
        Rating rating = getRatingById(ratingId);

        book.addRatingToList(rating);

        bookRepository.save(book);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();

        books.stream().forEach(book -> {
            bookDTOS.add(toBookDTO(book));
        });

        return bookDTOS;
    }

}
