package com.educatex.lms.common.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingDTO {
    private String title;

    private String description;

    private String category;

    private LocalDate date;

    private List<RatingDTO> ratingDTOList=new ArrayList<>();

    @JsonManagedReference
    public List<RatingDTO> getRatingDTOList() {
        return ratingDTOList;
    }
}
