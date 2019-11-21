package part.dao;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Objects;
import java.util.Properties;

public class JDBCConnectionProducer {

    private static final String FILE_PROPERTY = "db.properties";
    private String driver;
    private String url;
    private String user;
    private String password;


    @Produces
    private Connection createConnection() {
        Connection connection;
        initProperty();

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user,password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e.toString(), e);
        }

        return connection;
    }

    private void initProperty() {
        Properties props = new Properties();
        FileInputStream fis = getFileInputStream();
        loadProperty(props, fis);

        driver = props.getProperty("DB_DRIVER_CLASS");
        url = props.getProperty("DB_URL");
        user = props.getProperty("DB_USERNAME");
        password = props.getProperty("DB_PASSWORD");
    }

    private FileInputStream getFileInputStream() {
        FileInputStream fis;
        try {
            fis = new FileInputStream(Objects.requireNonNull(this.getClass().getClassLoader().getResource(FILE_PROPERTY)).getFile());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.toString(), e);
        }
        return fis;
    }

    private void loadProperty(Properties properties, FileInputStream fis) {
        try {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e.toString(), e);
        }
    }



    private void closeConnection(@Disposes Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.toString(), e);
        }
    }
}
