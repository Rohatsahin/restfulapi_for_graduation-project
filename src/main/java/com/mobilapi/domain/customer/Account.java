package com.mobilapi.domain.customer;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mobilapi.domain.enums.UserRole;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;


@Entity(value = "account", noClassnameStored = true)
public class Account extends AbstractAuditableEntity {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phone;

    private String city;

    private String district;

    private UserRole userRole = UserRole.User;

    @Embedded
    private Address address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @JsonIgnore
    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
