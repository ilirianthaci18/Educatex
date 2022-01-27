package com.educatex.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Book {

    @Id
    @SequenceGenerator(name="book_sequence",sequenceName = "book_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_sequence")
    @Column(updatable = false)
    private Long id;

    @NonNull
    @Column
    private String title;

    @NonNull
    @Column
    private String author;

    @NonNull
    @Column
    private int publishYear;

    @NonNull
    @Column
    private boolean status;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy="book",orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Rating> ratingList=new ArrayList<>();

    @JsonIgnore
    @JoinColumn(name = "e_library_id",referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Elibrary e_library;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    private Course course;

    @JsonManagedReference
    public Elibrary getE_library() {
        return e_library;
    }

    @JsonManagedReference
    public Course getCourse() {
        return course;
    }

    @JsonManagedReference
    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void addRatingToList(Rating rating){
        if(!ratingList.contains(rating)){
            ratingList.add(rating);
            rating.setBook(this);
        }
    }
}
