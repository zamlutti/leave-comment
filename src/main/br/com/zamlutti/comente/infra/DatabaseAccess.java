package br.com.zamlutti.comente.infra;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class DatabaseAccess {

    private Configuration configuration;

    public DatabaseAccess() {
        this.configuration = new Configuration();
    }

    public Session getSession() {
        this.configuration.configure();
        SessionFactory factory = this.configuration.buildSessionFactory();
        Session session = factory.openSession();
        return session;
    }
}
