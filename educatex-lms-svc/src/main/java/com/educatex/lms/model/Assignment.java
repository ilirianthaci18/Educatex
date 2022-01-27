package com.educatex.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Assignment {
    @Id
    @SequenceGenerator(name="assignment_sequence",sequenceName = "assignment_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "assignment_sequence")
    @Column(updatable = false)
    private Long id;

    @NonNull
    @Column()
    private String name;

    @NonNull
    @Column()
    private String description;

    @Column()
    private LocalDate date= LocalDate.now();

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "e_library_id",referencedColumnName = "id")
    private Elibrary e_library;

    @JsonManagedReference
    public Elibrary getE_library() {
        return e_library;
    }

}
