package com.educatex.lms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(name="book_sequence",sequenceName = "book_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_sequence")
    @Column(updatable = false)
    private Long id;

    @Column(updatable = false)
    private String title;

    @Column(updatable = false)
    private String author;

    @Column(updatable = false)
    private int publishYear;

    @Column(updatable = false)
    public boolean status;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="book",fetch = FetchType.LAZY)
    private List<Rating> ratingList=new ArrayList<>();

    @JoinColumn(name = "e_library_id",nullable = false,referencedColumnName = "id",foreignKey = @ForeignKey(name="e_library_book_id"))
    @ManyToOne(cascade = CascadeType.ALL)
    private Elibrary e_library;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id",nullable = false,referencedColumnName = "id",foreignKey = @ForeignKey(name="course_book_id"))
    private Course course;

}
