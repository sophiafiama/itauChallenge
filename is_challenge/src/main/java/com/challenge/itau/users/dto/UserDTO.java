package com.challenge.itau.users.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;

}
