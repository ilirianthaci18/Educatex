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

    Post getPostById(Long postId);

    Reply getReplyById(Long replyId);

    ArrayList<Post> getPostByCourse(Course course);

    List<Reply> getAllReplies();

    List<PostDTO> getAllPost();

    List<ReplyDTO> getAllRepliesDTO();

    Forum saveForum(Forum forum);

    void addPostToForum(Long forumId,Long postId);

    void addUserToForum(Long forumId,Long studentId);

    void addAdminToForum(Long forumId,Long professorId);

    void addReplyToPost(Long postId,Long replyId);

    Post addPost(Post post);

    Reply addReply(Reply reply);

    void deleteForum(Long id);

    void deletePost(Long id);

    void deleteReply(Long id);

    void deleteAllForums();

    void deleteAllPosts();

    void deleteAllReply();
}
