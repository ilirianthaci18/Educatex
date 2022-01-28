package com.educatex.lms.controller;

import com.educatex.lms.common.dto.BookDTO;
import com.educatex.lms.common.dto.ElibraryDTO;
import com.educatex.lms.common.dto.TrainingDTO;
import com.educatex.lms.model.*;
import com.educatex.lms.service.ElibraryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RequestMapping("/api/elibrary")
@RestController
public class ElibraryController {

    private ElibraryService elibraryService;

    @GetMapping()
    public List<ElibraryDTO> getAllElibrary() {
        return elibraryService.getAllElibrary();
    }

    @GetMapping("/{id}")
    public Elibrary getElibraryById(@PathVariable Long id) {
        return elibraryService.getElibraryById(id);
    }

    @GetMapping("/books")
    public List<BookDTO> getBooks() {
        return elibraryService.getAllBooks();
    }

    @GetMapping("/mostRatedBook")
    public Book getMostRatedBook() {
        return elibraryService.getMostRatedBook();
    }

    @GetMapping("/book/author/{name}")
    public List<Book> showBookByAuthor(@PathVariable String name) {
        return elibraryService.showBookByAuthor(name);
    }

    @GetMapping("/book/course/{name}")
    public Set<Book> showBookByCourse(@PathVariable String name) {
        return elibraryService.showBookByCourse(name);
    }

    @GetMapping("/trainings")
    public List<TrainingDTO> getAllTrainings(){
        return elibraryService.getAllTrainings();
    }

    @GetMapping("/training/course/{name}")
    public Set<Training> showTrainingByCourse(@PathVariable String name) {
        return elibraryService.showTrainingByCourse(name);
    }

    @GetMapping("/assignment/course/{name}")
    public Set<Assignment> showAssignmentByCourse(@PathVariable String name) {
        return elibraryService.showAssignmentByCourse(name);
    }

    @PutMapping()
    public Elibrary updateElibrary(@RequestBody Elibrary elibrary) {
        return elibraryService.saveElibrary(elibrary);
    }

    @PostMapping("/save/book")
    public void saveBook(@RequestBody Book book){
        elibraryService.saveBook(book);
    }

    @PostMapping
    public Elibrary saveElibrary(@RequestBody Elibrary elibrary) {
        return elibraryService.saveElibrary(elibrary);
    }

    @PostMapping("/training")
    public Training addTraining(@RequestBody Training training) {
        return elibraryService.addTraining(training);
    }

    @PostMapping("/assignment")
    public Assignment addAssignment(@RequestBody Assignment assignment) {
        return elibraryService.addAssignment(assignment);
    }

    @PostMapping("/{elibraryId}/book/{bookId}")
    public void addBookToElibrary(@PathVariable Long elibraryId, @PathVariable Long bookId) {
        elibraryService.addBookToElibrary(elibraryId, bookId);
    }

    @PostMapping("{elibraryId}/student/{studentId}")
    public void addStudentToElibrary(@PathVariable Long elibraryId, @PathVariable Long studentId) {
        elibraryService.addStudentToElibrary(elibraryId, studentId);
    }

    @PostMapping("{elibraryId}/training/{trainingId}")
    public void addTrainingToElibrary(@PathVariable Long elibraryId, @PathVariable Long trainingId) {
        elibraryService.addTrainingToElibrary(elibraryId, trainingId);
    }

    @PostMapping("{elibraryId}/assignment/{assignmentId}")
    public void addAssignmentToElibrary(@PathVariable Long elibraryId, @PathVariable Long assignmentId) {
        elibraryService.addAssignmentToElibrary(elibraryId, assignmentId);
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        return elibraryService.saveBook(book);
    }

    @PostMapping("/rating")
    public Rating addRating(@RequestBody Rating rating){
        return elibraryService.addRatingDb(rating);
    }

    @PostMapping("/rating/{ratingId}/training/{trainingId}")
    public void addRatingToTrainigns(@PathVariable Long ratingId,@PathVariable Long trainingId){
        // TODO try to add  the author
         elibraryService.addRatingToTraining(ratingId,trainingId);
    }

    @PostMapping("/book/{bookId}/rating/{ratingId}")
    public void addRatingToBook(@PathVariable Long bookId,@PathVariable Long ratingId){
        elibraryService.addRatingToBook(bookId,ratingId);
    }

    @DeleteMapping("/{id}")
    public void deleteElibrary(@PathVariable Long id) {
        elibraryService.deleteElibrary(id);
    }

    @DeleteMapping("/rating/{id}")
    public void deleteRating(@PathVariable Long id) {
    }
    @DeleteMapping("/training/{id}")
    public void deleteTraining(@PathVariable Long id) {
        elibraryService.deleteTraining(id);
    }

    @DeleteMapping("/assignment/{id}")
    public void deleteAssignment(@PathVariable Long id) {
        elibraryService.deleteAssignment(id);
    }

}


