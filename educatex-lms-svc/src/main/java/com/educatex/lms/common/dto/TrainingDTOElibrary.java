package com.educatex.lms.common.dto;

import com.educatex.lms.model.Rating;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingDTOElibrary {

    private String title;

    private String description;

    private String category;

    private LocalDate date;

//    private Integer rating;
//
//    public void addRating(int i,int y){
//        int ratting=0;
//        ratting+=i;
//
//    }
}
