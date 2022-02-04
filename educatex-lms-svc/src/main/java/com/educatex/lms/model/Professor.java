package com.educatex.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Professor implements Serializable {

    @Id
    @SequenceGenerator(name="professor_sequence",sequenceName = "professor_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "professor_sequence")
    @Column(updatable = false)
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

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "professor",orphanRemoval = true)
    private Set<Course> courses=new HashSet<>();

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forum_id",referencedColumnName = "id")
    private Forum forum;

    @Transactional
    @JsonManagedReference
    public Set<Course> getCourses() {
        return courses;
    }


    public Professor(ProfessorBuilder builder) {
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.age = builder.age;
        this.personalNum = builder.personalNum;
    }

    public static class ProfessorBuilder{
        private String name;
        private String lastName;
        private char gender;
        private int age;
        private Long personalNum;

        public ProfessorBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProfessorBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ProfessorBuilder gender(char gender) {
            this.gender = gender;
            return this;
        }

        public ProfessorBuilder age(int age) {
            this.age = age;
            return this;
        }

        public ProfessorBuilder personalNum(Long personalNum) {
            this.personalNum = personalNum;
            return this;
        }

        public Professor build(){
            Professor professor =  new Professor(this);
            return professor;
        }
    }
}
