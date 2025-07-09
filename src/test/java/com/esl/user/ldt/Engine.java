package com.esl.user.ldt;

import com.esl.user.ldt.simulation.RegisterSimulation;
import io.gatling.app.Gatling;
import io.gatling.core.config.GatlingPropertiesBuilder;

public class Engine {
    public static void main(String[] args) {
        var props = new GatlingPropertiesBuilder()
            .simulationClass(RegisterSimulation.class.getName())
            .resultsDirectory(IDEPathHelper.resultsDirectory.toString());

        Gatling.fromMap(props.build());
    }
}
