package com.educatex.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(name="student_sequence",sequenceName = "student_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")
    @Column(updatable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private char gender;

    @Column
    private int age;

    @Column
    private Long personalNum;

    @Column
    private LocalDateTime studentCreatedAt=LocalDateTime.now();

//    @Transient
//    @Convert(converter = HashMapConverter.class)
//    private Map<Course,Integer> gradeList;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Course> courses=new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forum_id",referencedColumnName = "id")
    private Forum forum;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="author",fetch = FetchType.LAZY)
    private List<Rating> ratingList=new ArrayList<>();
}
