package com.fujitsu.trial_task.deliveryFee.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fujitsu.trial_task.deliveryFee.exceptions.DeliveryForbiddenException;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@ApiResponses(value = {
        @ApiResponse(responseCode = "403", description = "Delivery forbidden with given vehicle type and weather") })
@ControllerAdvice

public class DeliveryForbiddenAdvice {

    @ResponseBody
    @ExceptionHandler(DeliveryForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String deliveryForbiddenHandler(DeliveryForbiddenException ex) {
        return ex.getMessage();
    }
}
