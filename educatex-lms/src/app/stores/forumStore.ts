
import { ISetDidChange, makeAutoObservable, runInAction } from "mobx";
import agent from "../api/agent";
import { IForum } from "../models/forum";
import { IPost } from "../models/post";
import { ICourse } from "../models/course";
import { IReply } from "../models/reply";
import { IAdmin } from "../models/admin";
import { IStudent } from "../models/student";

export default class ForumStore {
    forumRegistry = new Map<string, IForum>();
    selectedForum: IForum | undefined = undefined;
    editMode = false;
    loading = false;
    postRegistry = new Map<string, IPost>();
    selectedPost: IPost | undefined = undefined;
    courseRegistry = new Map<string, ICourse>();
    selectedCourse: ICourse | undefined = undefined;
    replyRegistry = new Map<string, IReply>();
    selectedReply: IReply | undefined = undefined;
    adminRegistry = new Map<string, IAdmin>();
    selectedAdmin: IAdmin | undefined = undefined;
    studentRegistry = new Map<string, IStudent>();
    selectedStudent: IStudent | undefined = undefined;

    constructor() {
        makeAutoObservable(this)
    }

    getForumByName() {
        return Array.from(this.forumRegistry.values());
    }

    loadForums = async () => {
        try{
            const Forums = await agent.Forum.getForums();
            Forums.forEach(forum => {
                this.forumRegistry.set(forum.id, forum);
            })
        } catch (error) {
            console.log(error);
        }
    }

    selectforum = (id: string) => {
        this.selectedForum = this.forumRegistry.get(id);
    }

    cancelselectedForum = () => {
        this.selectedForum = undefined;
    }

    cancelselectedReply = () => {
        this.selectedReply = undefined;
    }

    cancelselectedPost= () => {
        this.selectedPost = undefined;
    }

    openForm = (id?: string) => {
        id ? this.selectforum(id) : this.cancelselectedForum();
        this.editMode = true;
    }

    closeForm = () => {
        this.editMode = false;
    }

    createforum = async (forum: IForum) => {
        try {
            await agent.Forum.insertForum(forum);
            runInAction(() => {
                this.forumRegistry.set(forum.id, forum);
                this.selectedForum = forum;
                this.editMode = false;
            })
        } catch (error) {
            console.log(error);
        }
    }

    updateforum = async (forum: IForum) => {
        try {
            await agent.Forum.updateForum(forum);
            runInAction(() => {
                this.forumRegistry.set(forum.id, forum);
                this.selectedForum = forum;
                this.editMode = false;
            })
        } catch (error) {
            console.log(error);
        }
    }

    deleteforum = async (id: string) => {
        try {
            await agent.Forum.deleteForum(id);
            runInAction(() => {
                this.forumRegistry.delete(id);
                if (this.selectedForum?.id === id) this.cancelselectedForum();
            })
        } catch (error) {
            console.log(error);
        }
    }

    getPostByCourse = async (name: string) => {
        try {
            const Post = await agent.Forum.getPosts();
            Post.forEach(post => {
                this.postRegistry.set(post.post_id, post);
            })
        } catch (error) {
            console.log(error);
        }
    }

    createpost = async (post: IPost) => {
        try {
            await agent.Forum.insertPost(post);
            runInAction(() => {
                this.postRegistry.set(post.post_id, post);
                this.selectedPost = post;
                this.editMode = false;
            })
        } catch (error) {
            console.log(error);
        }
    }

    deletepost = async (id: string) => {
        try {
            await agent.Forum.deletePost(id);
            runInAction(() => {
                this.postRegistry.delete(id);
                if (this.selectedPost?.post_id === id) this.cancelselectedPost();
            })
        } catch (error) {
            console.log(error);
        }
    }

    addReplyToPost = async (reply: IReply, postId: string) => {
        try {
            await agent.Forum.addReplyToPost(reply, postId);
            runInAction(() => {
                this.replyRegistry.set(reply.post_id, reply);
                this.selectedReply = reply;
                this.editMode = false;
            })
        } catch (error) {
            console.log(error);
        }
    }

    getPosts() {
        return Array.from(this.postRegistry.values());
    }

    getReplies() {
        return Array.from(this.replyRegistry.values());
    }

    createreply = async (reply: IReply) => {
        try {
            await agent.Forum.addReply(reply);
            runInAction(() => {
                this.replyRegistry.set(reply.reply_id, reply);
                this.selectedReply = reply;
                this.editMode = false;
            })
        } catch (error) {
            console.log(error);
        }
    }

    deletereply= async (id: string) => {
        try {
            await agent.Forum.deleteReply(id);
            runInAction(() => {
                this.replyRegistry.delete(id);
                if (this.selectedReply?.reply_id === id) this.cancelselectedReply();
            })
        } catch (error) {
            console.log(error);
        }
    }

    addAdminToForum = async (admin: IAdmin, id: string) => {
        try {
            await agent.Forum.addAdminToForum(admin, id);
            runInAction(() => {
                this.adminRegistry.set(admin.id, admin);
                this.selectedAdmin = admin;
                this.editMode = false;
            })
        } catch (error) {
            console.log(error);
        }
    }

    addPostToForum = async (post: IPost, id: string) => {
        try {
            await agent.Forum.addPostToForum(post, id);
            runInAction(() => {
                this.postRegistry.set(post.forum_id, post);
                this.selectedPost = post;
                this.editMode = false;
            })
        } catch (error) {
            console.log(error);
        }
    }

    addUserToForum = async (student: IStudent, id: string) => {
        try {
            await agent.Forum.addUserToForum(student, id);
            runInAction(() => {
                this.studentRegistry.set(student.forum_id, student);
                this.selectedStudent = student;
                this.editMode = false;
            })
        } catch (error) {
            console.log(error);
        }
    }
}