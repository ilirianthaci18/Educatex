package com.educatex.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Student {

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

    @Column
    private LocalDateTime studentCreatedAt=LocalDateTime.now();

//    @Column
//    private boolean iRregullt; //TODO

//    @Transient
//    @Convert(converter = HashMapConverter.class)
//    private Map<Course,Integer> gradeList;


    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true,mappedBy="post_author",fetch = FetchType.LAZY)
    private List<Post> posts=new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Course> courses=new HashSet<>();

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true,mappedBy="author",fetch = FetchType.LAZY)
    private List<Rating> ratingList=new ArrayList<>();

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
}
