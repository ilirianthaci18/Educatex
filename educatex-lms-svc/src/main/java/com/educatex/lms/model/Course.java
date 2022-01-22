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
public class Course {
    @Id
    private Long id;

    @Column
    private String courseCode;

    @ManyToMany
    @JoinTable(name="student_enrolled",
            joinColumns = @JoinColumn(name="subject_id"),
            inverseJoinColumns = @JoinColumn(name="student_id"))
    private Set<Student> enrolledStudents=new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id",referencedColumnName = "id")
    private Professor professor;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="course",fetch = FetchType.LAZY)
    private Set<Book> books;

    public void addEnrolledStudents(Student student){
        enrolledStudents.add(student);
    }

}
