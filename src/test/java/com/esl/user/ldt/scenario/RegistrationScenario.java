package com.esl.user.ldt.scenario;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.ElFileBody;
import static io.gatling.javaapi.core.CoreDsl.feed;
import static io.gatling.javaapi.core.CoreDsl.jsonFile;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;

public class RegistrationScenario {

    private static final FeederBuilder.FileBased<Object> jsonFeeder = jsonFile("users.json").random();

    private static ChainBuilder registerUser() {
        return feed(jsonFeeder)
            .exec(http("Register User")
                .post("/users")
                .body(ElFileBody("newUserTemplate.json")).asJson());
    }

    private static ChainBuilder activateUser() {
        return feed(jsonFeeder)
            .exec(
                http("Activate User")
                    .post("/users/activate")
                    .body(ElFileBody("newUserTemplate.json")).asJson());
    }

    public static final ScenarioBuilder registerScenario = scenario("Register")
        .exec(registerUser())
        .pause(1)
//        .exec(activateUser())
//        .pause(1)
        ;
}
