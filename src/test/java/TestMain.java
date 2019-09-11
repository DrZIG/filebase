import entities.Device;
import entities.File;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestMain {

    private EntityManagerFactory entityManagerFactory;

    @Before
    public void setUp() throws Exception {
        var testDevice = new Device();
        testDevice.setName("Test");

        var testFile = new File();
        testFile.setFullPath("C:\\2\\_Done\\Turilli Lione Rhapsody - Zero Gravity Rebirth and Evolution - Metal-Tracker.com.torrent");
        testFile.setSize(11_912);
        testFile.setDoNotProcess(true);
        testFile.setDevice(testDevice);
        testFile.setSaveToStorage(true);

//        entityManagerFactory = Persistence.createEntityManagerFactory("com.drzig.memtest");
        entityManagerFactory = Persistence.createEntityManagerFactory("com.drzig.filebase_test");
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(testDevice);
        entityManager.persist(testFile);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void firstTest() {

        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("from File", File.class)
                .getResultList()
                .forEach(file -> System.out.println(String.format("%s, %d", file.getFullPath(), file.getSize())));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
