import { makeAutoObservable, runInAction } from "mobx";
import agent from "../api/agent";
import { IELibrary } from "../models/eLibrary";
import { IAssignment } from "../models/assignment";
import { IBook } from "../models/book";
import { IRating } from "../models/rating";
import { ITraining } from "../models/training";
import { ICourse } from "../models/course";

export default class ELibraryStore{
    elibraryRegistry = new Map<string, IELibrary>();
    selectedELibrary : IELibrary | undefined = undefined;

    assignmentRegistry = new Map<string, IAssignment>();
    selectedAssignment : IAssignment | undefined = undefined;

    bookRegistry = new Map<string, IBook>();
    selectedBook : IBook | undefined = undefined;

    ratingRegistry = new Map<string, IRating>();
    selectedRating : IRating | undefined =undefined;

    trainingRegistry = new Map<string, ITraining>();
    selectedTraining : ITraining | undefined = undefined;

    //assignmentToELibraryRegistry = new Map <IAssignment, string>();
    //selectedAssignmentToELibrary : 

    editMode = false;

    constructor(){
        makeAutoObservable(this)
    }

    getELibraryByName() {
        return Array.from(this.elibraryRegistry.values());
    } 

    selectelibrary = (id:string)=>{
        this.selectedELibrary = this.elibraryRegistry.get(id);
    }

    cancelselectedELibrary = () =>{
        this.selectedELibrary=undefined;
    }

    updateELibrary = async (eLibrary: IELibrary) =>{
        try{
            await agent.ELibrary.updateELibrary(eLibrary);
            runInAction( () => {
                this.elibraryRegistry.set(eLibrary.id, eLibrary);
                this.selectedELibrary = eLibrary;
                this.editMode=false;
            })

        }catch(error){
            console.log(error);
        }
    }

    insertELibrary = async (eLibrary: IELibrary) =>{
        try{
            await agent.ELibrary.insertELibrary(eLibrary);
            runInAction( () => {
                this.elibraryRegistry.set(eLibrary.id, eLibrary);
                this.selectedELibrary=eLibrary;
                this.editMode=false;
            })
        }catch (error) {
            console.log(error);
        }
    }

    getELibrary() {
        return Array.from(this.elibraryRegistry.values());
    }

    deleteELibrary = async (id: string) => {
        try{
            await agent.ELibrary.deleteELibrary(id);
            runInAction(() => {
                this.elibraryRegistry.delete(id);
                if (this.selectedELibrary?.id === id) this.cancelselectedELibrary();
            })
        } catch (error) {
            console.log(error);
        }
    }

    getAssignments () {
        return Array.from(this.assignmentRegistry.values());
    } 

    addAssignment = async (assignment: IAssignment) => {
        try{
            await agent.ELibrary.addAssignment(assignment);
            runInAction(() => {
                this.assignmentRegistry.set(assignment.id , assignment);
                this.selectedAssignment = assignment;
                this.editMode = false;
            })
        }catch (error) {
            console.log(error);
        }
    }

    cancelselectedAssignment = () => {
        this.selectedAssignment= undefined;
    } 

    deleteAssignment = async (id: string) => {
        try{
            await agent.ELibrary.deleteAssignment(id);
            runInAction(() => {
                this.assignmentRegistry.delete(id);
                if (this.selectedAssignment?.id === id) this.cancelselectedAssignment();
            })
        } catch (error) {
            console.log(error);
        }
    }

    addBook = async (book: IBook) => {
        try{
            await agent.ELibrary.addBook(book);
            runInAction(() => {
                this.bookRegistry.set(book.id , book);
                this.selectedBook = book;
                this.editMode = false;
            })
        }catch (error) {
            console.log(error);
        }
        
    }

    getBooks () {
        return Array.from(this.bookRegistry.values());
    }

    addRating = async (rating: IRating) =>{
        try{
            await agent.ELibrary.addRating(rating);
            runInAction( () => {
                this.ratingRegistry.set(rating.id, rating);
                this.selectedRating= rating;
                this.editMode =false;
            })
        }catch (error) {
            console.log(error);
        }
    }

    cancelselectedRating = () => {
        this.selectedRating= undefined;
    } 

    deleteRating = async (id: string) => {
        try{
            await agent.ELibrary.deleteRating(id);
            runInAction(() => {
                this.ratingRegistry.delete(id);
                if (this.selectedRating?.id === id) this.cancelselectedRating();
            })
        }catch (error) {
            console.log(error);
        }
    }

    addTraining = async (training: ITraining) =>{
        try{
            await agent.ELibrary.addTraining(training);
            runInAction( () => {
                this.trainingRegistry.set(training.id, training);
                this.selectedTraining=training;
                this.editMode=false;
            })
        }catch (error) {
            console.log(error);
        }
    }

    getTrainings() {
        return Array.from(this.trainingRegistry.values());
    }


    cancelselectedTraining = () => {
        this.selectedTraining = undefined;
    }

    deleteTraining = async (id: string) => {
        try{
            await agent.ELibrary.deleteTraining(id);
            runInAction(() => {
                this.trainingRegistry.delete(id);
                if (this.selectedTraining?.id === id) this.cancelselectedTraining();
            })
        }catch (error) {
            console.log(error);
        }
    }

    showTrainingByCourse = async () => {
        try{
            const ELibrary = await agent.ELibrary.getTrainings();
            ELibrary.forEach(training  => {
                this.trainingRegistry.set(training.category, training);
            })
        }catch (error) {
            console.log(error);
        }
    }

    showBookByAuthor = async () => {
        try{
            const ELibrary = await agent.ELibrary.getBooks();
            ELibrary.forEach(book => {
                this.bookRegistry.set(book.author, book);
            })
        } catch (error) {
            console.log(error);
        }
    }

    showBookByCourse = async () => {
        try{
            const ELibrary = await agent.ELibrary.getBooks();
            ELibrary.forEach(book => {
                this.bookRegistry.set(book.course_id, book);
            })
        }catch (error) {
            console.log(error);
        }
    }

    /*showAssignmentByCourse = async () => {
        try{
            const ELibrary = await agent.ELibrary.getAssignments();
            ELibrary.forEach(assignment => {
                this.assignmentRegistry.set(assignment.course, assignment);
            })
        }catch (error) {
            console.log(error);
        }
    }*/

    addBookToELibrary = async (book: IBook) =>{
        try{
            await agent.ELibrary.addBookToELibrary(book, book.e_library_id);
            runInAction( () => {
                this.bookRegistry.set(book.e_library_id, book);
                this.selectedBook=book;
                this.editMode=false;
            })
        }catch (error) {
            console.log(error);
        }
    }

    addTrainingToELibrary = async (training: ITraining) => {
        try{
            await agent.ELibrary.addTrainingToELibrary(training, training.e_library_id);
            runInAction( () => {
                this.trainingRegistry.set(training.e_library_id, training);
                this.selectedTraining=training;
                this.editMode=false;
            })
        }catch (error) {
            console.log(error);
        }
    }

    addRatingToBook = async (rating: IRating) => {
        try{
            await agent.ELibrary.addRatingToBook(rating, rating.book_id);
            runInAction( () => {
                this.ratingRegistry.set(rating.book_id, rating);
                this.selectedRating=rating;
                this.editMode=false;
            })
        }catch (error) {
            console.log(error);
        }
    }


    

}