package com.fujitsu.trial_task.deliveryFee.advices;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fujitsu.trial_task.deliveryFee.exceptions.DeliveryForbiddenException;

@ControllerAdvice
public class DeliveryForbiddenAdvice {
    
    @ResponseBody
    @ExceptionHandler(DeliveryForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String deliveryForbiddenHandler(DeliveryForbiddenException ex){
        return ex.getMessage();
    }
}