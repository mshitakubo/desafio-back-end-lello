package com.lello.challenge.controller.user;

import com.lello.challenge.dto.UserDto;
import com.lello.challenge.dto.UserUpdateDto;
import com.lello.challenge.model.UserModel;
import com.lello.challenge.service.user.UserSrv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserSrv userSrv;

    @PostMapping
    public ResponseEntity<UserModel> create(@RequestBody @Valid UserDto userDto) {
        return userSrv.create(userDto);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserModel> findById(@PathVariable(required = true) Long id) {
        UserModel byId = userSrv.findById(id);
        return ResponseEntity.ok(byId);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserModel> updateById(@PathVariable(required = true) Long id,
                                                @RequestBody UserUpdateDto userUpdateDto) {
        UserModel update = userSrv.update(id, userUpdateDto);
        return ResponseEntity.ok(update);
    }

}
