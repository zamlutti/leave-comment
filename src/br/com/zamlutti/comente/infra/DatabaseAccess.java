package br.com.zamlutti.comente.infra;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
public class DatabaseAccess implements ComponentFactory<Session>{

	private Configuration configuration;
	private ServiceRegistryBuilder registryBuilder;
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;

	public DatabaseAccess() {
		this.configuration = new Configuration();
		this.registryBuilder = new ServiceRegistryBuilder();
	}

	public Session getInstance() {
		configuration.configure();
		serviceRegistry = registryBuilder
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		factory = configuration.buildSessionFactory(serviceRegistry);
		return factory.openSession();
	}
}
