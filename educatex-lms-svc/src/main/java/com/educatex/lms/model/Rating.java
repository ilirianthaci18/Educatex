package com.educatex.lms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity
public class Rating {
    @Id
    @SequenceGenerator(name="rating_sequence",sequenceName = "rating_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "rating_sequence")
    @Column(updatable = false)
    private Long id;

    @Column(updatable = false)
    private int rating;

    @Column(updatable = false)
    private String review;

    @JoinColumn(name = "author_id",nullable = false,referencedColumnName = "id",foreignKey = @ForeignKey(name="author_rating_id"))
    @ManyToOne(cascade = CascadeType.ALL)
    private Student author;

    @JoinColumn(name = "book_id",nullable = false,referencedColumnName = "id",foreignKey = @ForeignKey(name="book_rating_id"))
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    @JoinColumn(name = "Training_id",nullable = false,referencedColumnName = "id",foreignKey = @ForeignKey(name="training_rating_id"))
    @ManyToOne(cascade = CascadeType.ALL)
    private Training training;

}
