package com.esl.user.ldt;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class UserResource {

    private String firstName;
    private String lastName;
    private String nickname;
    private String password;
    private String email;
    private String country;

}
