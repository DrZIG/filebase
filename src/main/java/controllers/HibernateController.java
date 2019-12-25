package controllers;

import common.Settings;
import entities.Device;
import entities.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HibernateController implements SQLController {
    private final StandardServiceRegistry registry;
    private SessionFactory sessionFactory;

    public HibernateController(Settings settings) {
        registry = new StandardServiceRegistryBuilder()
                .configure(settings.DEFAULT_DATABASE.get())
                .build();
        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Override
    public void addFile(File file) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(file);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void addDevice(Device device) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(device);
        session.getTransaction().commit();
        session.close();
    }

    public void readFiles() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<File> files = session.createQuery("from Files").list();
        files.forEach(System.out::println);
//        session.save(device);
        session.getTransaction().commit();
        session.close();
    }

    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
