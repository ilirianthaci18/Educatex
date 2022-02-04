package com.educatex.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;



@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Student implements Serializable {
    @Id
    @SequenceGenerator(name="student_sequence",sequenceName = "student_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")
    @Column
    private Long id;

    @NonNull
    @Column
    private String name;

    @NonNull
    @Column
    private String lastName;

    @NonNull
    @Column
    private char gender;

    @NonNull
    @Column
    private int age;

    @NonNull
    @Column
    private Long personalNum;

    @NonNull
    @Column
    private String drejtimi;

    @Column
    private LocalDateTime studentCreatedAt=LocalDateTime.now();

    @NonNull
    @Column
    private boolean iRregullt;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true,mappedBy="studentAction",fetch = FetchType.LAZY)
    private List<Search> searches;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true,mappedBy="post_author",fetch = FetchType.LAZY)
    private List<Post> posts;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Course> courses;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true,mappedBy="author",fetch = FetchType.LAZY)
    private List<Rating> ratingList;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forum_id",referencedColumnName = "id")
    private Forum forum;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "elibrary_id",referencedColumnName = "id")
    private Elibrary e_library;

    @JsonManagedReference
    public Set<Course> getCourses() {
        return courses;
    }

    @JsonManagedReference
    public List<Post> getPosts() {
        return posts;
    }

    public Student(StudentBuilder builder) {
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.age = builder.age;
        this.personalNum = builder.personalNum;
        this.drejtimi=builder.drejtimi;
    }

    public static class StudentBuilder{
        private String name;
        private String lastName;
        private char gender;
        private int age;
        private Long personalNum;
        private boolean iRregullt;
        private String drejtimi;

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentBuilder setDrejtimi(String drejtimi){
            this.drejtimi=drejtimi;
            return  this;
        }
        public StudentBuilder setGender(char gender) {
            this.gender = gender;
            return this;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setPersonalNum(Long personalNum) {
            this.personalNum = personalNum;
            return this;
        }

        public StudentBuilder setRregullt(boolean rregullt){
            this.iRregullt=rregullt;
            return this;
        }

        public Student build(){
            Student student=new Student(this);
            return student;
        }
    }


    public void addCourses(Course course){
        if(!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void addPost(Post post){
        if(!posts.contains(post)){
            posts.add(post);
            post.setPost_author(this);
        }
    }

    public void addSearch(Search search){
        if(!searches.contains(search)){
            searches.add(search);
            search.setStudentAction(this);
        }
    }
}
