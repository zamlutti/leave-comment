package br.com.zamlutti.comente.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class DataSessionFatoryImp implements ComponentFactory<SessionFactory> {

	private SessionFactory factory;

	@PostConstruct
	public void open() {
		Configuration configuration = new Configuration();
		configuration.configure();

		ServiceRegistryBuilder registryBuilder = new ServiceRegistryBuilder();
		ServiceRegistry serviceRegistry = registryBuilder.applySettings(
				configuration.getProperties()).buildServiceRegistry();
		this.factory = configuration.buildSessionFactory(serviceRegistry);
	}

	public SessionFactory getInstance() {
		return this.factory;
	}

	@PreDestroy
	public void close() {
		this.factory.close();
	}
}