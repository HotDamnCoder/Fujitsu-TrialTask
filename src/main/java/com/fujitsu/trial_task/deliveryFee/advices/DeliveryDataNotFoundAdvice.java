package com.fujitsu.trial_task.deliveryFee.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fujitsu.trial_task.deliveryFee.exceptions.DeliveryDataNotFoundException;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@ApiResponses(value = {
        @ApiResponse(responseCode = "404", description = "Delivery data not found") })
@ControllerAdvice
public class DeliveryDataNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(DeliveryDataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String deliveryForbiddenHandler(DeliveryDataNotFoundException ex) {
        return ex.getMessage();
    }
}
