package com.educatex.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Elibrary {
    @Id
    @Column(updatable = false)
    private Long id;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="e_library",fetch = FetchType.LAZY)
    private Set<Training> trainings=new HashSet<>();

    //Error creating bean with name 'entityManagerFactory' defined in class path resource mappedBy reference an unknown target entity property ,
    // the mappedBy value should be the same as the var name in books
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="e_library",fetch = FetchType.LAZY)
    private Set<Book> books;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="e_library",fetch = FetchType.LAZY)
    private Set<Assignment> assignments=new HashSet<>();
}
