
import { makeAutoObservable, runInAction } from "mobx";
import agent from "../api/agent";
import { IBook } from "../models/book";
import { ICourse } from "../models/course";
import { IProfessor } from "../models/professor";

export default class CourseStore {
    courseRegistry = new Map<string, ICourse>();
    selectedCourse: ICourse | undefined = undefined;
    editMode = false;
    loading = false;
    bookRegistry = new Map<string, IBook>();
    selectedBook: IBook | undefined = undefined;
    professorRegistry = new Map<string, IProfessor>();
    selectedProfessor: IProfessor | undefined = undefined;

    constructor() {
        makeAutoObservable(this)
    }

    getCourseByName() {
        return Array.from(this.courseRegistry.values());
    }

    loadCourses = async () => {
        try{
            const Courses = await agent.Courses.getCourses();
            Courses.forEach(course => {
                this.courseRegistry.set(course.id, course);
            })
        } catch (error) {
            console.log(error);
        }
    }

    selectcourse = (id: string) => {
        this.selectedCourse = this.courseRegistry.get(id);
    }

    cancelselectedCourse = () => {
        this.selectedCourse = undefined;
    }

    openForm = (id?: string) => {
        id ? this.selectcourse(id) : this.cancelselectedCourse();
        this.editMode = true;
    }

    closeForm = () => {
        this.editMode = false;
    }

    createcourse = async (course: ICourse) => {
        try {
            await agent.Courses.insertCourse(course);
            runInAction(() => {
                this.courseRegistry.set(course.id , course);
                this.selectedCourse = course;
                this.editMode = false;
            })
        } catch (error) {
            console.log(error);
        }
    }

    updatecourse = async (course: ICourse) => {
        try {
            await agent.Courses.updateCourse(course);
            runInAction(() => {
                this.courseRegistry.set(course.id, course);
                this.selectedCourse = course;
                this.editMode = false;
            })
        } catch (error) {
            console.log(error);
        }
    }

    deletecourse = async (id: string) => {
        try {
            await agent.Courses.deleteCourse(id);
            runInAction(() => {
                this.courseRegistry.delete(id);
                if (this.selectedCourse?.id === id) this.cancelselectedCourse();
            })
        } catch (error) {
            console.log(error);
        }
    }

    getCourseProfessor = async () => {
        try {
            const Course = await agent.Courses.getCourses();
            Course.forEach(course => {
                this.courseRegistry.set(course.professor_id, course);
            })
        }catch(error){
            console.log(error);
        }
    }


    addBookToCourse = async (book: IBook, id: string) => {
        try {
            await agent.Courses.addBookToCourse(book, id);
            runInAction(() => {
                this.bookRegistry.set(book.id, book);
                this.selectedBook = book;
                this.editMode = false;
            })
        } catch (error) {
            console.log(error);
        }
    }

    addProfessorToCourse = async (professor: IProfessor, id: string) => {
        try {
            await agent.Courses.addProfessorToCourse(professor, id);
            runInAction(() => {
                this.professorRegistry.set(professor.id, professor);
                this.selectedProfessor = professor;
                this.editMode = false;
            })
        } catch (error) {
            console.log(error);
        }
    }
}