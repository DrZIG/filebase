/*
 * Created by Dr.ZIG© on 7.1.2020
 *
 */

package controllers;

import common.Settings;
import entities.Device;
import entities.File;
import org.hibernate.Session;

import java.util.List;

public class FileDatabseWithHibernate extends Hibernate implements WorkWithFilesDatabase {
    public FileDatabseWithHibernate(Settings settings) {
        super(settings);
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
        @SuppressWarnings("JpaQlInspection") List<File> files = session.createQuery("from Files").list();
        files.forEach(System.out::println);
//        session.save(device);
        session.getTransaction().commit();
        session.close();
    }
}
