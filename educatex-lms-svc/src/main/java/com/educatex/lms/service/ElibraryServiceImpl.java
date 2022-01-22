package com.educatex.lms.service;

import com.educatex.lms.model.*;
import com.educatex.lms.repository.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Slf4j
@Service
public class ElibraryServiceImpl implements ElibraryService{

    private ElibraryRepository elibraryRepository;
    private RatingRepository ratingRepository;
    private ReplyRepository replyRepository;
    private TrainingRepository trainingRepository;
    private AssignmentRepository assignmentRepository;

    @Override
    public List<Elibrary> getAllElibrary() {
        return elibraryRepository.findAll();
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

    @Override
    public Book getMostRatedBook() {
        return null;
    }

    @Override
    public List<Book> showBookByAuthor(String name) {
        return null;
    }

    @Override
    public Set<Book> showBookByCourse(Course course) {
        return null;
    }

    @Override
    public Set<Training> showTrainingByCourse(Course course) {
        return null;
    }

    @Override
    public Set<Assignment> showAssignmentByCourse(Course course) {
        return null;
    }

    @Override
    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }

    @Override
    public Reply addReply(Reply reply) {
        return replyRepository.save(reply);
    }

    @Override
    public void deleteReply(Long id) {
        replyRepository.deleteById(id);
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

    private void validateId(Long id){}
    private void objectExists(Long id){} //we can implement this in validateId just check decoupling
}
