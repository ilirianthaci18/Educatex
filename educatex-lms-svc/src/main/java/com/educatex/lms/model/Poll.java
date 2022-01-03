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


    @ManyToOne
    private Forum forum;
}
