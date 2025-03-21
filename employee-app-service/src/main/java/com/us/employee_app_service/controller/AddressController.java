package com.us.employee_app_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.us.employee_app_service.pojo.AddressDetails;
import com.us.employee_app_service.pojo.SuccessResponse;
import com.us.employee_app_service.service.AddressService;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/addAddress")
    public ResponseEntity<?> addAddress(@RequestBody AddressDetails addressDetails) {
        addressService.addAddress(addressDetails);
        return ResponseEntity.ok(new SuccessResponse("Address added successfully!"));
    }
    
    // @GetMapping("/autocomplete")
    // public ResponseEntity<JsonNode> getAutocompleteSuggestions(@RequestParam String query) {
    //     JsonNode suggestions = addressService.getAutocompleteSuggestions(query);
    //     return ResponseEntity.ok(suggestions);
    // }

}
