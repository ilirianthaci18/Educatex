package com.educatex.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Forum {

    @Id
    @SequenceGenerator(name="forum_sequence",sequenceName = "forum_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "forum_sequence")
    @Column(updatable = false)
    private Long id;

    @NonNull
    @Column
    private String name;

    @NonNull
    @Column
    private String forumDescription;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy="forum",fetch = FetchType.LAZY)
    private List<Post> posts=new ArrayList<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy="forum",fetch = FetchType.LAZY)
    private Set<Student> users=new HashSet<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy="forum",fetch = FetchType.LAZY)
    private Set<Professor> admins=new HashSet<>();

    @JsonManagedReference
    public List<Post> getPosts() {
        return posts;
    }

    @JsonManagedReference
    public Set<Student> getUsers() {
        return users;
    }

    @JsonManagedReference
    public Set<Professor> getAdmins() {
        return admins;
    }

    public void addPost(Post post){
        if(!posts.contains(post)){
            posts.add(post);
            post.setForum(this);
        }
    }

    public void addUsers(Student user){
        if(!users.contains(user)){
            users.add(user);
            user.setForum(this);
        }
    }

    public void addAdmins(Professor admin){
        if(!admins.contains(admin)){
            admins.add(admin);
            admin.setForum(this);
        }
    }
}
