package com.educatex.lms.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Course implements Serializable {

    @Id
    @SequenceGenerator(name="course_sequence",sequenceName = "course_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_sequence")
    @Column(updatable = false)
    private Long id;

    @NonNull
    @Column
    private String courseName;

    @NonNull
    @Column
    private String courseCode;

    @NonNull
    @Column
    private int ects;

    @Column
    private LocalDateTime dateTime=LocalDateTime.now();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="student_enrolled",
            joinColumns = @JoinColumn(name="subject_id"),
            inverseJoinColumns = @JoinColumn(name="student_id"))
    private Set<Student> enrolledStudents;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id",referencedColumnName = "id")
    private Professor professor;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy="course",fetch = FetchType.LAZY,orphanRemoval = true)
    private Set<Book> books;

    @JsonManagedReference
    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    @JsonManagedReference
    public Professor getProfessor() {
        return professor;
    }

    @JsonManagedReference
    public Set<Book> getBooks() {
        return books;
    }

    public void setBookToCourse(Book book){
        if(!books.contains(book)){
            books.add(book);
            book.setCourse(this);
        }
    }

}
