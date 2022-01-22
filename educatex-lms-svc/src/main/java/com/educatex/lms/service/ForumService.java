package com.educatex.lms.service;

import com.educatex.lms.model.*;

import java.util.ArrayList;
import java.util.List;

public interface ForumService {

    List<Forum> getAllForums();

    Forum getForumById(Long id);

    Forum saveForum(Forum forum);

    Forum updateForum(Long id,Forum forum);

    void deleteForum(Long id);

    Poll addPoll(Poll poll);

    void deletePoll(Long id);

    Post addPost(Post post);

    void deletePost(Long id);

    ArrayList<Poll> getPollsByCourseName(String name);

    ArrayList<Post> getPostByCourse(Course course);
}
