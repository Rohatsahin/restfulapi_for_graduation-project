package com.mobilapi.controller.user;


import com.mobilapi.domain.customer.Account;
import com.mobilapi.domain.customer.Address;
import com.mobilapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserController extends SecureBaseController {

    @Autowired
    private AccountService accountService;





}
