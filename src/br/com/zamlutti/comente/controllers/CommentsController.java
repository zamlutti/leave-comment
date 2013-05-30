package br.com.zamlutti.comente.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.zamlutti.comente.entities.Comment;
import br.com.zamlutti.comente.entities.Entry;
import br.com.zamlutti.comente.repositories.CommentRepository;
import br.com.zamlutti.comente.repositories.EntryRepository;

@Resource
public class CommentsController {
	private final Result result;
	private final EntryRepository entryRepository;
	private final CommentRepository commentRepository;
	private final Validator validator;

	public CommentsController(Result result, Validator validator,
			EntryRepository entryRepository, CommentRepository commentRepository) {
		this.result = result;
		this.validator = validator;

		this.entryRepository = entryRepository;
		this.commentRepository = commentRepository;
	}

	@Get("/{url}")
	public void add(String url) {
		Entry entry = this.entryRepository.find(url);
		this.result.include("entry", entry);
	}

	@Post
	public void save(Comment comment) {
		this.validator.validate(comment);
		this.validator.onErrorRedirectTo(CommentsController.class).add(
				comment.getEntry().getUrl());
		String url = comment.getEntry().getUrl();
		Entry entry = this.entryRepository.find(url);
		comment.setEntry(entry);
		this.commentRepository.save(comment);
		this.result.redirectTo(CommentsController.class).add(url);
	}
}
