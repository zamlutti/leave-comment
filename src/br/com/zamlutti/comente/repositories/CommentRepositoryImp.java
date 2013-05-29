package br.com.zamlutti.comente.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zamlutti.comente.entities.Comment;
import br.com.zamlutti.comente.infra.DataSessionImp;

@Component
public class CommentRepositoryImp implements CommentRepository {

	private final DataSessionImp access;

	public CommentRepositoryImp(DataSessionImp access) {
		this.access = access;
	}

	public void save(Comment comment) {
		Session session = this.access.getInstance();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(comment);
		transaction.commit();
	}

}
