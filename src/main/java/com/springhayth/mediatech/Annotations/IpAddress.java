package com.springhayth.mediatech.Annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IpAddressValidation.class})
public @interface IpAddress {

    String message() default "Invalid IP address";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
