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
public class Admin{
    @Id
    @SequenceGenerator(name="admin_sequence",sequenceName = "admin_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "admin_sequence")
    @Column(updatable = false)
    private Long id;

    @Column(updatable = false)
    private String name;

    @Column(updatable = false)
    private String lastName;

    @Column(updatable = false)
    private char gender;

    @Column(updatable = false)
    private int age;

    @Column(updatable = false)
    private Long personalNum;

}
