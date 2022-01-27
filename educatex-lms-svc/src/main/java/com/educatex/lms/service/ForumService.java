package com.educatex.lms.service;

import com.educatex.lms.common.dto.ForumDTO;
import com.educatex.lms.common.dto.PostDTO;
import com.educatex.lms.common.dto.ReplyDTO;
import com.educatex.lms.model.*;

import java.util.ArrayList;
import java.util.List;

public interface ForumService {

    List<ForumDTO> getAllForums();

    Forum getForumById(Long id);

    Forum saveForum(Forum forum);

    Forum updateForum(Long id, Forum forum);

    void deleteForum(Long id);

    Poll addPoll(Long id, Poll poll);

    void deletePoll(Long id);

    Post addPost(Post post);

    void deletePost(Long id);

    Reply addReply(Reply reply);

    void deleteReply(Long id);

    void deleteAllForums();

    void deleteAllPosts();

    void deleteAllPolls();

    void deleteAllReply();

    ArrayList<Poll> getPollsByCourseName(String name);

    ArrayList<Post> getPostByCourse(Course course);

    void addPostToForum(Long forumId,Long postId);

    void addUserToForum(Long forumId,Long studentId);

    void addAdminToForum(Long forumId,Long professorId);

    void addPollToForum(Long forumId,Long pollId);

    void addReplyToPost(Long postId,Long replyId);

    List<Reply> getAllReplies();

    List<PostDTO> getAllPost();

    List<ReplyDTO> getAllRepliesDTO();
}
