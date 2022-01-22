package com.educatex.lms.service;

import com.educatex.lms.model.Course;
import com.educatex.lms.model.Forum;
import com.educatex.lms.model.Poll;
import com.educatex.lms.model.Post;
import com.educatex.lms.repository.ForumRepository;
import com.educatex.lms.repository.PollRepository;
import com.educatex.lms.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class ForumServiceImpl implements ForumService {

    private ForumRepository forumRepository;
    private PollRepository pollRepository;
    private PostRepository postRepository;

    @Override
    public List<Forum> getAllForums() {
        return forumRepository.findAll();
    }

    @Override
    public Forum getForumById(Long id) {
        return forumRepository.findById(id).get();
    }

    @Override
    public Forum saveForum(Forum forum) {
        return forumRepository.save(forum);
    }

    @Override
    public Forum updateForum(Long id, Forum forum) {
        Forum forum1=getForumById(id);

        //implement objectmapper

        return  forum1;
    }

    @Override
    public void deleteForum(Long id) {
        forumRepository.deleteById(id);
    }

    @Override
    public ArrayList<Poll> getPollsByCourseName(String name) {
        return null;
    }

    @Override
    public ArrayList<Post> getPostByCourse(Course course) {
        return null;
    }

    @Override
    public Poll addPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    @Override
    public void deletePoll(Long id) {
        pollRepository.deleteById(id);
    }

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    private Exception validateObject(Object obj){
        return new Exception();
    }
}
