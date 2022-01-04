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
@Entity(name = "Elibrary")
@Table(name = "elibrary")
public class Elibrary {
    @Id
    @Column(updatable = false)
    private Long id;

//    @JsonIgnore
//    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="elibrary",fetch = FetchType.LAZY)
//    private Set<Training> trainings=new HashSet<>();
//
//    @JsonIgnore
//    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="elibrary",fetch = FetchType.LAZY)
//    private Set<Book> books=new HashSet<>();
//
//    @JsonIgnore
//    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="elibrary",fetch = FetchType.LAZY)
//    private Set<Assignment> assignments=new HashSet<>();
}
