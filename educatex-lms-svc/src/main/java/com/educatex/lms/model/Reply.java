package com.educatex.lms.model;

import com.educatex.lms.observer.Observable;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Reply extends Observable implements Serializable {
    @Id
    @SequenceGenerator(name="reply_sequence",sequenceName = "reply_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "reply_sequence")
    @Column(updatable = false)
    private Long reply_id;

    @NonNull
    @Column
    private String title;

    @NonNull
    @Column
    private String description;

    @NonNull
    @Column
    private String type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_id",referencedColumnName = "id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id",referencedColumnName = "postId")
    private Post post;

    public void setPost(Post post){
        this.post=post;
        setChanged();
        notifyObservers(post);
    }
}
