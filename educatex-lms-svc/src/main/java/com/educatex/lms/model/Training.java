package com.educatex.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Training implements Serializable {
    @Id
    @SequenceGenerator(name="training_sequence",sequenceName = "training_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "training_sequence")
    @Column(updatable = false)
    private Long id;

    @NonNull
    @Column
    private String title;

    @NonNull
    @Column
    private String description;

    @NonNull
    @Column
    private String category;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column
    private LocalDate date= LocalDate.now();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy="training",orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Rating> ratingList=new ArrayList<>();

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "e_library_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="e_library_training_id"))
    private Elibrary e_library;

    @JsonManagedReference
    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void addRatingToTraining(Rating rating){
        if(!ratingList.contains(rating)){
            ratingList.add(rating);
            rating.setTraining(this);
        }
    }
}
