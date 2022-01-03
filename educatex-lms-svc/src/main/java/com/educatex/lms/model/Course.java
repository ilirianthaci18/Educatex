package com.educatex.lms.model;

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

    @ManyToMany
    @JoinTable(name="student_enrolled",
            joinColumns = @JoinColumn(name="subject_id"),
            inverseJoinColumns = @JoinColumn(name="student_id"))
    Set<Student> enrolledStudents=new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id",referencedColumnName = "id")
    private Professor professor;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="course",fetch = FetchType.LAZY)
    private Set<Book> books;

}
