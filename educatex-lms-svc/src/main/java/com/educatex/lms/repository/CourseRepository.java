package com.educatex.lms.repository;

import com.educatex.lms.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    @Query("SELECT course FROM Course course WHERE course.courseName= :name")
    List<Course> findCourseByName(@Param("name") String name);

    @Query("SELECT course FROM Course course WHERE course.dateTime = :date")
    List<Course> findByCoursesCreatedAt(@Param("date") LocalDateTime date);

    @Query("SELECT course FROM Course course WHERE course.ects = :ects")
    List<Course> findByCoursesEcts(@Param("ects") int ects);

    @Query("SELECT COUNT (course) FROM Course course")
    Integer countCourses();
}
