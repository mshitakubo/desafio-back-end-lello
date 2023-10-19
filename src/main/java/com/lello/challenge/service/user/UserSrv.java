package com.lello.challenge.service.user;

import com.lello.challenge.dto.UserDto;
import com.lello.challenge.dto.UserUpdateDto;
import com.lello.challenge.model.UserModel;
import com.lello.challenge.repositories.UserRepository;
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

        try{
            EmailValidation.isValidEmailAddressRegex(userDto.getEmail());
            DescriptionValidation.isValidDescription(userDto.getDescription());

            UserModel userModel =
                        new UserModel(userDto.getName(), userDto.getEmail(),userDto.getDescription(), LocalDateTime.now(), null);
            return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userModel));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    public ResponseEntity<Optional<UserModel>> findById(Long id) {
        try{
            UserModel userModel = userRepository.findById(id).orElse(null);
            if(userModel == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.ofNullable(userModel));
            }

            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(userModel));
        }catch (Exception e){
            return (ResponseEntity<Optional<UserModel>>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> update(Long id, UserUpdateDto userUpdateDto) {

        try{
            UserModel userModel = userRepository.findById(id).orElse(null);
            if(userModel == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.ofNullable(userModel));
            }

            EmailValidation.isValidEmailAddressRegex(userUpdateDto.getEmail());
            UserModel usersModel =
                    new UserModel(userModel.getId(),
                            userUpdateDto.getName(),
                            userUpdateDto.getEmail(),
                            userModel.getDescription(),
                            userModel.getCreatedAt(),
                            LocalDateTime.now());

            UserModel save = userRepository.save(usersModel);
            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(save));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
