package com.us.employee_app_service.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponse {

    private String message;

    public SuccessResponse(String message) {
        this.message = message;
    }
}
