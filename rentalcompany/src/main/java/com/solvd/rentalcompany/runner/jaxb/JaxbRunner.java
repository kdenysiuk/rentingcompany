package com.solvd.rentalcompany.runner.jaxb;

import com.solvd.rentalcompany.entity.License;
import com.solvd.rentalcompany.entity.User;

import com.solvd.rentalcompany.runner.DAORunner;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class JaxbRunner {
    private static final Logger LOGGER = LogManager.getLogger(DAORunner.class);

    public static void main(String[] arg) throws JAXBException {
        License sergeyLicense = new License("34755644", 2025);
        User sergey = new User("Sergey", "1189763465", "sergey@gmail.com", sergeyLicense);
        sergey.setIdUser(61);
        sergeyLicense.setIdLicense(61);
        License miguelLicense = new License("24557242", 2024);
        User miguel = new User("Miguel", "3624895674", "miguel@gmail.com", miguelLicense);
        miguel.setIdUser(62);
        miguelLicense.setIdLicense(62);

        User users = new User();

        users.user.add(sergey);
        users.user.add(miguel);

        JAXBContext ctx = JAXBContext.newInstance(User.class);
        Marshaller ms = ctx.createMarshaller();
        ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        ms.marshal(users, new File("src/main/usersJaxbOut.xml"));
        LOGGER.info("Finish");

    }

}
