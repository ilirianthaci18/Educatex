package com.educatex.lms.common.mappers;

import com.educatex.lms.common.dto.BookDTO;
import com.educatex.lms.common.dto.BookDTOCourse;
import com.educatex.lms.model.Book;
import org.modelmapper.ModelMapper;

import static com.educatex.lms.common.mappers.TrainingMapper.toRatingDto;

public class BookMapper {
    private static ModelMapper modelMapper=new ModelMapper();;

    public static BookDTOCourse bookDTOforCourse(Book book){

        BookDTOCourse bookDTOCourse=modelMapper.map(book,BookDTOCourse.class);

        bookDTOCourse.setAuthor(book.getAuthor());
        bookDTOCourse.setTitle(book.getTitle());
        bookDTOCourse.setPublishYear(book.getPublishYear());

        return bookDTOCourse;
    }
    public static BookDTO toBookDTO(Book book){
        BookDTO bookDTO=modelMapper.map(book,BookDTO.class);

        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPublishYear(book.getPublishYear());
        bookDTO.setStatus(book.isStatus());
        bookDTO.setTitle(book.getTitle());

        book.getRatingList().stream().forEach(rating -> {
            bookDTO.getRatingList().add(toRatingDto(rating));
        });

        return bookDTO;
    }
}
