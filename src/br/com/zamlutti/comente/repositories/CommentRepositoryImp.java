package br.com.zamlutti.comente.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zamlutti.comente.entities.Comment;
import br.com.zamlutti.comente.infra.DatabaseAccess;

@Component
public class CommentRepositoryImp implements CommentRepository {

	private DatabaseAccess access;
	
	public CommentRepositoryImp(DatabaseAccess access) {
		this.access = access;
	}

	public void save(Comment comment) {
        Session session = this.access.getInstance();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(comment);
        transaction.commit();
        session.close();
	}

}
