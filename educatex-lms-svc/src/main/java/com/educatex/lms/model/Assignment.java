package com.educatex.lms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Assignment {
    @Id
    @SequenceGenerator(name="assignment_sequence",sequenceName = "assignment_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "assignment_sequence")
    @Column(updatable = false)
    private Long id;

    @Column(updatable = false)
    private String name;

    @Column(updatable = false)
    private String description;

    @Column(updatable = false)
    private LocalDate date= LocalDate.now();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "e_library_id",nullable = false,referencedColumnName = "id",foreignKey = @ForeignKey(name="e_library_assignment_id"))
    private Elibrary e_library;
}
