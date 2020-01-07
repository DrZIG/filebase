package controllers;

import common.Settings;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

abstract class JPA {
    protected final EntityManagerFactory entityManagerFactory;

    protected JPA(Settings settings) {
        Properties properties = new Properties();
        properties.setProperty("IFEXISTS", "false");
        entityManagerFactory = Persistence.createEntityManagerFactory(settings.DEFAULT_DATABASE.get(), properties);
    }
}
