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

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "elibrary_id",nullable = false,referencedColumnName = "id",foreignKey = @ForeignKey(name="elibrary_assignment_id"))
//    private Elibrary e_library;
}
