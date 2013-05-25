package br.com.zamlutti.comente.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zamlutti.comente.entities.Entry;
import br.com.zamlutti.comente.infra.DatabaseAccess;

@Component
public class EntryRepositoryImp implements EntryRepository {

    private DatabaseAccess access;

    public EntryRepositoryImp(DatabaseAccess access) {
        this.access = access;
    }

    @Override
    public Entry find(String url) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Entry entry) {
        Session session = this.access.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entry);
        transaction.commit();
        session.close();
    }

}
