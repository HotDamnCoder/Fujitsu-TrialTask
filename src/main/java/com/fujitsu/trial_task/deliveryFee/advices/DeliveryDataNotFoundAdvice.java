package com.fujitsu.trial_task.deliveryFee.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fujitsu.trial_task.deliveryFee.exceptions.DeliveryDataNotFoundException;

@ControllerAdvice
public class DeliveryDataNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(DeliveryDataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String deliveryForbiddenHandler(DeliveryDataNotFoundException ex){
        return ex.getMessage();
    }
}
