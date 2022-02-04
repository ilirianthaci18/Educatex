package com.educatex.lms.common.mappers;

import com.educatex.lms.common.dto.ProfessorDTO;
import com.educatex.lms.common.dto.ProfessorDTOCourse;
import com.educatex.lms.model.Professor;
import org.modelmapper.ModelMapper;

import static com.educatex.lms.common.mappers.CourseMapper.toCourseDTOForStudents;


public class ProfessorMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static ProfessorDTOCourse professorToCourse(Professor professor) {
        ProfessorDTOCourse professorDTOCourse = modelMapper.map(professor, ProfessorDTOCourse.class);

        professorDTOCourse.setName(professor.getName(), professor.getLastName());

        return professorDTOCourse;
    }

    public static ProfessorDTO professorDTO(Professor professor){
        ProfessorDTO professorDTO=modelMapper.map(professor,ProfessorDTO.class);

        professorDTO.setName(professor.getName());
        professorDTO.setLastName(professor.getLastName());
        professorDTO.setAge(professor.getAge());
        professorDTO.setGender(professor.getGender());
        professorDTO.setPersonalNum(professor.getPersonalNum());

        professor.getCourses().stream().forEach(course -> {
            professorDTO.addCourses(toCourseDTOForStudents(course));
        });

        return professorDTO;
    }
}
