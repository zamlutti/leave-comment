package br.com.zamlutti.comente.repositories;

import br.com.zamlutti.comente.entities.Comment;

public interface CommentRepository {
    public void save(Comment comment);
}
