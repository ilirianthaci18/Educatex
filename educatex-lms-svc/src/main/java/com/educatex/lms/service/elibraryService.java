package com.educatex.lms.service;

import com.educatex.lms.model.Assignment;
import com.educatex.lms.model.Book;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Training;

import java.util.List;
import java.util.Set;

public interface elibraryService {

    Book getMostRatedBook();

    List<Book> showBookByAuthor(String name);

    Set<Book> showBookByCourse(Course course);

    Set<Training> showTrainingByCourse(Course course);

    Set<Assignment> showAssignmentByCourse(Course course);


}
