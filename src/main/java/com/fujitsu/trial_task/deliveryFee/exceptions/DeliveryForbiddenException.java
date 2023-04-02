package com.fujitsu.trial_task.deliveryFee.exceptions;

public class DeliveryForbiddenException extends RuntimeException {

    public DeliveryForbiddenException() {
        super("Usage of selected vehicle type is forbidden");
    }

}
