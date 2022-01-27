package com.educatex.lms.common.dto;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTOCourse {

    private String title;

    private String author;

    private int publishYear;
}
