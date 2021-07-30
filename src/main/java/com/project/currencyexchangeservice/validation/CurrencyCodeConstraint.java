package com.project.currencyexchangeservice.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = CurrencyCodeValidator.class)
public @interface CurrencyCodeConstraint {
	String message() default "Currency code entered is not accepted!";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
