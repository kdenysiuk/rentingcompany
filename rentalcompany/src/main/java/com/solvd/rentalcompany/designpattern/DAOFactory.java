package com.solvd.rentalcompany.designpattern;

import com.solvd.rentalcompany.dao.*;
import com.solvd.rentalcompany.dao.mysql.*;

public class DAOFactory extends AbstractFactory{

    public IDAO<?> getDAO(String dao) {
        dao = dao.toLowerCase();
        switch (dao) {
            case "license":
                return new MySQLLicenseDAO();
            case "user":
                return new MySQLUserDAO();
            case "insurance":
                return new MySQLInsuranceDAO();
            case "location":
                return new MySQLLocationDAO();
            case "building":
                return new MySQLBuildingDAO();
            case "job_position":
                return new MySQLJobPositionDAO();
            case "work_shift":
                return new MySQLWorkShiftDAO();
            case "worker":
                return new MySQLWorkerDAO();
            case "order":
                return new MySQLOrderDAO();
        }
        return null;
    }
}
