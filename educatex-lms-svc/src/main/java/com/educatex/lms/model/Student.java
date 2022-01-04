package com.educatex.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @Column(updatable = false)
    private String name;

    @Column(updatable = false)
    private String lastName;

    @Column(updatable = false)
    private char gender;

    @Column(updatable = false)
    private int age;

    @Column(updatable = false)
    private Long personalNum;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Course> courses=new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forum_id",referencedColumnName = "id")
    private Forum forum;

}
