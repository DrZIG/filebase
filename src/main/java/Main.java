import entities.Device;
import entities.File;

import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("");
    }
//    public static void main(String[] args) {
//        var testDevice = new Device();
//        testDevice.setName("Test");
//
//        var testFile = new File();
//        testFile.setFullPath("C:\\2\\_Done\\Turilli Lione Rhapsody - Zero Gravity Rebirth and Evolution - Metal-Tracker.com.torrent");
//        testFile.setSize(11_912);
//        testFile.setDoNotProcess(true);
//        testFile.setDevice(testDevice);
//        testFile.setSaveToStorage(true);
//
//        var entityManagerFactory = Persistence.createEntityManagerFactory("com.drzig.filebase");
//        var entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(testDevice);
//        entityManager.persist(testFile);
//        entityManager.getTransaction().commit();
//        entityManager.close();

//        entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.createQuery("from File", File.class)
//                .getResultList()
//                .forEach(file -> System.out.println(String.format("%s, %d", file.getFullPath(), file.getSize())));
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }

}
