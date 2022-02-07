package com.educatex.lms.repository;

import com.educatex.lms.model.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ForumRepository extends JpaRepository<Forum,Long> {

    @Query("SELECT COUNT (post) FROM Post post")
    Integer countPost();
}
