package controllers;

import common.Settings;
import entities.Device;
import entities.File;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Properties;

public class JPAController implements SQLController{
    private final EntityManagerFactory entityManagerFactory;

    public JPAController(Settings settings) {
        Properties properties = new Properties();
        properties.setProperty("IFEXISTS", "false");
        entityManagerFactory = Persistence.createEntityManagerFactory(settings.DEFAULT_DATABASE.get(), properties);
    }

    @Override
    public void addDevice(Device device) {
        if (deviceExist(device))
            return;

        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(device);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void addFile(File file) {
        if (fileExist(file))
            return;

        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(file);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private boolean deviceExist(Device device) {
        return false;
    }

    private boolean fileExist(File file) {
        return false;
    }

    private void getFileUsingCriteria() {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<File> fileCriteria = criteriaBuilder.createQuery(File.class);
        Root<File> fileRoot = fileCriteria.from(File.class);
        fileCriteria.select(fileRoot);
        entityManager.createQuery(fileCriteria)
                .getResultList()
                .forEach(System.out::println);
//        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private void getFileUsingStaticQuery() {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        entityManager.createQuery("from File");
        entityManager.createQuery("Select file from File as file", File.class)
                .getResultList()
                .forEach(System.out::println);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
