package com.educatex.lms.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Training {
    @Id
    @SequenceGenerator(name="training_sequence",sequenceName = "training_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "training_sequence")
    @Column(updatable = false)
    private Long id;

    @Column(updatable = false)
    private String title;

    @Column(updatable = false)
    private String description;

    @Column(updatable = false)
    private String category;

    @Column(updatable = false)
    private LocalDate date= LocalDate.now();

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="training",fetch = FetchType.LAZY)
    private List<Rating> ratingList=new ArrayList<>();

    @JoinColumn(name = "e_library_id",nullable = false,referencedColumnName = "id",foreignKey = @ForeignKey(name="e_library_training_id"))
    @ManyToOne(cascade = CascadeType.ALL)
    private Elibrary e_library;

}
