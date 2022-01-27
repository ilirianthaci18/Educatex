package com.educatex.lms.common.mappers;

import com.educatex.lms.common.dto.CourseDTO;

import com.educatex.lms.common.dto.CourseDTOStudent;
import com.educatex.lms.model.Course;
import org.modelmapper.ModelMapper;
import static com.educatex.lms.common.mappers.StudentMapper.toStudentDTO;
import static com.educatex.lms.common.mappers.ProfessorMapper.professorToCourse;
import static com.educatex.lms.common.mappers.BookMapper.bookDTOforCourse;

public class CourseMapper {

    public static CourseDTO toCourseDTO(Course course){
        ModelMapper modelMapper=new ModelMapper();
        CourseDTO courseDTO=modelMapper.map(course,CourseDTO.class);

        courseDTO.setCourseCode(course.getCourseCode());
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setId(course.getId());
        courseDTO.setEcts(course.getEcts());
        courseDTO.setProfessor(professorToCourse(course.getProfessor()));

        course.getEnrolledStudents().stream().forEach(student -> {
            courseDTO.getEnrolledStudents().add(toStudentDTO(student));
        });

        course.getBooks().stream().forEach(book -> {
            courseDTO.getBooks().add(bookDTOforCourse(book));
        });

        return courseDTO;
    }

    public static CourseDTOStudent toCourseDTOForStudents(Course course){
        ModelMapper modelMapper=new ModelMapper();
        CourseDTOStudent courseDTO=modelMapper.map(course,CourseDTOStudent.class);

        courseDTO.setCourseCode(course.getCourseCode());
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setId(course.getId());
        courseDTO.setEcts(course.getEcts());

        return courseDTO;
    }
}
