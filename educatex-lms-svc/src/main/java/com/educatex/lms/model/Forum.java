package com.educatex.lms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Forum {
    @Id
    @Column(updatable = false)
    private Long id;

    private String name;

    private String forumDescription;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="forum",fetch = FetchType.LAZY)
    private List<Reply> replies=new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="forum",fetch = FetchType.LAZY)
    private List<Post> posts=new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="forum",fetch = FetchType.LAZY)
    private List<Poll> polls=new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="forum",fetch = FetchType.LAZY)
    private Set<Student> users=new HashSet<>();

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="forum",fetch = FetchType.LAZY)
    private Set<Professor> admins=new HashSet<>();
}
