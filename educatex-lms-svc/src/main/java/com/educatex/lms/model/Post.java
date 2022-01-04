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
public class Post {
    @Id
    @SequenceGenerator(name="post_sequence",sequenceName = "post_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "post_sequence")
    @Column(updatable = false)
    private Long postId;

    @Column(updatable = false)
    private String title;

    @Column(updatable = false)
    private String description;

    @Column(updatable = false)
    private String type;

    @Column(updatable = false)
    private Long postUserId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forum_id",referencedColumnName = "id")
    private Forum forum;
}
