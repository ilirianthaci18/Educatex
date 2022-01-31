package com.educatex.lms.repository;

import com.educatex.lms.model.Admin;
import com.educatex.lms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

    @Query("SELECT admin FROM Admin admin WHERE admin.name= :firstName")
    List<Admin> findAllByFirstName(@Param("firstName") String firstName);

    @Query("SELECT COUNT (admin) FROM Admin admin")
    Integer countAdmins();
}
