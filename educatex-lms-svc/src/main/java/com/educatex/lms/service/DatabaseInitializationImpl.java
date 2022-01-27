package com.educatex.lms.service;

import com.educatex.lms.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
public class DatabaseInitializationImpl implements DatabaseIntialization{

    private AdminService adminService;
    private StudentService studentService;
    private ProfessorService professorService;
    private CourseService courseService;
    private ElibraryService elibraryService;
    private ForumService forumService;

    public DatabaseInitializationImpl(AdminService adminService, StudentService studentService, ProfessorService professorService, CourseService courseService, ElibraryService elibraryService, ForumService forumService) {
        this.adminService = adminService;
        this.studentService = studentService;
        this.professorService = professorService;
        this.courseService = courseService;
        this.elibraryService = elibraryService;
        this.forumService = forumService;
    }

    @PostConstruct
    @Override
    public void initDB() {
    //        initializeAdmins();
    //        initializeProfessors();
    //        initializeStudents();
    //        initializeElibrary();
    //        initializeForum();
    //        initializeCourse();
    //
    //
    //        initializeBooks();
    //        initializeAssignments();
    //        initializePost();
//            initializeReply();
    //        initializeTraning();
//            initializeRatings();

//        initializeRelationsCourse(); // DO NOT UNCOMMENT THIS
    }

    private void initializeRelationsCourse(){
        Professor professor=professorService.getProfessorById(1L);
        Professor professor2=professorService.getProfessorById(2L);
        Student student1=studentService.getStudentdById(1L);
        Student student2=studentService.getStudentdById(2L);
//        Book book1=elibraryService.getBookById(1L);
//        Book book2=elibraryService.getBookById(2L);
//        Book book3=elibraryService.getBookById(3L);


        Course course1=courseService.findCourseId(1L);
//        courseService.assignProfessorToSubject(course1.getId(), professor.getId());
        courseService.addStudentToSubject(course1.getId(), student1.getId(), course1.getCourseCode());
//        courseService.addStudentToSubject(course1.getId(), student2.getId(), course1.getCourseCode());
//        courseService.assignBookToCourse(course1.getId(), book1.getId());
//        courseService.assignBookToCourse(course1.getId(), book2.getId());
//        courseService.assignBookToCourse(course1.getId(), book3.getId());
        courseService.saveCourse(course1);

//        Course course2=courseService.findCourseId(2L);
//        courseService.assignProfessorToSubject(course2.getId(), professor2.getId());
//        courseService.addStudentToSubject(course2.getId(), student1.getId(), course2.getCourseCode());
////        courseService.addStudentToSubject(course2.getId(), student2.getId(), course2.getCourseCode());
////        courseService.assignBookToCourse(course2.getId(), book1.getId());
////        courseService.assignBookToCourse(course2.getId(), book2.getId());
////        courseService.assignBookToCourse(course2.getId(), book3.getId());
//        courseService.saveCourse(course2);
//
//        Course course3=courseService.findCourseId(3L);
//        courseService.assignProfessorToSubject(course3.getId(), professor2.getId());
//        courseService.addStudentToSubject(course3.getId(), student1.getId(), course3.getCourseCode());
////        courseService.addStudentToSubject(course3.getId(), student2.getId(), course3.getCourseCode());
////        courseService.assignBookToCourse(course3.getId(), book1.getId());
////        courseService.assignBookToCourse(course3.getId(), book2.getId());
////        courseService.assignBookToCourse(course3.getId(), book3.getId());
//        courseService.saveCourse(course3);

    }
    private void initializeAdmins(){
        Admin admin=new Admin("Denzel","Washington",'M',56,100200300400L);

        adminService.addNewAdmin(admin);
    }

    private void initializeProfessors(){
        Professor professor=new Professor("Chris","Voss",'M',42,1020354978765456L);
        Professor professor2=new Professor("Cory","Snowden",'F',40,6532987412659843L);

        professorService.saveProfessor(professor);
        professorService.saveProfessor(professor2);
    }

    private void initializeStudents(){
        Student student=new Student("John","Doe",'M',20,10203040506070L);
        Student student2=new Student("Jane","Doe",'F',21,70809010203040L);

        studentService.saveStudent(student);
        studentService.saveStudent(student2);
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
