package com.educatex.lms.service;

import com.educatex.lms.model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@Service
public class DatabaseInitializationImpl implements DatabaseIntialization{

    private AdminService adminService;
    private StudentService studentService;
    private ProfessorService professorService;
    private CourseService courseService;
    private ElibraryService elibraryService;
    private ForumService forumService;
    private EnrollService enrollService;

    @PostConstruct
    @Override
    public void initDB() {

//        Search search=new Search("asdasdasd");
//        studentService.saveSearch(search);
//            initializeAdmins();
//            initializeProfessors();
//            initializeStudents();
//            initializeElibrary();
//            initializeForum();
//            initializeCourse();
//
//
//            initializeBooks();
//            initializeAssignments();
//            initializePost();
//            initializeReply();
//            initializeTraning();
//            initializeRatings();

//        initializeRelationsCourse(); // DO NOT UNCOMMENT THIS
    }

    private void initializeRelationsCourse(){
//        courseService.assignBookToCourse(1L,1L);
//        enrollService.addStudentToSubject(1L,1L,"CSE1920");
//        enrollService.addStudentToSubject(2L,2L,"CSE1920");
//        enrollService.assignProfessorToSubject(1L,1L);
//        enrollService.assignProfessorToSubject(2L,1L);
//
//        elibraryService.addBookToElibrary(1L,1L);
//        elibraryService.addRatingToBook(1L,1L);
//        elibraryService.addRatingToBook(2L,1L);
//
//        elibraryService.addStudentToElibrary(1L,1L);
//        elibraryService.addTrainingToElibrary(1L,1L);
//        elibraryService.addTrainingToElibrary(1L,2L);
//        elibraryService.addRatingToTraining(1L,1L);
//        elibraryService.addRatingToTraining(1L,2L);
//        elibraryService.addAssignmentToElibrary(1L,1L);
//
//
//        forumService.addPostToForum(1L,1L);
//        forumService.addPostToForum(1L,2L);
//        forumService.addReplyToPost(1L,1L);
//        forumService.addReplyToPost(1L,2L);
//
//        forumService.addUserToForum(1L,1L);
//        forumService.addUserToForum(1L,2L);

    }
    private void initializeAdmins(){
//        Admin admin=new Admin("Denzel","Washington",'M',56,100200300400L);

//        adminService.addNewAdmin(admin);
    }

    private void initializeProfessors(){
        Professor professor=new Professor.ProfessorBuilder()
                .name("Chris")
                .lastName("Voss")
                .gender('M')
                .age(42)
                .personalNum(1020354978765456L)
                .build();

        Professor professor2=new Professor.ProfessorBuilder()
                .name("Cory")
                .lastName("Snowden")
                .gender('F')
                .age(40)
                .personalNum(6532987412659843L)
                .build();

        professorService.saveProfessor(professor);
        professorService.saveProfessor(professor2);
    }

    private void initializeStudents(){
        Student student=new Student.StudentBuilder()
                .setName("John")
                .setLastName("Doe")
                .setGender('M')
                .setAge(20)
                .setPersonalNum(10203040506070L)
                .setRregullt(true)
                .build();

        Student student1=new Student.StudentBuilder()
                .setName("Jane")
                .setLastName("Doe")
                .setGender('F')
                .setAge(21)
                .setPersonalNum(70809010203040L)
                .setRregullt(true)
                .build();

        studentService.saveStudent(student);
        studentService.saveStudent(student1);
    }

    private void initializeElibrary(){
        Elibrary elibrary=new Elibrary("CSE-ELIBRARY");

        elibraryService.saveElibrary(elibrary);
    }

    private Forum initializeForum(){
        Forum forum=new Forum("CSEFORUM","This forum will help the students of CSE to find their solutions");

        forumService.saveForum(forum);

        return forum;
    }

    private void initializeCourse(){
        Course course1=new Course("Java 1","CSE1920",6);
        Course course2=new Course("Java 2","CSE1920",6);
        Course course3=new Course("Software Design","CSE1920",6);

        courseService.saveCourse(course1);
        courseService.saveCourse(course2);
        courseService.saveCourse(course3);
    }

    private void initializeBooks(){
        Book book1=new Book("Clean Code","Robert Cecil Martin",2008,true);
        Book book2=new Book("Spring Boot in Action","Craig Walls",2015,true);
        Book book3=new Book(" Spring Microservices in Action","John Carnell",2017,true);

        elibraryService.saveBook(book1);
        elibraryService.saveBook(book2);
        elibraryService.saveBook(book3);
    }

    private void initializeAssignments(){
        Assignment assignment1=new Assignment("Array Partition I","Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1)");
        Assignment assignment2=new Assignment("Shortest Palindrome","You are given a string s. You can convert s to a palindrome by adding characters in front of it.");
        Assignment assignment3=new Assignment("Remove Element","Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. ");

        elibraryService.addAssignment(assignment1);
        elibraryService.addAssignment(assignment2);
        elibraryService.addAssignment(assignment3);
    }

    private void initializePost(){
        Post post=new Post("My first post","This is my first post for this season","Post");
        Post post2=new Post("My second post","This is my second post for this season","Post");
        Post post3=new Post("My third post","This is my third post for this season","Post");

        forumService.addPost(post);
        forumService.addPost(post2);
        forumService.addPost(post3);
    }

    private void initializeReply(){
        Reply reply=new Reply("Reply1","This is not good","reply");
        Reply reply2=new Reply("Reply2","This is good","reply");
        Reply reply3=new Reply("Reply3","This is great","reply");

        forumService.addReply(reply);
        forumService.addReply(reply2);
        forumService.addReply(reply3);
    }

    private void initializeTraning(){
        Training training=new Training("Master Microservices with Spring Boot and Spring Cloud","Go from Restful Web Services ( REST API ) to Microservices - Java , Spring Boot , Spring Cloud , Docker and Kubernetes",
                "Web Development Microservices");
        Training training1=new Training("Apache Kafka Series - Learn Apache Kafka for Beginners v2","START HERE: Learn Apache Kafka 2.0 Ecosystem, Core Concepts, Real World Java Producers/Consumers & Big Data Architecture","Database Design & Development");

        Training training2=new Training("Docker Mastery: with Kubernetes +Swarm from a Docker Captain","Build, test, deploy containers with the best mega-course on Docker, Kubernetes, Compose, Swarm and Registry using DevOps","Software Development Tools");

        elibraryService.addTraining(training);
        elibraryService.addTraining(training1);
        elibraryService.addTraining(training2);
    }

    private void initializeRatings(){
        Rating rating=new Rating(3,"This was  a good book");
        Rating rating1=new Rating(5,"This was a great book");
        Rating rating2=new Rating(5,"This was a great training");

        elibraryService.addRatingDb(rating);
        elibraryService.addRatingDb(rating1);
        elibraryService.addRatingDb(rating2);
    }
}
