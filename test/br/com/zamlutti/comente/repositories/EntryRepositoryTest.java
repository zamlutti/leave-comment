package br.com.zamlutti.comente.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.zamlutti.comente.entities.Entry;
import br.com.zamlutti.comente.infra.DataSessionImp;

public class EntryRepositoryTest {
	private EntryRepository repository;
	private DataSessionImp accessMock;
	private Entry entry;
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
		this.repository = new EntryRepositoryImp(this.accessMock);
		this.entry = new Entry();
	}

	@Test
	public void shouldGetDataAccessInstanceWhenSavingEntry() {
		this.repository.save(this.entry);
		Mockito.verify(this.accessMock, Mockito.times(1)).getInstance();
	}

	@Test
	public void shouldBeginTransactionWhenSavingEntry() {
		this.repository.save(this.entry);
		Mockito.verify(this.sessionMock, Mockito.times(1)).beginTransaction();
	}

	@Test
	public void shouldSaveOrUpdateWhenSavingEntry() {
		this.repository.save(this.entry);
		Mockito.verify(this.sessionMock, Mockito.times(1)).saveOrUpdate(
				this.entry);
	}

	@Test
	public void shouldCommitTransactionWhenSavingEntry() {
		this.repository.save(this.entry);
		Mockito.verify(this.transactionMock, Mockito.times(1)).commit();
	}
}
