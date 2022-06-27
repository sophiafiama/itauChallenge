package com.is_challenge.is_challenge.apiUser.controller;

import com.is_challenge.is_challenge.apiStreaming.dto.score.ScoreDTO;
import com.is_challenge.is_challenge.apiUser.dto.UserResponse;
import com.is_challenge.is_challenge.apiUser.entity.User;
import com.is_challenge.is_challenge.apiUser.service.UserService;
import com.is_challenge.is_challenge.apiUser.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    private final UserService service;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserDTO dto) {
        System.out.println(dto.toString());
        service.create(modelMapper.map(dto, User.class));
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();

    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> get(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(modelMapper.map(service.get(id), UserResponse.class));
    }

}
