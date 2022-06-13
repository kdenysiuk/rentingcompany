package com.solvd.rentalcompany.runner.mybatis;

import com.solvd.rentalcompany.dao.*;
import com.solvd.rentalcompany.designpattern.AbstractFactory;
import com.solvd.rentalcompany.designpattern.MyBatisFactory;
import com.solvd.rentalcompany.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class MybatisRunner {

    private static final Logger LOGGER = LogManager.getLogger(MybatisRunner.class);

    static MyBatisFactory myBatisFactory = (MyBatisFactory) AbstractFactory.chooseFactory("mybatis");

    public static void main(String[] args) {
        ILicenseDAO licenseMapper = (ILicenseDAO) myBatisFactory.chooseMapper("license");
        LOGGER.info("------License------");
        License license = licenseMapper.get(1);
        LOGGER.info("License = " + license);
        LOGGER.info(license.getIdLicense());
        LOGGER.info("License = " + licenseMapper.get(2));
        List<License> licenseList = licenseMapper.getAll();
        licenseList.forEach(LOGGER::info);

        IUserDAO userMapper = (IUserDAO) myBatisFactory.chooseMapper("user");
        LOGGER.info("------User------");
        User user = userMapper.get(1);
        LOGGER.info("User = " + user);
        LOGGER.info(user.getIdUser());
        LOGGER.info("User = " + userMapper.get(2));
        List<User> userList = userMapper.getAll();
        userList.forEach(LOGGER::info);

        IInsuranceDAO insuranceMapper = (IInsuranceDAO) myBatisFactory.chooseMapper("insurance");
        LOGGER.info("------Insurance------");
        Insurance insurance = insuranceMapper.get(1);
        LOGGER.info("Insurance = " + insurance);
        LOGGER.info(insurance.getIdInsurance());
        LOGGER.info("Insurance = " + insuranceMapper.get(2));
        List<Insurance> insuranceList = insuranceMapper.getAll();
        insuranceList.forEach(LOGGER::info);

        ILocationDAO locationMapper = (ILocationDAO) myBatisFactory.chooseMapper("location");
        LOGGER.info("------Location------");
        Location location = locationMapper.get(1);
        LOGGER.info("Location = " + location);
        LOGGER.info(location.getIdLocation());
        LOGGER.info("Location = " + locationMapper.get(2));
        List<Location> locationList = locationMapper.getAll();
        locationList.forEach(LOGGER::info);

        IBuildingDAO buildingMapper = (IBuildingDAO) myBatisFactory.chooseMapper("building");
        LOGGER.info("------Building------");
        Building building = buildingMapper.get(1);
        LOGGER.info("Building = " + building);
        LOGGER.info(building.getIdBuilding());
        LOGGER.info("Building = " + buildingMapper.get(2));
        List<Building> buildingList = buildingMapper.getAll();
        buildingList.forEach(LOGGER::info);

        IJobPositionDAO jobPositionMapper = (IJobPositionDAO) myBatisFactory.chooseMapper("job_position");
        LOGGER.info("------Job Position------");
        JobPosition jobPosition = jobPositionMapper.get(1);
        LOGGER.info("Job Position = " + jobPosition);
        LOGGER.info(jobPosition.getIdPosition());
        LOGGER.info("Job Position = " + jobPositionMapper.get(2));
        List<JobPosition> jobPositionList = jobPositionMapper.getAll();
        jobPositionList.forEach(LOGGER::info);

        IWorkShiftDAO workShiftMapper = (IWorkShiftDAO) myBatisFactory.chooseMapper("work_shift");
        LOGGER.info("------Work Shift------");
        WorkShift workShift = workShiftMapper.get(1);
        LOGGER.info("Work Shift = " + workShift);
        LOGGER.info(workShift.getIdWorkShift());
        LOGGER.info("Work Shift = " + workShiftMapper.get(2));
        List<WorkShift> workShiftList = workShiftMapper.getAll();
        workShiftList.forEach(LOGGER::info);

        IWorkerDAO workerMapper = (IWorkerDAO) myBatisFactory.chooseMapper("worker");
        LOGGER.info("------Worker------");
        Worker worker = workerMapper.get(1);
        LOGGER.info("Worker = " + worker);
        LOGGER.info(worker.getIdWorker());
        LOGGER.info("Worker = " + workerMapper.get(2));
        List<Worker> workerList = workerMapper.getAll();
        workerList.forEach(LOGGER::info);

        IOrderDAO orderMapper = (IOrderDAO) myBatisFactory.chooseMapper("order");
        LOGGER.info("------Orders------");
        Order order = orderMapper.get(1);
        LOGGER.info("Order = " + order);
        LOGGER.info(order.getIdOrder());
        LOGGER.info("Order = " + orderMapper.get(2));
        List<Order> orderList = orderMapper.getAll();
        orderList.forEach(LOGGER::info);
    }

}
