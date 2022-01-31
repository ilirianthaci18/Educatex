package com.educatex.lms.repository;

import com.educatex.lms.model.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ForumRepository extends JpaRepository<Forum,Long> {

    //    @Query("SELECT post FROM Post post WHERE post.date= :date ") // TODO should implement data attribute
//    List<Post> findByPostAndCreatedAt(@Param("date") LocalDate date);

    @Query("SELECT COUNT (post) FROM Post post")
    Integer countPost();
}
