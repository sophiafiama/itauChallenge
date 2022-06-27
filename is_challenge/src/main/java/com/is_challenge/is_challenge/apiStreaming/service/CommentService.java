package com.is_challenge.is_challenge.apiStreaming.service;

import com.is_challenge.is_challenge.apiStreaming.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommentService {
    Comment create(Comment comment);
    void delete(Long id);
    Comment get(Long id);
    List<Comment> getAll();
}
