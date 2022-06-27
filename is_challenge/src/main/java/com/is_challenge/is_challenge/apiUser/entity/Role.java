package com.is_challenge.is_challenge.apiUser.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Role {
    READER(0, "ROLE_READER"),
    BASIC(1, "ROLE_BASIC"),
    ADVANCED(2, "ROLE_ADVANCED"),
    ADMIN(3, "ROLE_ADMIN");

    private final int cod;
    private final String name;

    public static Role toEnum(Integer cod) {
        if (cod == null) return null;

        return Arrays.stream(Role.values()).filter(role -> {
            return cod.equals(role.getCod());
        }).findFirst().orElseThrow(
                () -> new IllegalArgumentException("Id inválido: " + cod)
        );
    }
}
