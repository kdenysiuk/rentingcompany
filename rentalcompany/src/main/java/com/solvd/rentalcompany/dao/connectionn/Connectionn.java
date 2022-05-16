package com.solvd.rentalcompany.dao.connectionn;

import com.solvd.rentalcompany.runner.Runner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connectionn {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    // =========================================
    private static final Properties props = new Properties();

    static {
        try {
            FileReader reader = new FileReader("rentalcompany/src/main/resources/database.properties");
            props.load(reader);
        } catch (IOException e) {
            LOGGER.debug(e.getMessage());
        }
    }

    private static final String url = props.getProperty("url");
    private static final String user = props.getProperty("user");
    private static final String password = props.getProperty("pass");

    public Connectionn() {
    }

//    public static DataSource getDataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setUrl(props.getProperty("db.url"));
//        dataSource.setUsername(props.getProperty("db.user"));
//        dataSource.setPassword(props.getProperty("db.pass"));
//        dataSource.setInitialSize(10);
//        return dataSource;
//    }

    public static Connection getConnection() throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", user);
        connectionProps.put("password", password);

        conn = DriverManager.getConnection(url, connectionProps);

        System.out.println("Connected to database");
        return conn;
    }

    // ==================================================

//    public static void getConnection() {
//        try
//        {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con= DriverManager.getConnection(
//                    props.getProperty("db.url"),props.getProperty("db.user"),props.getProperty("db.pass"));
//            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("show databases;");
//            System.out.println("Connected");
//        }
//        catch(Exception e)
//        {
//            System.out.println(e);
//        }
//    }

//    public static Connection getConnection() {
//        try {
//            return getDataSource().getConnection();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    //===================================

//    private static Properties props = new Properties();
//
//    static {
//        try {
//            FileReader reader = new FileReader("src/main/resources/db.properties");
//            props.load(reader);
//        } catch (IOException e) {
//            e.getMessage();
//        }
//    }
//    private static String url = props.getProperty("url");
//    private static String user = props.getProperty("user");
//    private static String password = props.getProperty("pass");
//    private static int INITIAL_POOL_SIZE = 1;
//    private static List<Connection> connectionPool = new ArrayList<>(INITIAL_POOL_SIZE);
//
//    private static List<Connection> usedConnections = new ArrayList<>();
//    private static ConnectionPool INSTANCE = null;
//
//    private static Connection createConnection(String url, String user, String password) throws SQLException {
//        return DriverManager.getConnection(url, user, password);
//    }
//
//    private ConnectionPool(String url, String user, String password, List<Connection> pool) {
//        this.url = url;
//        this.user = user;
//        this.password = password;
//        ConnectionPool.connectionPool = pool;
//    }
//
//    public static ConnectionPool getInstance() throws SQLException {
//        if (INSTANCE == null) {
//            INSTANCE = ConnectionPool.create(props.getProperty("url"), props.getProperty("user"),
//                    props.getProperty("pass"));
//        }
//        return INSTANCE;
//    }
//
//    private static ConnectionPool create(String url, String user, String password) throws SQLException {
//        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
//        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
//            pool.add(createConnection(url, user, password));
//        }
//        return new ConnectionPool(url, user, password, pool);
//    }
//
//    public static Connection getConnection() {
//        System.out.println(url);
//        System.out.println(user);
//        System.out.println(password);
//        Connection connection = connectionPool.remove(connectionPool.size() - 1);
//        usedConnections.add(connection);
//        return connection;
//    }

}
