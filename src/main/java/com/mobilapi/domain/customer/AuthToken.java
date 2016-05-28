package com.mobilapi.domain.customer;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

@Entity(value = "auth_token", noClassnameStored = true)
public class AuthToken extends AbstractAuditableEntity {


    private String token;

    private String series;

    @Embedded
    private Account account;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

