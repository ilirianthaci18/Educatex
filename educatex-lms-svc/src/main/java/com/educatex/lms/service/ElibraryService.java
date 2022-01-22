package com.educatex.lms.service;

import com.educatex.lms.model.*;

import java.util.List;
import java.util.Set;

public interface ElibraryService {

    List<Elibrary> getAllElibrary();

    Elibrary getElibraryById(Long id);

    Elibrary saveElibrary(Elibrary elibrary);

    Elibrary updateElibrary(Long id,Elibrary elibrary);

    void deleteElibrary(Long id);

    Book getMostRatedBook();

    List<Book> showBookByAuthor(String name);

    Set<Book> showBookByCourse(Course course);

    Set<Training> showTrainingByCourse(Course course);

    Set<Assignment> showAssignmentByCourse(Course course);

    Rating addRating(Rating rating);

    void deleteRating(Long id);

    Reply addReply(Reply reply);

    void deleteReply(Long id);

    Training addTraining(Training training);

    void deleteTraining(Long id);

    Assignment addAssignment(Assignment assignment);

    void deleteAssignment(Long id);
}
