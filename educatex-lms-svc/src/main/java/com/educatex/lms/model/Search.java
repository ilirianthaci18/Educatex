package com.educatex.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Search {

    @Id
    @SequenceGenerator(name="search_sequence",sequenceName = "search_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "search_sequence")
    @Column
    private Long id;

    @NonNull
    @Column
    private String search;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "search_id",referencedColumnName = "id")
    private Student studentAction;
}
