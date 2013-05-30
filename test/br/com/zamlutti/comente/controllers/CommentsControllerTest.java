package br.com.zamlutti.comente.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.zamlutti.comente.entities.Comment;
import br.com.zamlutti.comente.entities.Entry;
import br.com.zamlutti.comente.repositories.CommentRepository;
import br.com.zamlutti.comente.repositories.EntryRepository;

public class CommentsControllerTest {
	private static final String ENTRY_URL = "entry-url";
	private CommentsController controller;
	private Result resultMock;
	private EntryRepository entryRepositoryMock;
	private CommentRepository commentRepositoryMock;
	private Entry entry;
	private CommentsController commentsControllerMock;
	private Comment comment;
	private Validator validatorMock;

	@Before
	public void setUp() throws Exception {
		// Mock comments controller
		this.commentsControllerMock = Mockito.mock(CommentsController.class);

		// Mock validator
		this.validatorMock = Mockito.mock(Validator.class);

		// Mock result
		this.resultMock = Mockito.mock(Result.class);
		Mockito.when(this.resultMock.redirectTo(CommentsController.class))
				.thenReturn(this.commentsControllerMock);

		// Mock entry repository
		this.entry = new Entry();
		this.entry.setUrl(ENTRY_URL);
		this.entryRepositoryMock = Mockito.mock(EntryRepository.class);
		Mockito.when(this.entryRepositoryMock.find(Mockito.anyString()))
				.thenReturn(this.entry);

		// Mock comment repository
		this.commentRepositoryMock = Mockito.mock(CommentRepository.class);

		this.controller = new CommentsController(this.resultMock,
				this.validatorMock, this.entryRepositoryMock,
				this.commentRepositoryMock);

		this.comment = new Comment();
		this.comment.setEntry(this.entry);
	}

	@Test
	public void shouldValidateCommentWhenAddingComment() {
		this.controller.add(ENTRY_URL);
		Mockito.verify(this.validatorMock, Mockito.times(1)).validate(
				this.comment);
	}

	@Test
	public void shouldRetrieveEntryWhenAddingComment() {
		this.controller.add(ENTRY_URL);
		Mockito.verify(this.entryRepositoryMock, Mockito.times(1)).find(
				ENTRY_URL);
	}

	@Test
	public void shouldSetEntryOnViewWhenAddingComment() {
		this.controller.add(ENTRY_URL);
		Mockito.verify(this.resultMock, Mockito.times(1)).include("entry",
				this.entry);
	}

	@Test
	public void shouldRetrieveEntryWhenSavingComment() {
		this.controller.save(this.comment);
		Mockito.verify(this.entryRepositoryMock, Mockito.times(1)).find(
				ENTRY_URL);
	}

	@Test
	public void shouldSaveCommentOnRepositoryWhenSavingComment() {
		this.controller.save(this.comment);
		Mockito.verify(this.commentRepositoryMock, Mockito.times(1)).save(
				this.comment);
	}

	@Test
	public void shouldRedirectToAddActionAfterSavingComment() {
		this.controller.save(this.comment);
		Mockito.verify(this.resultMock, Mockito.times(1)).redirectTo(
				CommentsController.class);
	}
}
