import axios, { AxiosResponse } from "axios";
import { IAdmin } from "../models/admin";
import { IAssignment } from "../models/assignment";
import { IBook } from "../models/book";
import { ICourse } from "../models/course";
import { IELibrary } from "../models/eLibrary";
import { IForum } from "../models/forum";
import { IPost } from "../models/post";
import { IProfessor } from "../models/professor";
import { IRating } from "../models/rating";
import { IReply } from "../models/reply";
import { IStudent } from "../models/student";
import { ITraining } from "../models/training";

axios.defaults.baseURL = 'http://localhost:8080/api';

const responseBody = (response: AxiosResponse) => response.data;

const requests = {
    get: (url: string) => axios.get(url).then(responseBody),
    post: (url: string, body: {}) => axios.post(url, body).then(responseBody),
    put: (url: string, body: {}) => axios.put(url, body).then(responseBody),
    delete: (url: string) => axios.delete(url).then(responseBody)
}

const Courses = {
    getCourses: (): Promise<ICourse[]> => requests.get('/course'),
    getCourse: (id: string) => requests.get(`/course/${id}`),
    insertCourse: (course:ICourse) => requests.post('/course', course),
    updateCourse: (course: ICourse) => requests.put(`/course/${course.id}`, course),
    getCourseProfessor: (id: string) => requests.get(`/course/professor/${id}`),
    addBookToCourse: (book:IBook, id: string) => requests.post(`/course/${id}/book/${book.id}`, book),
    addProfessorToCourse: (professor: IProfessor, id: string) => requests.post(`/course/${id}/professor/${professor.id}`, professor),
    deleteCourse: (id: string) => requests.delete(`/course/${id}`)
    /*addStudentToCourse and removeStudentFromCourse ???*/
}

const ELibrary = {
    updateELibrary: (eLibrary: IELibrary) => requests.put(`/elibrary/${eLibrary.id}`, eLibrary), //done
    insertELibrary: (eLibrary: IELibrary) => requests.post('/elibrary', eLibrary), //done
    getELibrary: (id: string) => requests.get(`/elibrary/${id}`), //done
    deleteELibrary: (id: string) => requests.delete(`/elibrary/${id}`), //done
    addAssignment: (assignment: IAssignment) => requests.post('/elibrary/assignment', assignment), //done
    deleteAssignment: (id: string) => requests.delete(`/elibrary/assignment/${id}`),   //done
    addBook: (book: IBook) => requests.post('/elibrary/book', book), //done
    getBooks: () : Promise<IBook[]> => requests.get('/elibrary/books'), //done
    saveBook: (book: IBook) => requests.post('/elibrary/save/book', book),
    addRating: (rating: IRating) => requests.post('/elibrary/rating', rating), //done
    deleteRating: (rating_id: string) => requests.delete(`/elibrary/rating/${rating_id}`), //done
    getTrainings: () : Promise<ITraining[]> => requests.get('/elibrary/trainings'), //done
    addTraining: (training: ITraining) => requests.post('/elibrary/training', training), //done
    deleteTraining: (id: string) => requests.delete(`/elibrary/training/${id}`), //done
    showTrainingByCourse: (name: string) => requests.get(`/elibrary/training/course/${name}`), //done 
    showBookByAuthor: (name: string) : Promise<IBook[]> => requests.get(`/elibrary/book/author/${name}`), //done
    showBookByCourse: (name: string) : Promise<IBook[]> => requests.get(`/elibrary/book/course/${name}`), //done
    showAssignmentByCourse: (name: string) : Promise<IAssignment> => requests.get(`/elibrary/assignment/course/${name}`),

    addAssignmentToELibrary: (assignment: IAssignment, id: string) => requests.post(`/elibrary/${id}/assignment/${assignment.id}`, assignment), //done
    addBookToELibrary: (book: IBook, id: string) => requests.post(`/elibrary/${id}/book/${book.id}`, book), //done
    addStudentToELibrary: (student: IStudent, id: string) => requests.post(`/elibrary/${id}/student/${student.id}`, student), //done
    addTrainingToELibrary: (training: ITraining, id: string) => requests.post(`/elibrary/${id}/training/${training.id}`, training), //done
    addRatingToBook: (rating: IRating, book_id: string) => requests.post(`/elibrary/book/${book_id}/rating/${rating.id}`, rating), //done
    getMostRatedBook: () : Promise<IBook> => requests.get('/elibrary/mostRatedBook')
}

const Forum = {
    getForums: (): Promise<IForum[]> => requests.get('/forum'),
    insertForum: (forum: IForum) => requests.post('/forum', forum),
    getPostByCourse: (name: string) => requests.get(`/forum/post/course/${name}`),
    insertPost: (post: IPost) => requests.post('/forum/post/forum', post),
    deletePost: (id: string) => requests.delete(`/forum/post/${id}`),
    addReplyToPost: (reply: IReply, postId: string) => requests.post(`/forum/post/${postId}/reply/${reply.reply_id}`, reply),
    getPosts: (): Promise<IPost[]> => requests.get('/forum/posts'),
    getReplies: (): Promise<IReply[]> => requests.get('/forum/replies'),
    getRepliesRecursion: (): Promise<IReply[]> => requests.get('/forum/repliesRecursion'),
    addReply: (reply: IReply) => requests.post('/forum/reply', reply),
    deleteReply: (id: string) => requests.delete(`/forum/reply/${id}`),
    addAdminToForum: (admin: IAdmin, id: string) => requests.post(`/forum/${id}/admin/${admin.id}`, admin),
    addPostToForum: (post: IPost, id: string) => requests.post(`/forum/${id}/post/${post.post_id}`, post),
    addUserToForum: (student: IStudent, id: string) => requests.post(`/forum/${id}/user/${student.id}`, student),
    getForum: (id: string) => requests.get(`/forum/${id}`),
    updateForum: (forum: IForum) => requests.put(`/forum/${forum.id}`, forum),
    deleteForum: (id: string) => requests.delete(`/forum/${id}`)
}

const Student = {
    getStudents: (): Promise<IStudent[]> => requests.get('/student'),
    updateStudent: (student: IStudent) => requests.put(`/student`, student),
    saveStudent: (student: IStudent) => requests.post(`/student`, student),
    getStudentRecommendation: () => requests.get('/student/reccomendations'),
    getIRregullt: () => requests.get('/student/regular'),
    getSchedule: () => requests.get('/student/schedule'),
    getStudentInfo: (id: string) => requests.get(`/student/studentInfo/${id}`),
    viewAttendance: () => requests.get('/student/viewAttendence'),
    getStudentById: (id: string) => requests.get(`/student/${id}`),
    deleteStudent: (id: string) => requests.delete(`/student/${id}`),
    addCourseToStudent: (course: ICourse, id: string) => requests.post(`/student/${id}/course/${course.id}`, course),
    addPostToStudent: (post: IPost, id: string) => requests.post(`/student/${id}/post/${post.post_id}`, post)
}

const Admin = {
    getAdmins: (): Promise<IAdmin[]> => requests.get('/admin'),
    saveAdmin: (admin: IAdmin) => requests.post('/admin', admin),
    addCourse: (course:ICourse) => requests.post('/admin/add/course', course),
    saveProfessor: (professor: IProfessor) => requests.post('/admin/add/professor', professor),
    saveStudent: (student: IStudent) => requests.post('/admin/add/student', student),
    deleteAssignments: () => requests.delete('/admin/assignments'),
    deleteBooks: () => requests.delete('/admin/books'),
    deleteCourses: () => requests.delete('/admin/course'),
    deleteCourse: (id: string) => requests.delete(`/admin/delete/course/${id}`),
    deleteProfessor: (id: string) => requests.delete(`/admin/delete/professor/${id}`),
    deleteStudent: (id: string) => requests.delete(`/admin/delete/student/${id}`),
    editCourse: (course: ICourse) => requests.put('/admin/edit/course', course),
    editStudent: (student: IStudent) => requests.put('/admin/edit/student', student),
    editProfessor: (professor: IProfessor) => requests.put('/admin/edit/professor', professor),
    enrollStudentForCourse: (student: IStudent) => requests.post('/admin/enroll/student/course', student),
    deletePosts: () => requests.delete('/admin/post'),
    deleteProfessors: () => requests.delete('/admin/professor'),
    deleteRatings: () => requests.delete('/admin/ratings'),
    deleteReplies: () => requests.delete('/admin/replies'),
    deleteStudents: () => requests.delete('/admin/students'),
    deleteTrainings: () => requests.delete('/admin/trainings'),
    deleteAdmin: (id: string) => requests.delete(`/admin/${id}`),
    unenrollStudentFromCourse: (student: IStudent, id: string) => requests.put(`/admin/unenroll/student/course/${id}`, student)
}

const Professor = {
    getProfessors: () : Promise<IProfessor[]> => requests.get('/professor'),
    updateProfessor: (professor: IProfessor) => requests.put('/professor', professor),
    savePofessor: (professor: IProfessor) => requests.post('/professor', professor),
    deleteProfessors: () => requests.delete('/professor/all'),
    getProfessorInfo: (id: string) => requests.get(`/professor/professorInfo/${id}`),
    getIRregullt: () => requests.get('/professor/regular'),
    viewAttendance: (course: ICourse) => requests.post('/professor/viewAttendance', course),
    getProfessorById: (id: string) => requests.get(`/professor/${id}`),
    deleteProfessor: (id: string) => requests.delete(`/professor/${id}`),
    searchProfessor: (name: string) => requests.get(`/professor/${name}`)
}

const agent = {
    Courses,
    ELibrary,
    Forum,
    Student,
    Admin,
    Professor
}

export default agent;