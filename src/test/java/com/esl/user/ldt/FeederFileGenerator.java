package com.esl.user.ldt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FeederFileGenerator {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Faker faker = new Faker();
    private static final List<UserResource> users = new ArrayList<>();

    public static void main(String[] args) {
        IntStream
            .range(0, 1_000)
            .forEach(i -> {
                UserResource resource = buildUser();
                users.add(resource);
            });

        try {
            String json = mapper.writeValueAsString(users);

            FileUtils.writeStringToFile(new File("src/test/resources/users.json"), json, "UTF-8");
        } catch (Exception ignored) {
            System.err.println("Error writing to file: " + ignored.getMessage());
        }
    }

    private static UserResource buildUser() {
        return UserResource
            .builder()
            .firstName(faker.name().firstName())
            .lastName(faker.name().lastName())
            .nickname(faker.name().username())
            .password(faker.internet().password())
            .email(faker.internet().emailAddress())
            .country(faker.address().countryCode())
            .build();
    }
}
