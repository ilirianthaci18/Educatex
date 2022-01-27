package com.educatex.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Elibrary {

    @Id
    @SequenceGenerator(name="elibrary_sequence",sequenceName = "elibrary_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "elibrary_sequence")
    @Column(updatable = false)
    private Long id;

    @NonNull
    @Column
    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy="e_library",orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<Training> trainings=new HashSet<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy="e_library",orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<Student> students=new HashSet<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy="e_library",orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<Book> books;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy="e_library",orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<Assignment> assignments=new HashSet<>();

    @JsonManagedReference
    public Set<Training> getTrainings() {
        return trainings;
    }

    @JsonManagedReference
    public Set<Student> getStudents() {
        return students;
    }

    @JsonManagedReference
    public Set<Book> getBooks() {
        return books;
    }

    @JsonManagedReference
    public Set<Assignment> getAssignments() {
        return assignments;
    }

    public void addTraining(Training training){
        trainings.add(training);
        training.setE_library(this);
    }

    public void addStudents(Student student){
        students.add(student);
        student.setE_library(this);
    }
    public void addBooks(Book book){
        books.add(book);
        book.setE_library(this);
    }
    public void addAssignment(Assignment assignment){
        assignments.add(assignment);
        assignment.setE_library(this);
    }
}
