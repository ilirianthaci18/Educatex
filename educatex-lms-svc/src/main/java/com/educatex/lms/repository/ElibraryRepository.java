package com.educatex.lms.repository;

import com.educatex.lms.model.Elibrary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElibraryRepository extends JpaRepository<Elibrary,Long> {

}
