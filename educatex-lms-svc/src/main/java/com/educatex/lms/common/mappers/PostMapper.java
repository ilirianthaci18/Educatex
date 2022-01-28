package com.educatex.lms.common.mappers;

import com.educatex.lms.common.dto.PostDTO;
import com.educatex.lms.common.dto.PostDTOStudent;
import com.educatex.lms.common.dto.ReplyDTO;
import com.educatex.lms.common.dto.StudentDTOPost;
import com.educatex.lms.model.Post;
import com.educatex.lms.model.Reply;
import com.educatex.lms.model.Student;
import org.modelmapper.ModelMapper;

public class PostMapper {
    private static ModelMapper modelMapper=new ModelMapper();

    public static PostDTO toPostDTO(Post post){
        PostDTO postDTO=modelMapper.map(post,PostDTO.class);
        postDTO.setTitle(post.getTitle());
        postDTO.setDescription(post.getDescription());
        postDTO.setPost_author(studentDTOPost(post.getPost_author()));
        postDTO.setType(post.getType());

        post.getReplies().stream().forEach(reply -> {
            postDTO.getReplies().add(toReplyDTO(reply));
        });

        return postDTO;
    }

    public static StudentDTOPost studentDTOPost(Student student){
        StudentDTOPost studentDTOPost=modelMapper.map(student,StudentDTOPost.class);

        studentDTOPost.setName(student.getName());
        studentDTOPost.setLastName(student.getLastName());

        return studentDTOPost;
    }

    public static PostDTOStudent postDTOforStudent(Post post){
        PostDTOStudent postDTOStudent=modelMapper.map(post,PostDTOStudent.class);

        postDTOStudent.setTitle(post.getTitle());
        postDTOStudent.setDescription(post.getDescription());

        return postDTOStudent;
    }

    public static ReplyDTO toReplyDTO(Reply reply){
        ReplyDTO replyDTO=modelMapper.map(reply,ReplyDTO.class);

        replyDTO.setDescription(reply.getDescription());
        replyDTO.setTitle(reply.getTitle());
        replyDTO.setType(reply.getType());

        return replyDTO;
    }

}
