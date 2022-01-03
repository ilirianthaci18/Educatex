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

    @ManyToOne
    private Elibrary e_library;
}
