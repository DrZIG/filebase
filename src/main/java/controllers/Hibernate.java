package controllers;

import common.Settings;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public abstract class Hibernate {
    private final StandardServiceRegistry registry;
    protected SessionFactory sessionFactory;

    protected Hibernate(Settings settings) {
        registry = new StandardServiceRegistryBuilder()
                .configure(settings.DEFAULT_DATABASE.get())
                .build();
        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
