package com.solvd.rentalcompany.designpattern;

import com.solvd.rentalcompany.dao.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MyBatisFactory extends AbstractFactory {
    private static final SqlSessionFactory sessionFactory = SQLSessionFactoryUtil.getInstance();
    private static SqlSession sqlSession = sessionFactory.openSession();

    public static SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        MyBatisFactory.sqlSession = sqlSession;
    }

    public IDAO<?> chooseMapper(String mapper) {
        mapper = mapper.toLowerCase();
        switch (mapper) {
            case "license":
                return sqlSession.getMapper(ILicenseDAO.class);
            case "user":
                return sqlSession.getMapper(IUserDAO.class);
            case "insurance":
                return sqlSession.getMapper(IInsuranceDAO.class);
            case "location":
                return sqlSession.getMapper(ILocationDAO.class);
            case "building":
                return sqlSession.getMapper(IBuildingDAO.class);
            case "job_position":
                return sqlSession.getMapper(IJobPositionDAO.class);
            case "work_shift":
                return sqlSession.getMapper(IWorkShiftDAO.class);
            case "worker":
                return sqlSession.getMapper(IWorkerDAO.class);
            case "order":
                return sqlSession.getMapper(IOrderDAO.class);
        }
        return null;
    }
}
