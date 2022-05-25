package com.solvd.rentalcompany.runner.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.rentalcompany.entity.User;

import java.io.File;
import java.io.IOException;

public class JsonRunnerReader {

    public static void main(String[] arg) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("src/main/resources/usersJson.json");
        User keith = objectMapper.readValue(file, User.class);
        System.out.println(keith);
    }

}
