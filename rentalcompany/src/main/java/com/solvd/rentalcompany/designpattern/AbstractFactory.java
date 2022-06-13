package com.solvd.rentalcompany.designpattern;

public class AbstractFactory {
    private static final MyBatisFactory myBatisFactory = new MyBatisFactory();
    private static final DAOFactory daoFactory = new DAOFactory();

    public static AbstractFactory chooseFactory(String connection) {
        connection = connection.toLowerCase();
        switch (connection) {
            case "mybatis":
                return myBatisFactory;
            case "jdbc":
                return daoFactory;
        }
        return null;
    }
}