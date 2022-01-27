package com.educatex.lms.common.mappers;

import com.educatex.lms.common.dto.ProfessorDTOCourse;
import com.educatex.lms.model.Professor;
import org.modelmapper.ModelMapper;


public class ProfessorMapper {

    public static ProfessorDTOCourse professorToCourse(Professor professor){
        ModelMapper modelMapper=new ModelMapper();
        ProfessorDTOCourse professorDTOCourse=modelMapper.map(professor,ProfessorDTOCourse.class);

        professorDTOCourse.setName(professor.getName(),professor.getLastName());

        return professorDTOCourse;
    }
}
