package com.solvd.rentalcompany.runner;

import com.solvd.rentalcompany.entity.License;
import com.solvd.rentalcompany.entity.RentalComany;
import com.solvd.rentalcompany.entity.User;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

public class JaxbRunner {

    public static void main(String[] arg) throws JAXBException {
        License sergeyLicense = new License("34755644", 2025);
        User sergey = new User("Sergey", "1189763465", "sergey@gmail.com", sergeyLicense);
        sergey.setIdUser(61);
        sergeyLicense.setIdLicense(61);
        License miguelLicense = new License("24557242", 2024);
        User miguel = new User("Miguel", "3624895674", "miguel@gmail.com", miguelLicense);
        miguel.setIdUser(62);
        miguelLicense.setIdLicense(62);

        RentalComany users = new RentalComany();

        users.users.add(sergey);
        users.users.add(miguel);

        JAXBContext ctx = JAXBContext.newInstance(RentalComany.class);
        Marshaller ms = ctx.createMarshaller();
        ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        ms.marshal(users, new File("rentalcompany/src/main/usersJaxb.xml"));
        System.out.println("Finish");

    }

}
