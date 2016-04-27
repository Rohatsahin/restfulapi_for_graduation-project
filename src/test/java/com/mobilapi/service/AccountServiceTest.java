package com.mobilapi.service;

import com.mobilapi.bulider.AccountBuilder;
import com.mobilapi.domain.customer.Account;
import com.mobilapi.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private ShaPasswordEncoder passwordEncoder;


    @Test
    public void shouldSaveNewAccount(){

        Account account = new AccountBuilder().firstName("rohat").email("rohat@test.com").password("12345").bulid();
        when(passwordEncoder.encodePassword("password",null)).thenReturn("test_password");

    }


}