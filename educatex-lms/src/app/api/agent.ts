import axios, { AxiosResponse } from "axios";
import { IAdmin } from "../models/admin";
import { IAssignment } from "../models/assignment";
import { IBook } from "../models/book";
import { ICourse } from "../models/course";
import { ELibrary } from "../models/eLibrary";
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
    updateELibrary: (eLibrary: ELibrary) => requests.put(`/elibrary/${eLibrary.id}`, eLibrary),
    insertELibrary: (eLibrary: ELibrary) => requests.post('/elibrary', eLibrary),
    addAssignment: (assignment: IAssignment) => requests.post('/elibrary/assignment', assignment),
    addBook: (book: IBook) => requests.post('/elibrary/book', book),
    addRating: (rating: IRating) => requests.post('/elibrary/rating', rating),
    saveBook: (book: IBook) => requests.post('/elibrary/save/book', book),
    addTraining: (training: ITraining) => requests.post('/elibrary/training', training),
    addAssignmentToELibrary: (assignment: IAssignment, id: string) => requests.post(`/elibrary/${id}/assignment/${assignment.id}`, assignment),
    addBookToELibrary: (book: IBook, id: string) => requests.post(`/elibrary/${id}/book/${book.id}`, book),
    addStudentToELibrary: (student: IStudent, id: string) => requests.post(`/elibrary/${id}/student/${student.id}`, student),
    addTrainingToELibrary: (training: ITraining, id: string) => requests.post(`/elibrary/${id}/training/${training.id}`, training),
    showAssignmentByCourse: (name: string) : Promise<IAssignment> => requests.get(`/elibrary/assignment/course/${name}`),
    deleteAssignment: (id: string) => requests.delete(`/elibrary/assignment/${id}`),
    showBookByAuthor: (name: string) : Promise<IBook[]> => requests.get(`/elibrary/book/author/${name}`),
    showBookByCourse: (name: string) : Promise<IBook[]> => requests.get(`/elibrary/book/course/${name}`),
    addRatingToBook: (rating: IRating, book_id: string) => requests.post(`/elibrary/book/${book_id}/rating/${rating.id}`, rating),
    getBooks: () : Promise<IBook[]> => requests.get('/elibrary/books'),
    getMostRatedBook: () : Promise<IBook> => requests.get('/elibrary/mostRatedBook'),
    deleteRating: (rating_id: string) => requests.delete(`/elibrary/rating/${rating_id}`),
    showTrainingByCourse: (name: string) => requests.get(`/elibrary/training/course/${name}`),
    deleteTraining: (id: string) => requests.delete(`/elibrary/training/${id}`),
    getTrainings: () : Promise<ITraining[]> => requests.get('/elibrary/trainings'),
    getELibrary: (id: string) => requests.get(`/elibrary/${id}`),
    deleteELibrary: (id: string) => requests.delete(`/elibrary/${id}`)
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

const agent = {
    Courses,
    ELibrary,
    Forum
}

export default agent;