package br.com.zamlutti.comente.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.zamlutti.comente.entities.Entry;
import br.com.zamlutti.comente.repositories.EntryRepository;
import br.com.zamlutti.comente.utils.Urlizer;

public class IndexControllerTest {

	private IndexController controller;
	private Result resultMock;
	private Urlizer urlizerMock;
	private CommentsController commentsControllerMock;
	private EntryRepository entryRepositoryMock;
	private Validator validatorMock;
	private IndexController indexControllerMock;

	@Before
	public void setUp() throws Exception {
		// Mock comments controller
		this.commentsControllerMock = Mockito.mock(CommentsController.class);

		// Mock index controller
		this.indexControllerMock = Mockito.mock(IndexController.class);

		// Mock validator
		this.validatorMock = Mockito.mock(Validator.class);
		Mockito.when(
				this.validatorMock.onErrorRedirectTo(IndexController.class))
				.thenReturn(this.indexControllerMock);
		// Mock result
		this.resultMock = Mockito.mock(Result.class);
		Mockito.when(this.resultMock.redirectTo(CommentsController.class))
				.thenReturn(this.commentsControllerMock);

		// Mock urlizer
		this.urlizerMock = Mockito.mock(Urlizer.class);
		Mockito.when(
				this.urlizerMock.urlize(Mockito.anyString(), Mockito.anyChar()))
				.thenReturn("urlized-string");

		// Mock entry repository
		this.entryRepositoryMock = Mockito.mock(EntryRepository.class);

		this.controller = new IndexController(this.resultMock,
				this.validatorMock, this.urlizerMock, this.entryRepositoryMock);
	}

	@Test
	public void shouldCallValidatorWhenAddingEntry() {
		Entry entry = new Entry();
		entry.setTitle("Métodos Ágeis");
		this.controller.add(entry);
		Mockito.verify(this.validatorMock, Mockito.times(1)).validate(entry);
	}

	@Test
	public void shouldCallUrlizerWhenAddingEntry() {
		Entry entry = new Entry();
		entry.setTitle("Métodos Ágeis");
		this.controller.add(entry);
		Mockito.verify(this.urlizerMock, Mockito.times(1)).urlize(
				"Métodos Ágeis", '-');
	}

	@Test
	public void shouldSaveEntryOnRepositoryWhenAddingEntry() {
		Entry entry = new Entry();
		entry.setTitle("Métodos Ágeis");
		this.controller.add(entry);
		Mockito.verify(this.entryRepositoryMock, Mockito.times(1)).save(entry);
	}

	@Test
	public void shouldRedirectToCommentsControllerWhenAddingEntry() {
		Entry entry = new Entry();
		entry.setTitle("Métodos Ágeis");
		this.controller.add(entry);
		Mockito.verify(this.resultMock, Mockito.times(1)).redirectTo(
				CommentsController.class);
	}

	@Test
	public void shouldRedirectToCommentsControllerAddActionWhenAddingEntry() {
		Entry entry = new Entry();
		entry.setTitle("Métodos Ágeis");
		this.controller.add(entry);
		Mockito.verify(this.commentsControllerMock, Mockito.times(1)).add(
				"urlized-string");
	}

}
