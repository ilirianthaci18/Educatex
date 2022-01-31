package com.educatex.lms.model;

import com.educatex.lms.common.security.PasswordConfig;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Student {
//    extends ApplicationUser

//    public Student() {
//        super(username, password, grantedAuthorities, isAccountNonExpired, isAccountNonLocked, isCredentialNonExpired, isEnabled);
//    }
//
//    public Student(String username, String password, Set<? extends GrantedAuthority> grantedAuthorities, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialNonExpired, boolean isEnabled, Long id, @NonNull String name, @NonNull String lastName, @NonNull char gender, @NonNull int age, @NonNull Long personalNum, LocalDateTime studentCreatedAt,
//                   boolean iRregullt, List<Post> posts, Set<Course> courses, List<Rating> ratingList, Forum forum, Elibrary e_library) {
//        super(username, password, grantedAuthorities, isAccountNonExpired, isAccountNonLocked, isCredentialNonExpired, isEnabled);
//        this.id = id;
//        this.name = name;
//        this.lastName = lastName;
//        this.gender = gender;
//        this.age = age;
//        this.personalNum = personalNum;
//        this.studentCreatedAt = studentCreatedAt;
//        this.iRregullt = iRregullt;
//        this.posts = posts;
//        this.courses = courses;
//        this.ratingList = ratingList;
//        this.forum = forum;
//        this.e_library = e_library;
//    }

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

    @NonNull
    @Column
    private boolean iRregullt;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true,mappedBy="studentAction",fetch = FetchType.LAZY)
    private List<Search> searches=new ArrayList<>();

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

    public void addSearch(Search search){
        if(!searches.contains(search)){
            searches.add(search);
            search.setStudentAction(this);
        }
    }
}
