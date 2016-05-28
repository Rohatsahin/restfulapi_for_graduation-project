package com.mobilapi.domain.customer;


import com.mobilapi.domain.enums.AddressType;
import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Address {

    private String addressName;

    private String phone;

    private String district;

    private String addressInfo;

    private AddressType addressType = AddressType.DIGER;

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressName='" + addressName + '\'' +
                ", phone='" + phone + '\'' +
                ", district='" + district + '\'' +
                ", addressInfo='" + addressInfo + '\'' +
                ", addressType=" + addressType +
                '}';
    }
}
