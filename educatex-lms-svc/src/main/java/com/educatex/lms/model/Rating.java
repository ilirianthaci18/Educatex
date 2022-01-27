package com.educatex.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Rating {
    @Id
    @SequenceGenerator(name="rating_sequence",sequenceName = "rating_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "rating_sequence")
    @Column(updatable = false)
    private Long id;

    @NonNull
    @Column
    private int rating;

    @NonNull
    @Column
    private String review;

    @JsonIgnore
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Student author;

    @JsonIgnore
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    @JsonIgnore
    @JoinColumn(name = "Training_id",referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Training training;

    @JsonManagedReference
    public Student getAuthor() {
        return author;
    }

    @JsonManagedReference
    public Book getBook() {
        return book;
    }

    @JsonManagedReference
    public Training getTraining() {
        return training;
    }

}
