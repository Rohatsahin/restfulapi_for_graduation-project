package com.mobilapi.controller.general;


import com.mobilapi.controller.dto.UserDto;
import com.mobilapi.security.AuthenticationService;
import com.mobilapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/public")
public class RegisterController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(method = RequestMethod.POST, value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserDto> saveNewUser(@RequestBody @Valid UserDto userDto) {

        accountService.saveAccount(userDto.createUser());
        authenticationService.authenticate(userDto.getEmail(), userDto.getPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
