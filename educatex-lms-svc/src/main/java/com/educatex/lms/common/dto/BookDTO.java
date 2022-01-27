package com.educatex.lms.common.dto;

import com.educatex.lms.model.Course;
import com.educatex.lms.model.Elibrary;
import com.educatex.lms.model.Rating;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String title;

    private String author;

    private int publishYear;

    private boolean status;

    private List<RatingDTO> ratingList=new ArrayList<>();

    @JsonManagedReference
    public List<RatingDTO> getRatingList() {
        return ratingList;
    }


}
