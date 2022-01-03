package com.educatex.lms.service;

import com.educatex.lms.model.Course;
import com.educatex.lms.model.Poll;
import com.educatex.lms.model.Post;

import java.util.ArrayList;

public interface ForumService {
    ArrayList<Poll> getPollsByCourseName(String name);
    ArrayList<Post> getPostByCourse(Course course);
}
