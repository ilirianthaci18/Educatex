package com.educatex.lms.common.mappers;

import com.educatex.lms.common.dto.RatingDTO;
import com.educatex.lms.common.dto.TrainingDTO;
import com.educatex.lms.common.dto.TrainingDTOElibrary;
import com.educatex.lms.model.Rating;
import com.educatex.lms.model.Training;
import org.modelmapper.ModelMapper;

public class TrainingMapper {
    public static ModelMapper modelMapper=new ModelMapper();

    public static TrainingDTO toTrainingDTO(Training training){
        TrainingDTO trainingDTO=modelMapper.map(training,TrainingDTO.class);

        trainingDTO.setCategory(training.getCategory());
        trainingDTO.setDate(training.getDate());
        trainingDTO.setDescription(training.getDescription());
        trainingDTO.setTitle(training.getTitle());

        training.getRatingList().stream().forEach(rating -> {
            trainingDTO.getRatingDTOList().add(toRatingDto(rating));
        });

        return trainingDTO;
    }

    public static TrainingDTOElibrary trainingDTOElibrary(Training training){
        TrainingDTOElibrary trainingDTOElibrary=modelMapper.map(training,TrainingDTOElibrary.class);

        trainingDTOElibrary.setCategory(training.getCategory());
        trainingDTOElibrary.setDate(training.getDate());
        trainingDTOElibrary.setDescription(training.getDescription());
        trainingDTOElibrary.setTitle(training.getTitle());

//        training.getRatingList().stream().forEach(rating -> {
//            int ratingAvsg=rating.getRating();
//            int count=0;
//            count++; // this should be fixed by /
//            trainingDTOElibrary.addRating(ratingAvsg,count);
//        });

        return trainingDTOElibrary;
    }

    public static RatingDTO toRatingDto(Rating rating){
        RatingDTO ratingDTO=modelMapper.map(rating,RatingDTO.class);

        ratingDTO.setRating(rating.getRating());
        ratingDTO.setReview(rating.getReview());

        return ratingDTO;
    }

}
