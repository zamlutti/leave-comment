package br.com.zamlutti.comente.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zamlutti.comente.entities.Entry;
import br.com.zamlutti.comente.infra.DataSessionImp;

@Component
public class EntryRepositoryImp implements EntryRepository {

	private final DataSessionImp access;

	public EntryRepositoryImp(DataSessionImp access) {
		this.access = access;
	}

	@SuppressWarnings("unchecked")
	public Entry find(String url) {
		Session session = this.access.getInstance();
		SimpleExpression byUrl = Restrictions.eq("url", url);
		Criteria criteria = session.createCriteria(Entry.class).add(byUrl);
		List<Entry> results = criteria.list();
		return results.isEmpty() ? null : results.get(0);
	}

	public void save(Entry entry) {
		Session session = this.access.getInstance();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(entry);
		transaction.commit();
	}

}
