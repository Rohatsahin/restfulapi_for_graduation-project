package com.mobilapi.controller.user;


import com.mobilapi.domain.customer.Account;
import com.mobilapi.security.service.AuthenticationService;
import com.mobilapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController extends SecureBaseController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/current_user", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getCurrentUserInfo(Principal principal) {

        Account account = accountService.findByEmail(principal.getName());

        if (account instanceof Account) {
            return new ResponseEntity(account, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
