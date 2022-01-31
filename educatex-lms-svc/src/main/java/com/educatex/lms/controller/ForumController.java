package com.educatex.lms.controller;

import com.educatex.lms.common.dto.ForumDTO;
import com.educatex.lms.common.dto.PostDTO;
import com.educatex.lms.common.dto.ReplyDTO;
import com.educatex.lms.model.*;
import com.educatex.lms.service.ForumService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Forum saveForum(@RequestBody @Valid Forum forum){
        return forumService.saveForum(forum);
    }

    @PutMapping("/{id}")
    public Forum updateForum(@RequestBody @Valid Forum forum){
        return forumService.saveForum(forum);
    }

    @DeleteMapping("/{id}")
    public void deleteForum(@PathVariable Long id){
        forumService.deleteForum(id);
    }

    @PostMapping("/post/forum")
    public Post addPost(@RequestBody @Valid Post post){
        return forumService.addPost(post);
    }

    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable Long id){
        forumService.deletePost(id);
    }

    @GetMapping("/post/course/{name}")
    public ArrayList<Post> getPostByCourse(@RequestBody @Valid Course course){
        return forumService.getPostByCourse(course);
    }

    @PostMapping("/reply")
    public Reply addReply(@RequestBody @Valid Reply reply){
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


    @GetMapping("/countPosts")
    public Integer countPosts(){
        return forumService.countPost();
    }
}
