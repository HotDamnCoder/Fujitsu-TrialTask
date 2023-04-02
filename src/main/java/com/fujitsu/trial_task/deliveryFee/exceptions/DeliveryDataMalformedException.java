package com.fujitsu.trial_task.deliveryFee.exceptions;

public class DeliveryDataMalformedException extends RuntimeException {

    public DeliveryDataMalformedException(String e) {
        super("The required data for calculating delivery fee was malformed: " + e);
    }

}
