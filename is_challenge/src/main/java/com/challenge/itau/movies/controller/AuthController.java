package com.challenge.itau.movies.controller;

import com.challenge.itau.config.security.UserSpringSecurity;
import com.challenge.itau.config.utils.JwtUtil;
import com.challenge.itau.users.service.impl.UserSpringSecurityService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;

    @ApiOperation(value = "This endpoint refresh the token authentication.")
    @PostMapping("refresh_token")
    public ResponseEntity<?> refreshToken() {
        UserSpringSecurity user = UserSpringSecurityService.authenticated();
        assert user != null;
        String token = jwtUtil.generateToken(user.getUsername());
        return ResponseEntity
                .noContent()
                .header("Authorization", "Bearer " + token)
                .build();
    }
}
