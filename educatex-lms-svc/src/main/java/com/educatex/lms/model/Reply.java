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
public class Reply {
    @Id
    @SequenceGenerator(name="reply_sequence",sequenceName = "reply_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "reply_sequence")
    @Column(updatable = false)
    private Long reply_id;

    @Column(updatable = false)
    private String title;

    @Column(updatable = false)
    private String description;

    @Column(updatable = false)
    private String type;

    @Column(updatable = false)
    private Long replyUserId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forum_id",referencedColumnName = "id")
    private Forum forum;
}
