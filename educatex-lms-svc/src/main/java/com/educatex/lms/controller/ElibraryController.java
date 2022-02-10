package com.educatex.lms.controller;

import com.educatex.lms.common.dto.AssignmentDTO;
import com.educatex.lms.common.dto.BookDTO;
import com.educatex.lms.common.dto.ElibraryDTO;
import com.educatex.lms.common.dto.TrainingDTO;
import com.educatex.lms.model.*;
import com.educatex.lms.service.ElibraryService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@CrossOrigin(originPatterns = "*")
@AllArgsConstructor
@RequestMapping("/api/elibrary")
@RestController
public class ElibraryController {

    private ElibraryService elibraryService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping()
    public List<ElibraryDTO> getAllElibrary() {
        return elibraryService.getAllElibrary();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public Elibrary getElibraryById(@PathVariable Long id) {
        return elibraryService.getElibraryById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    @GetMapping("/books")
    public List<BookDTO> getBooks() {
        return elibraryService.getAllBooks();
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    //    localhost:8080/api/elibrary/book/author/John Carnell
    @GetMapping("/book/author/{name}")
    public List<BookDTO> showBookByAuthor(@PathVariable String name) {
        return elibraryService.showBookByAuthor(name);
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
//    localhost:8080/api/elibrary/book/course/Java 1
    @GetMapping("/book/course/{name}")
    public Set<BookDTO> showBookByCourse(@PathVariable String name) {
        return elibraryService.showBookByCourse(name);
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR')")
    @GetMapping("/trainings")
    public List<TrainingDTO> getAllTrainings(){
        return elibraryService.getAllTrainings();
    }


    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    @GetMapping("/training/date")
    public List<TrainingDTO> showTrainingByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                    Optional<LocalDate> date){
        return elibraryService.findByTrainingIdAndCreatedAt(date.orElse(LocalDate.now()));
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    @GetMapping("/assignment/date")
    public List<AssignmentDTO> showAssignmentByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                        Optional<LocalDate> date){
        return elibraryService.findByAssignmentCreatedAt(date.orElse(LocalDate.now()));
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    @GetMapping("/trainings/count")
    public Integer countTrainings(){
        return elibraryService.countTrainings();
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    @GetMapping("/assignments/count")
    public Integer countAssignments(){
        return elibraryService.countAssignments();
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    @GetMapping("/books/count")
    public Integer countBooks(){
        return elibraryService.countBooks();
    }

    @PreAuthorize("hasAnyRole('ROLE_PROFESSOR')")
    @PutMapping()
    public Elibrary updateElibrary(@RequestBody Elibrary elibrary) {
        return elibraryService.saveElibrary(elibrary);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @PostMapping("/save/book")
    public void saveBook(@RequestBody Book book){
        elibraryService.saveBook(book);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @PostMapping
    public Elibrary saveElibrary(@RequestBody Elibrary elibrary) {
        return elibraryService.saveElibrary(elibrary);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @PostMapping("/training")
    public Training addTraining(@RequestBody Training training) {
        return elibraryService.addTraining(training);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @PostMapping("/assignment")
    public Assignment addAssignment(@RequestBody Assignment assignment) {
        return elibraryService.addAssignment(assignment);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @PostMapping("/{elibraryId}/book/{bookId}")
    public void addBookToElibrary(@PathVariable Long elibraryId, @PathVariable Long bookId) {
        elibraryService.addBookToElibrary(elibraryId, bookId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PROFESSOR')")
    @PostMapping("{elibraryId}/student/{studentId}")
    public void addStudentToElibrary(@PathVariable Long elibraryId, @PathVariable Long studentId) {
        elibraryService.addStudentToElibrary(elibraryId, studentId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @PostMapping("{elibraryId}/training/{trainingId}")
    public void addTrainingToElibrary(@PathVariable Long elibraryId, @PathVariable Long trainingId) {
        elibraryService.addTrainingToElibrary(elibraryId, trainingId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @PostMapping("{elibraryId}/assignment/{assignmentId}")
    public void addAssignmentToElibrary(@PathVariable Long elibraryId, @PathVariable Long assignmentId) {
        elibraryService.addAssignmentToElibrary(elibraryId, assignmentId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        return elibraryService.saveBook(book);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @PostMapping("/rating")
    public Rating addRating(@RequestBody Rating rating){
        return elibraryService.addRatingDb(rating);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @PostMapping("/rating/{ratingId}/training/{trainingId}")
    public void addRatingToTrainigns(@PathVariable Long ratingId,@PathVariable Long trainingId){
         elibraryService.addRatingToTraining(ratingId,trainingId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @PostMapping("/book/{bookId}/rating/{ratingId}")
    public void addRatingToBook(@PathVariable Long bookId,@PathVariable Long ratingId){
        elibraryService.addRatingToBook(bookId,ratingId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteElibrary(@PathVariable Long id) {
        elibraryService.deleteElibrary(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping("/rating/{id}")
    public void deleteRating(@PathVariable Long id) { elibraryService.deleteRating(id); }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping("/training/{id}")
    public void deleteTraining(@PathVariable Long id) {
        elibraryService.deleteTraining(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping("/assignment/{id}")
    public void deleteAssignment(@PathVariable Long id) {
        elibraryService.deleteAssignment(id);
    }

}


