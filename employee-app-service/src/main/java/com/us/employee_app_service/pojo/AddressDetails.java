package com.us.employee_app_service.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDetails {
    private String fullName;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
