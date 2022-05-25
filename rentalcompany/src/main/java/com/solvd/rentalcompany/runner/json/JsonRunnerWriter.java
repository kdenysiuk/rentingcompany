package com.solvd.rentalcompany.runner.json;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.rentalcompany.entity.License;
import com.solvd.rentalcompany.entity.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonRunnerWriter {

    public static void main(String[] arg) {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("src/main/usersJsonOut.json");
        List<User> userList = new ArrayList<>();

        License sergeyLicense = new License("34755644", 2025);
        User sergey = new User("Sergey", "1189763465", "sergey@gmail.com", sergeyLicense);
        sergey.setIdUser(61);
        sergeyLicense.setIdLicense(61);
        License miguelLicense = new License("24557242", 2024);
        User miguel = new User("Miguel", "3624895674", "miguel@gmail.com", miguelLicense);
        miguel.setIdUser(62);
        miguelLicense.setIdLicense(62);

        userList.add(sergey);
        userList.add(miguel);

        try {
            objectMapper.writeValue(file, userList);
            System.out.println("finished");
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonGenerationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
