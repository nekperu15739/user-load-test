package com.esl.user.ldt.simulation;

import io.gatling.javaapi.core.Simulation;

import static com.esl.user.ldt.client.UserClient.userHttpProtocol;
import static com.esl.user.ldt.scenario.RegistrationScenario.registerScenario;
import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;

public class RegisterSimulation extends Simulation {

    {
        setUp(registerScenario
            .injectOpen(
                rampUsers(10).during(10),
                constantUsersPerSec(10).during(30),
                rampUsers(0).during(20)
            ))
            .protocols(userHttpProtocol);
    }
}
