package com.challenge.itau.movies.service;

import com.challenge.itau.movies.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommentService {
    Comment create(Comment comment);
    void delete(Long id);
    Comment get(Long id);
    List<Comment> getAll();

}
