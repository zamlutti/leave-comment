package br.com.zamlutti.comente.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.vraptor.Result;
import br.com.zamlutti.comente.entities.Entry;
import br.com.zamlutti.comente.repositories.CommentRepository;
import br.com.zamlutti.comente.repositories.EntryRepository;

public class CommentsControllerTest {
	private CommentsController controller;
	private Result resultMock;
	private EntryRepository entryRepositoryMock;
	private CommentRepository commentRepositoryMock;
	private Entry entry;

	@Before
	public void setUp() throws Exception {
		resultMock = Mockito.mock(Result.class);
		// Mock entry repository
		entryRepositoryMock = Mockito.mock(EntryRepository.class);
		this.entry = new Entry();
		Mockito.when(entryRepositoryMock.find(Mockito.anyString())).thenReturn(
				entry);
		
		// Mock comment repository
		commentRepositoryMock = Mockito.mock(CommentRepository.class);
		controller = new CommentsController(resultMock, entryRepositoryMock,
				commentRepositoryMock);
	}

	@Test
	public void shouldRetrieveEntryWhenAddingComment() {
		String url = "entry-url";
		controller.add(url);
		Mockito.verify(this.entryRepositoryMock, Mockito.times(1)).find(url);
	}

	@Test
	public void shouldSetEntryOnViewWhenAddingComment() {
		String url = "entry-url";
		controller.add(url);
		Mockito.verify(this.resultMock, Mockito.times(1)).include("entry", this.entry);
	}
}
