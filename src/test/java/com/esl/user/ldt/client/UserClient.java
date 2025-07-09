package com.esl.user.ldt.client;

import static io.gatling.javaapi.http.HttpDsl.http;

import io.gatling.javaapi.http.HttpProtocolBuilder;

public class UserClient {

    public static final HttpProtocolBuilder userHttpProtocol = http
        .baseUrl("http://user.local")
        .acceptHeader("application/json")
        .contentTypeHeader("application/json");
}
