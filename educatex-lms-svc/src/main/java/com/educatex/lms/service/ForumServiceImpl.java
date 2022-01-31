package com.educatex.lms.service;

import com.educatex.lms.common.dto.ForumDTO;
import com.educatex.lms.common.dto.PostDTO;
import com.educatex.lms.common.dto.ReplyDTO;
import com.educatex.lms.exception.NotFoundException;
import com.educatex.lms.model.*;
import com.educatex.lms.repository.ForumRepository;
import com.educatex.lms.repository.PostRepository;
import com.educatex.lms.repository.ReplyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.From;
import java.util.ArrayList;
import java.util.List;

import static com.educatex.lms.common.mappers.ForumMapper.toForumDTO;
import static com.educatex.lms.common.mappers.PostMapper.toPostDTO;
import static com.educatex.lms.common.mappers.PostMapper.toReplyDTO;


@AllArgsConstructor
@Slf4j
@Service
public class ForumServiceImpl implements ForumService {

    private ForumRepository forumRepository;
    private PostRepository postRepository;
    private ReplyRepository replyRepository;
    private StudentService studentService;
    private ProfessorService professorService;

    @Override
    public List<ForumDTO> getAllForums() {
        List<Forum> forums=forumRepository.findAll();
        List<ForumDTO> forumDTOS=new ArrayList<>();

        forums.stream().forEach(forum -> {
            forumDTOS.add(toForumDTO(forum));
        });

        return forumDTOS;
    }

    @Override
    public Forum getForumById(Long id) {
        return forumRepository.findById(id).orElseThrow(() -> {
            log.error("Forum could not be found , id : ", id);
            return new NotFoundException("Forum with id " + id + "not found");
        });

    }

    @Override
    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> {
            log.error("Post could not be found , id : ", postId);
            return new NotFoundException("Post with id " + postId + "not found");
        });
    }

    @Override
    public Reply getReplyById(Long replyId) {
        return replyRepository.findById(replyId).orElseThrow(() -> {
            log.error("Reply could not be found , id : ", replyId);
            return new NotFoundException("Reply with id " + replyId + "not found");
        });
    }

    @Override
    public Integer countPost() {
        return forumRepository.countPost();
    }

    @Override
    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
    }

    @Override
    public ArrayList<Post> getPostByCourse(Course course) {
        return null;
    }

    @Override
    public Forum saveForum(Forum forum) {
        return forumRepository.save(forum);
    }

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }//TODO

    @Override
    public Reply addReply(Reply reply) {
        return replyRepository.save(reply);
    }

    @Override
    public void deleteForum(Long id) {
        forumRepository.deleteById(id);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void deleteReply(Long id) {
        replyRepository.deleteById(id);
    }

    @Override
    public void deleteAllForums() {
        forumRepository.deleteAll();
    }

    @Override
    public void deleteAllPosts() {
        postRepository.deleteAll();
    }

    @Override
    public void deleteAllReply() {
        replyRepository.deleteAll();
    }

    @Override
    public void addUserToForum(Long forumId, Long studentId) {
        Forum forum=getForumById(forumId);
        Student student=studentService.getStudentdById(studentId);

        forum.addUsers(student);

        saveForum(forum);
    }

    @Override
    public void addAdminToForum(Long forumId, Long professorId) {
        Forum forum=getForumById(forumId);
        Professor professor=professorService.getProfessorById(professorId);

        forum.addAdmins(professor);

        saveForum(forum);
    }

    @Override
    public void addReplyToPost(Long postId, Long replyId) {
        Post post=getPostById(postId);
        Reply reply=getReplyById(replyId);

        post.addReply(reply);

        postRepository.save(post);
    }

    @Override
    public void addPostToForum(Long forumId,Long postId){
        Forum forum=getForumById(forumId);
        Post post=getPostById(postId);


        forum.addPost(post);

        saveForum(forum);
    }

    @Override
    public List<PostDTO> getAllPost() {
        List<Post> posts=postRepository.findAll();
        List<PostDTO> postDTOS=new ArrayList<>();

        posts.stream().forEach(post -> {
            postDTOS.add(toPostDTO(post));
        });

        return postDTOS;
    }

    @Override
    public List<ReplyDTO> getAllRepliesDTO() {
        List<Reply> replies=getAllReplies();

        List<ReplyDTO> replyDTOS=new ArrayList<>();

        replies.stream().forEach(reply -> {
            replyDTOS.add(toReplyDTO(reply));
        });

        return replyDTOS;
    }
}
