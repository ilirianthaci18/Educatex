package com.educatex.lms.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Admin implements Serializable {

    @Id
    @SequenceGenerator(name = "admin_sequence", sequenceName = "admin_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_sequence")
    @Column(updatable = false)
    private Long id;

    @NonNull
    @Column(updatable = false)
    private String name;

    @NonNull
    @Column(updatable = false)
    private String lastName;

    @NonNull
    @Column(updatable = false)
    private char gender;

    @NonNull
    @Column(updatable = false)
    private int age;

    @NonNull
    @Column(updatable = false)
    private Long personalNum;

}
