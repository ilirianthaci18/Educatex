package com.educatex.lms.model;

import com.educatex.lms.observer.Observable;
import com.educatex.lms.observer.Observer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Post implements Observer, Serializable {

    @Id
    @SequenceGenerator(name="post_sequence",sequenceName = "post_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "post_sequence")
    @Column(updatable = false)
    private Long postId;

    @NonNull
    @Column
    private String title;

    @NonNull
    @Column
    private String description;

    @NonNull
    @Column
    private String type;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy="post",orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Reply> replies=new ArrayList<>();

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_id",referencedColumnName = "id")
    private Student post_author;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forum_id",referencedColumnName = "id")
    private Forum forum;

    @JsonManagedReference
    public List<Reply> getReplies() {
        return replies;
    }

    @JsonManagedReference
    public Student getPost_author() {
        return post_author;
    }

    public void addReply(Reply reply){
        if(!replies.contains(reply)){
            replies.add(reply);
            reply.setPost(this);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        this.addReply((Reply) arg);
    }
}
