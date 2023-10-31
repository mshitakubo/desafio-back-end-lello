package com.lello.challenge.service.user;

import com.lello.challenge.dto.UserDto;
import com.lello.challenge.dto.UserUpdateDto;
import com.lello.challenge.model.UserModel;
import com.lello.challenge.repositories.UserRepository;
import com.lello.challenge.service.user.exceptions.EntityNotFoundException;
import com.lello.challenge.utils.DescriptionValidation;
import com.lello.challenge.utils.EmailValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserSrv {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Object> create(UserDto userDto) {

            EmailValidation.isValidEmailAddressRegex(userDto.getEmail());
            DescriptionValidation.isValidDescription(userDto.getDescription());

            UserModel userModel =
                        new UserModel(userDto.getName(), userDto.getEmail(),userDto.getDescription(), LocalDateTime.now(), null);
            return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userModel));
    }

    public UserModel findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("user id " + id + ", não encontrado."));
    }

    public UserModel update(Long id, UserUpdateDto userUpdateDto) {

            UserModel userModel = findById(id);
            EmailValidation.isValidEmailAddressRegex(userUpdateDto.getEmail());

            UserModel usersModel =
                    new UserModel(userModel.getId(),
                            userUpdateDto.getName(),
                            userUpdateDto.getEmail(),
                            userModel.getDescription(),
                            userModel.getCreatedAt(),
                            LocalDateTime.now());

            return userRepository.save(usersModel);
    }
}
