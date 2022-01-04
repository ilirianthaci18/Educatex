package com.educatex.lms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private Long bookId;

    @Column(updatable = false)
    private String title;

    @Column(updatable = false)
    private String author;

    @Column(updatable = false)
    private int publishYear;

    @Column(updatable = false)
    public boolean status;

//    List<Rating> ratingList

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "elibrary_id",nullable = false,referencedColumnName = "id",foreignKey = @ForeignKey(name="elibrary_book_id"))
//    private Elibrary e_library;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "elibrary_id",nullable = false,referencedColumnName = "id",foreignKey = @ForeignKey(name="course_book_id"))
    private Course course;
}
