package com.fujitsu.trial_task.deliveryFee.exceptions;

public class DeliveryDataNotFoundException extends RuntimeException {

    public DeliveryDataNotFoundException() {
        super("The required data for calculating delivery fee was not found");
    }

}
