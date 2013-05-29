package br.com.zamlutti.comente.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.zamlutti.comente.entities.Comment;
import br.com.zamlutti.comente.infra.DataSessionImp;

public class CommentRepositoryTest {
	private CommentRepository repository;
	private DataSessionImp accessMock;
	private Comment comment;
	private Session sessionMock;
	private Transaction transactionMock;

	@Before
	public void setUp() throws Exception {
		// Mock Hibernate Transaction
		this.transactionMock = Mockito.mock(Transaction.class);

		// Mock Hibernate Session
		this.sessionMock = Mockito.mock(Session.class);
		Mockito.when(this.sessionMock.beginTransaction()).thenReturn(
				this.transactionMock);

		// Mock Data session access
		this.accessMock = Mockito.mock(DataSessionImp.class);
		Mockito.when(this.accessMock.getInstance())
				.thenReturn(this.sessionMock);
		this.repository = new CommentRepositoryImp(this.accessMock);
		this.comment = new Comment();
	}

	@Test
	public void shouldGetDataAccessInstanceWhenSavingComment() {
		this.repository.save(this.comment);
		Mockito.verify(this.accessMock, Mockito.times(1)).getInstance();
	}

	@Test
	public void shouldBeginTransactionWhenSavingComment() {
		this.repository.save(this.comment);
		Mockito.verify(this.sessionMock, Mockito.times(1)).beginTransaction();
	}

	@Test
	public void shouldSaveOrUpdateWhenSavingComment() {
		this.repository.save(this.comment);
		Mockito.verify(this.sessionMock, Mockito.times(1)).saveOrUpdate(
				this.comment);
	}

	@Test
	public void shouldCommitTransactionWhenSavingComment() {
		this.repository.save(this.comment);
		Mockito.verify(this.transactionMock, Mockito.times(1)).commit();
	}
}
