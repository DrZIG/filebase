/*
 * Created by Dr.ZIG© on 7.1.2020
 *
 */

package controllers;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract class MySQL {
    protected MySQL() throws Exception {
        Connection connection;
        Driver driver;
        try {
            driver = new com.mysql.jdbc.Driver();
        } catch (SQLException e) {
            throw new Exception("Cannot load class driver", e);
        }
        DriverManager.registerDriver(driver);
    }
}
