package com.lello.challenge.controller.user;

import com.lello.challenge.dto.UserDto;
import com.lello.challenge.dto.UserUpdateDto;
import com.lello.challenge.model.UserModel;
import com.lello.challenge.service.user.UserSrv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserSrv userSrv;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid UserDto userDto) {
        return userSrv.create(userDto);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<UserModel>> findById(@PathVariable(required = true) Long id) {
        return userSrv.findById(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateById(@PathVariable(required = true) Long id,
                                             @RequestBody UserUpdateDto userUpdateDto) {
        return userSrv.update(id, userUpdateDto);
    }

}