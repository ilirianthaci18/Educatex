package com.educatex.lms.controller;

import com.educatex.lms.common.dto.ForumDTO;
import com.educatex.lms.common.dto.PostDTO;
import com.educatex.lms.common.dto.ReplyDTO;
import com.educatex.lms.model.*;
import com.educatex.lms.service.ForumService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(originPatterns = "*")
@RequestMapping("/api/forum")
@RestController
public class ForumController {

    private ForumService forumService;

    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    @GetMapping()
    public List<ForumDTO> getAllForums(){
        return forumService.getAllForums();
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    @GetMapping("/{id}")
    public Forum getForumById(@PathVariable Long id){
        return forumService.getForumById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_PROFESSOR','ROLE_ADMIN')")
    @PostMapping()
    public Forum saveForum(@RequestBody @Valid Forum forum){
        return forumService.saveForum(forum);
    }

    @PreAuthorize("hasAnyRole('ROLE_PROFESSOR','ROLE_ADMIN')")
    @PutMapping("/{id}")
    public Forum updateForum(@RequestBody @Valid Forum forum){
        return forumService.saveForum(forum);
    }

    @PreAuthorize("hasAnyRole('ROLE_PROFESSOR','ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteForum(@PathVariable Long id){
        forumService.deleteForum(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    @PostMapping("/post/forum")
    public Post addPost(@RequestBody @Valid Post post){
        return forumService.addPost(post);
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable Long id){
        forumService.deletePost(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    @PostMapping("/reply")
    public Reply addReply(@RequestBody @Valid Reply reply){
        return forumService.addReply(reply);
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    @DeleteMapping("/reply/{id}")
    public void deleteReply(@PathVariable Long id){
        forumService.deleteReply(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    @PostMapping("/{forumId}/post/{postId}")
    public void addPostToForum(@PathVariable Long forumId,@PathVariable Long postId){
        forumService.addPostToForum(forumId,postId);
    }

    @PreAuthorize("hasAnyRole('ROLE_PROFESSOR','ROLE_ADMIN')")
    @PostMapping("/{forumId}/user/{studentId}")
    public void addUserToForum(@PathVariable Long forumId,@PathVariable Long studentId){
        forumService.addUserToForum(forumId,studentId);
    }

    @PreAuthorize("hasAnyRole('ROLE_PROFESSOR','ROLE_ADMIN')")
    @PostMapping("/{forumId}/admin/{professorId}")
    public void addAdminToForum(@PathVariable Long forumId,@PathVariable Long professorId){
        forumService.addAdminToForum(forumId,professorId);
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    @PostMapping("/post/{postId}/reply/{replyId}")
    public void addReplyToPost(@PathVariable Long postId,@PathVariable Long replyId){
        forumService.addReplyToPost(postId,replyId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    //CALL THIS API TO SEE EXAMPLE OF RECURSION
    @GetMapping("/repliesRecursion")
    public List<Reply> getRepliesRecursion(){
        return forumService.getAllReplies();
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    @GetMapping("/posts")
    public List<PostDTO> getAllPosts(){
        return forumService.getAllPost();
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    @GetMapping("/replies")
    public List<ReplyDTO> getAllReplies(){
        return forumService.getAllRepliesDTO();
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_PROFESSOR','ROLE_ADMIN')")
    @GetMapping("/countPosts")
    public Integer countPosts(){
        return forumService.countPost();
    }
}
