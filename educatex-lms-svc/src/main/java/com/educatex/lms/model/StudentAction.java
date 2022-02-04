package com.educatex.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class StudentAction implements Serializable {

    @Id
    @SequenceGenerator(name="student_action_sequence",sequenceName = "student_action_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_action_sequence")
    @Column
    private Long id;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true,mappedBy="studentAction",fetch = FetchType.LAZY)
    private List<Search> searches=new ArrayList<>();

}
