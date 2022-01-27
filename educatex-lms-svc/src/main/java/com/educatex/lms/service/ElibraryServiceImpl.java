package com.educatex.lms.service;

import com.educatex.lms.common.dto.BookDTO;
import com.educatex.lms.common.dto.ElibraryDTO;
import com.educatex.lms.common.dto.TrainingDTO;
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
public class ElibraryServiceImpl implements ElibraryService{

    private StudentService studentService;
    private ElibraryRepository elibraryRepository;
    private RatingRepository ratingRepository;
    private TrainingRepository trainingRepository;
    private AssignmentRepository assignmentRepository;
    private BookRepository bookRepository;
    private CourseService courseService;

    @Override
    public List<ElibraryDTO> getAllElibrary() {

        List<Elibrary> elibraries=elibraryRepository.findAll();
        List<ElibraryDTO> elibraryDTOS=new ArrayList<>();

        elibraries.stream().forEach(elibrary -> {
            elibraryDTOS.add(toElibraryDTO(elibrary));
        });

        return elibraryDTOS;
    }

    @Override
    public List<TrainingDTO> getAllTrainings() {
        List<Training> trainings=trainingRepository.findAll();
        List<TrainingDTO> trainingDTOS=new ArrayList<>();

        trainings.stream().forEach(training -> {
            trainingDTOS.add(toTrainingDTO(training));
        });

        return trainingDTOS;
    }

    @Override
    public Elibrary getElibraryById(Long id) {
        return elibraryRepository.findById(id).get();
    }

    @Override
    public Elibrary saveElibrary(Elibrary elibrary) {
        return elibraryRepository.save(elibrary);
    }

    @Override
    public Elibrary updateElibrary(Long id, Elibrary elibrary) {
        //impl objectmapper
        return null;
    }

    @Override
    public void deleteElibrary(Long id) {
        elibraryRepository.deleteById(id);
    }

    public Book getBookById(Long id){
        return bookRepository.getById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getMostRatedBook() {
        return null;
    }

    @Override
    public List<Book> showBookByAuthor(String name) {
        return null;
    }

    @Override
    public Set<Book> showBookByCourse(String name) {
        return null;
    }

    @Override
    public Set<Training> showTrainingByCourse(String name) {
        return null;
    }

    @Override
    public Set<Assignment> showAssignmentByCourse(String name) {
        return null;
    }

//    @Override
//    public void addRating(Rating rating,Long studentId,Long trainingId) {
//        Student student=studentService.getStudentdById(studentId);
//        Training training=trainingRepository.findById(trainingId).get();
//
//        rating.setAuthor(student);
//        rating.setTraining(training);
//
//        ratingRepository.save(rating);
//    }

    @Override
    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }

    @Override
    public Training addTraining(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }

    @Override
    public Assignment addAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
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
        Student student=studentService.getStudentdById(studentId);

        Elibrary elibrary=getElibraryById(elibraryId);

        elibrary.addStudents(student);

        saveElibrary(elibrary);
    }

    @Override
    public void addBookToElibrary(Long elibraryId,Long bookId) {
        Elibrary elibrary=getElibraryById(elibraryId);
        Book book=bookRepository.findById(bookId).get();

        elibrary.addBooks(book);

        saveElibrary(elibrary);
    }

    @Override
    public void addTrainingToElibrary(Long elibraryId, Long trainingId) {
        Elibrary elibrary=getElibraryById(elibraryId);
        Training training=trainingRepository.findById(trainingId).get();

        elibrary.addTraining(training);

        saveElibrary(elibrary);
    }

    @Override
    public void addAssignmentToElibrary(Long elibraryId, Long assignmentId) {
        Elibrary elibrary=getElibraryById(elibraryId);
        Assignment assignment=assignmentRepository.getById(assignmentId);

        elibrary.addAssignment(assignment);

        saveElibrary(elibrary);
    }

    @Override
    public void addRatingToTraining(Long ratingId, Long trainingId) {
        Rating rating=ratingRepository.findById(ratingId).get();
        Training training=trainingRepository.findById(trainingId).get();

        training.addRatingToTraining(rating);

        trainingRepository.save(training);
    }

    @Override
    public Rating addRatingDb(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public void addRatingToBook(Long bookId, Long ratingId) {
        Book book=bookRepository.findById(bookId).get();
        Rating rating=ratingRepository.findById(ratingId).get();

        book.addRatingToList(rating);

        bookRepository.save(book);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books=bookRepository.findAll();
        List<BookDTO> bookDTOS=new ArrayList<>();

        books.stream().forEach(book -> {
            bookDTOS.add(toBookDTO(book));
        });

        return bookDTOS;
    }

    private void validateId(Long id){}
    private void objectExists(Long id){} //we can implement this in validateId just check decoupling
}
