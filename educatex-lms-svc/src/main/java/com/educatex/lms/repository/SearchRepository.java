package com.educatex.lms.repository;

import com.educatex.lms.model.Search;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRepository extends JpaRepository<Search,Long> {
}
