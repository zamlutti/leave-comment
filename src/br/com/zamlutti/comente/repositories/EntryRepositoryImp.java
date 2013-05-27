package br.com.zamlutti.comente.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zamlutti.comente.entities.Entry;
import br.com.zamlutti.comente.infra.DatabaseAccess;

@Component
public class EntryRepositoryImp implements EntryRepository {

    private DatabaseAccess access;

    public EntryRepositoryImp(DatabaseAccess access) {
        this.access = access;
    }

    @SuppressWarnings("unchecked")
	public Entry find(String url) {
        Session session = this.access.getInstance();
        List<Entry> results = session.createCriteria(Entry.class)
        		.add(Restrictions.eq("url", url)).list();
        return results.isEmpty() ? null: results.get(0);
    }

    public void save(Entry entry) {
        Session session = this.access.getInstance();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entry);
        transaction.commit();
        session.close();
    }

}
