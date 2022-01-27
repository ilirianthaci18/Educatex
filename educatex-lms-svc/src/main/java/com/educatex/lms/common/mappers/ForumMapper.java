package com.educatex.lms.common.mappers;

import com.educatex.lms.common.dto.ForumDTO;
import com.educatex.lms.model.Forum;
import org.modelmapper.ModelMapper;

import static com.educatex.lms.common.mappers.PostMapper.postDTOforStudent;
import static com.educatex.lms.common.mappers.ProfessorMapper.professorToCourse;
import static com.educatex.lms.common.mappers.StudentMapper.toStudentDTO;

public class ForumMapper {

    public static ForumDTO toForumDTO(Forum forum){
        ModelMapper modelMapper=new ModelMapper();
        ForumDTO forumDTO=modelMapper.map(forum,ForumDTO.class);

        forumDTO.setName(forum.getName());
        forumDTO.setForumDescription(forum.getForumDescription());

        forum.getPosts().stream().forEach(post -> {
            forumDTO.getPosts().add(postDTOforStudent(post));
        });

        forum.getAdmins().stream().forEach(professor -> {
            forumDTO.getAdmins().add(professorToCourse(professor));
        });

        forum.getUsers().stream().forEach(user->{
            forumDTO.getUsers().add(toStudentDTO(user));
        });


        return forumDTO;
    }

}
