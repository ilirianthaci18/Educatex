package com.educatex.lms.common.dto;

import com.educatex.lms.model.Forum;
import com.educatex.lms.model.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private String title;

    private String description;

    private String type;

    private List<ReplyDTO> replies=new ArrayList<>();

    private StudentDTOPost post_author;

    @JsonManagedReference
    public List<ReplyDTO> getReplies() {
        return replies;
    }

    @JsonManagedReference
    public StudentDTOPost getPost_author() {
        return post_author;
    }
}
