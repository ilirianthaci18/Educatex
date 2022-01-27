package com.educatex.lms.service;

import com.educatex.lms.common.dto.ForumDTO;
import com.educatex.lms.common.dto.PostDTO;
import com.educatex.lms.common.dto.ReplyDTO;
import com.educatex.lms.model.*;
import com.educatex.lms.repository.ForumRepository;
import com.educatex.lms.repository.PollRepository;
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
    private PollRepository pollRepository;
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
        return forumRepository.findById(id).get();
    }

    @Override
    public Forum saveForum(Forum forum) {
        return forumRepository.save(forum);
    }

    @Override
    public Forum updateForum(Long id, Forum forum) {
        Forum forum1=getForumById(id);

        //implement objectmapper

        return  forum1;
    }

    @Override
    public void deleteForum(Long id) {
        forumRepository.deleteById(id);
    }

    @Override
    public ArrayList<Poll> getPollsByCourseName(String name) {
        return null;
    }

    @Override
    public ArrayList<Post> getPostByCourse(Course course) {
        return null;
    }

    @Override
    public Poll addPoll(Long id,Poll poll) {

        return pollRepository.save(poll);
    }//TODO

    @Override
    public void deletePoll(Long id) {
        pollRepository.deleteById(id);
    }

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }//TODO

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
    @Override
    public Reply addReply(Reply reply) {
        return replyRepository.save(reply);
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
    public void deleteAllPolls() {
        pollRepository.deleteAll();
    }

    @Override
    public void deleteAllReply() {
        replyRepository.deleteAll();
    }

    @Override
    public void addPostToForum(Long forumId,Long postId){
        Forum forum=forumRepository.findById(forumId).get();
        Post post=postRepository.findById(postId).get();

        forum.addPost(post);

        saveForum(forum);
    }

    @Override
    public void addUserToForum(Long forumId, Long studentId) {
        Forum forum=forumRepository.findById(forumId).get();
        Student student=studentService.getStudentdById(studentId);

        forum.addUsers(student);

        saveForum(forum);
    }

    @Override
    public void addAdminToForum(Long forumId, Long professorId) {
        Forum forum=forumRepository.findById(forumId).get();
        Professor professor=professorService.getProfessorById(professorId);

        forum.addAdmins(professor);

        saveForum(forum);
    }

    @Override
    public void addPollToForum(Long forumId, Long pollId) {

    }

    @Override
    public void addReplyToPost(Long postId, Long replyId) {
        Post post=postRepository.findById(postId).get();
        Reply reply=replyRepository.findById(replyId).get();

        post.addReply(reply);

        postRepository.save(post);
    }

    @Override
    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
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

    private Exception validateObject(Object obj){
        return new Exception();
    }
}
