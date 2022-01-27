package com.educatex.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Poll {
    @Id
    @SequenceGenerator(name="poll_sequence",sequenceName = "poll_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "poll_sequence")
    @Column(updatable = false)
    private Long pollId;

    @Column(updatable = false)
    private String type;

    @Column(updatable = false)
    private String description;

//    @Column
//    private List<String> options=new ArrayList<>();

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forum_id",referencedColumnName = "id")
    private Forum forum;


}
