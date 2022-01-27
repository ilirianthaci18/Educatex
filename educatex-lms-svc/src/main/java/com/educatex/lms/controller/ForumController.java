package com.educatex.lms.controller;

import com.educatex.lms.common.dto.ForumDTO;
import com.educatex.lms.common.dto.PostDTO;
import com.educatex.lms.common.dto.ReplyDTO;
import com.educatex.lms.model.*;
import com.educatex.lms.service.ForumService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/forum")
@RestController
public class ForumController {

    private ForumService forumService;

    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping()
    public List<ForumDTO> getAllForums(){
        return forumService.getAllForums();
    }

    @GetMapping("/{id}")
    public Forum getForumById(@PathVariable Long id){
        return forumService.getForumById(id);
    }

    @PostMapping()
    public Forum saveForum(@RequestBody Forum forum){
        return forumService.saveForum(forum);
    }

    @PutMapping("/{id}")
    public Forum updateForum(@PathVariable Long id,@RequestBody Forum forum){
        return forumService.updateForum(id,forum);
    }

    @DeleteMapping("/{id}")
    public void deleteForum(@PathVariable Long id){
        forumService.deleteForum(id);
    }

    @PostMapping("/poll/forum/{id}")
    public Poll addPoll(@PathVariable Long id,@RequestBody Poll poll){
        return forumService.addPoll(id,poll);
    }

    @DeleteMapping("/poll/{id}")
    public void deletePoll(@PathVariable Long id){
        forumService.deletePoll(id);
    }

    @PostMapping("/post/forum/{id}")
    public Post addPost(@PathVariable Long id,@RequestBody Post post){
        return forumService.addPost(post);
    }

    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable Long id){
        forumService.deletePost(id);
    }

    @GetMapping("/polls/course/{name}")
    public ArrayList<Poll> getPollsByCourseName(@PathVariable String name){
        return forumService.getPollsByCourseName(name);
    }

    @GetMapping("/post/course/{name}")
    public ArrayList<Post> getPostByCourse(@RequestBody Course course){
        return forumService.getPostByCourse(course);
    }

    @PostMapping("/reply")
    public Reply addReply(@RequestBody Reply reply){
        return forumService.addReply(reply);
    }

    @DeleteMapping("/reply/{id}")
    public void deleteReply(@PathVariable Long id){
        forumService.deleteReply(id);
    }

    @PostMapping("/{forumId}/post/{postId}")
    public void addPostToForum(@PathVariable Long forumId,@PathVariable Long postId){
        forumService.addPostToForum(forumId,postId);
    }

    @PostMapping("/{forumId}/user/{studentId}")
    public void addUserToForum(@PathVariable Long forumId,@PathVariable Long studentId){
        forumService.addUserToForum(forumId,studentId);
    }

    @PostMapping("/{forumId}/admin/{professorId}")
    public void addAdminToForum(@PathVariable Long forumId,@PathVariable Long professorId){
        forumService.addAdminToForum(forumId,professorId);
    }

    @PostMapping("/post/{postId}/reply/{replyId}")
    public void addReplyToPost(@PathVariable Long postId,@PathVariable Long replyId){
        forumService.addReplyToPost(postId,replyId);
    }

    //CALL THIS API TO SEE EXAMPLE OF RECURSION
    @GetMapping("/repliesRecursion")
    public List<Reply> getRepliesRecursion(){
        return forumService.getAllReplies();
    }

    @GetMapping("/posts")
    public List<PostDTO> getAllPosts(){
        return forumService.getAllPost();
    }

    @GetMapping("/replies")
    public List<ReplyDTO> getAllReplies(){
        return forumService.getAllRepliesDTO();
    }
}
