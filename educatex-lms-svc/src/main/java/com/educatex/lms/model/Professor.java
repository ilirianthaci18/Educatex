package com.educatex.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Professor {
    @Id
    @SequenceGenerator(name="professor_sequence",sequenceName = "professor_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "professor_sequence")
    @Column(updatable = false)
    private Long id;

    @NonNull
    @Column
    private String name;

    @NonNull
    @Column
    private String lastName;

    @NonNull
    @Column
    private char gender;

    @NonNull
    @Column
    private int age;

    @NonNull
    @Column
    private Long personalNum;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "professor",orphanRemoval = true)
    private Set<Course> courses=new HashSet<>();

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forum_id",referencedColumnName = "id")
    private Forum forum;

    @Transactional
    @JsonManagedReference
    public Set<Course> getCourses() {
        return courses;
    }
}
