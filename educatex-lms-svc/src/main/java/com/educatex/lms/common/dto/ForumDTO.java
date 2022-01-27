package com.educatex.lms.common.dto;

import com.educatex.lms.model.Poll;
import com.educatex.lms.model.Post;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ForumDTO {

    private String name;

    private String forumDescription;

    private List<PostDTOStudent> posts=new ArrayList<>();

    private List<Poll> polls=new ArrayList<>();

    private Set<StudentDTOCourse> users=new HashSet<>();

    private Set<ProfessorDTOCourse> admins=new HashSet<>();

    @JsonManagedReference
    public List<PostDTOStudent> getPosts() {
        return posts;
    }

    @JsonManagedReference
    public List<Poll> getPolls() {
        return polls;
    }

    @JsonManagedReference
    public Set<StudentDTOCourse> getUsers() {
        return users;
    }

    @JsonManagedReference
    public Set<ProfessorDTOCourse> getAdmins() {
        return admins;
    }
}
