package com.us.employee_app_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.employee_app_service.entity.Address;
import com.us.employee_app_service.pojo.AddressDetails;
import com.us.employee_app_service.repository.AddressRepository;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository addressRepository;

    public AddressDetails addAddress(AddressDetails addressDetails) {
        Address address = new Address();
        address.setFullName(addressDetails.getFullName());
        address.setStreetAddress(addressDetails.getStreetAddress());
        address.setCity(addressDetails.getCity());
        address.setState(addressDetails.getState());
        address.setCountry(addressDetails.getCountry());
        address.setZipCode(addressDetails.getZipCode());
        addressRepository.save(address);
        return addressDetails;
    }

    
}
