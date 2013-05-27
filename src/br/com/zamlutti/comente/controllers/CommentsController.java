package br.com.zamlutti.comente.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zamlutti.comente.entities.Comment;
import br.com.zamlutti.comente.entities.Entry;
import br.com.zamlutti.comente.repositories.CommentRepository;
import br.com.zamlutti.comente.repositories.EntryRepository;

@Resource
public class CommentsController {
	private Result result;
	private EntryRepository entryRepository;
	private CommentRepository commentRepository;

	public CommentsController(Result result, EntryRepository entryRepository,
			CommentRepository commentRepository) {
		this.result = result;
		this.entryRepository = entryRepository;
		this.commentRepository = commentRepository;
	}

	@Get("/{url}")
	public void add(String url) {
		Entry entry = entryRepository.find(url);
		this.result.include("entry", entry);
	}

	@Post
	public void save(Comment comment, String url) {
		commentRepository.save(comment);
		this.result.redirectTo(CommentsController.class).add(url);
	}
}
