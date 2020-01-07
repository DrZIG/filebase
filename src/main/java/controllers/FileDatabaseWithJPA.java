/*
 * Created by Dr.ZIG© on 7.1.2020
 *
 */

package controllers;

import common.Settings;
import entities.Device;
import entities.File;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class FileDatabaseWithJPA extends JPA implements WorkWithFilesDatabase {
    public FileDatabaseWithJPA(Settings settings) {
        super(settings);
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

    @SuppressWarnings("JpaQlInspection")
    private void getFileUsingStaticQuery() {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        entityManager.createQuery("from File");
        entityManager.createQuery("Select file from Files as file", File.class)
                .getResultList()
                .forEach(System.out::println);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
