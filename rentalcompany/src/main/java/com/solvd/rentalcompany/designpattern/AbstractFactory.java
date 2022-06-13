package com.solvd.rentalcompany.designpattern;

public class AbstractFactory {
    private static final MyBatisFactory myBatisFactory = new MyBatisFactory();

    public static AbstractFactory chooseFactory(String connection) {
        connection = connection.toLowerCase();
        switch (connection) {
            case "mybatis":
                return myBatisFactory;
        }
        return null;
    }
}