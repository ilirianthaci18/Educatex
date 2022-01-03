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
public class Professor {
    @Id
    @SequenceGenerator(name="professor_sequence",sequenceName = "professor_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "professor_sequence")
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
    @OneToMany(mappedBy = "professor")
    private Set<Course> courses=new HashSet<>();

    @ManyToOne
    private Forum forum;
}
