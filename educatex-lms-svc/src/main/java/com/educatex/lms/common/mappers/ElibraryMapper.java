package com.educatex.lms.common.mappers;

import com.educatex.lms.common.dto.AssignmentDTO;
import com.educatex.lms.common.dto.CourseDTO;
import com.educatex.lms.common.dto.ElibraryDTO;
import com.educatex.lms.common.dto.ElibraryDTOBook;
import com.educatex.lms.model.Assignment;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Elibrary;
import org.modelmapper.ModelMapper;

import static com.educatex.lms.common.mappers.TrainingMapper.trainingDTOElibrary;
import static com.educatex.lms.common.mappers.BookMapper.bookDTOforCourse;
import static com.educatex.lms.common.mappers.StudentMapper.toStudentDTO;

public class ElibraryMapper {

    public static ElibraryDTO toElibraryDTO(Elibrary elibrary){
        ModelMapper modelMapper=new ModelMapper();
        ElibraryDTO elibraryDTO=modelMapper.map(elibrary,ElibraryDTO.class);

        elibraryDTO.setName(elibrary.getName());

        elibrary.getTrainings().stream().forEach(training -> {
            elibraryDTO.getTrainings().add(trainingDTOElibrary(training));
        });

        elibrary.getBooks().stream().forEach(book -> {
            elibraryDTO.getBooks().add(bookDTOforCourse(book));
        });

        elibrary.getStudents().stream().forEach(student -> {
            elibraryDTO.getStudents().add(toStudentDTO(student));
        });

        elibrary.getAssignments().stream().forEach(assignment -> {
            elibraryDTO.getAssignments().add(toAssignmentDTO(assignment));
        });

        return elibraryDTO;
    }

    public static ElibraryDTOBook elibraryDTOBook(Elibrary elibrary){
        ModelMapper modelMapper=new ModelMapper();

        ElibraryDTOBook elibraryDTOBook=modelMapper.map(elibrary,ElibraryDTOBook.class);

        elibraryDTOBook.setName(elibrary.getName());

        return elibraryDTOBook;
    }

    public static AssignmentDTO toAssignmentDTO(Assignment assignment){
        ModelMapper modelMapper=new ModelMapper();

        AssignmentDTO assignmentDTO=modelMapper.map(assignment,AssignmentDTO.class);

        assignmentDTO.setDate(assignment.getDate());
        assignmentDTO.setName(assignment.getName());
        assignmentDTO.setDescription(assignment.getDescription());

        return assignmentDTO;
    }
}
