/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 17 Mar 2018
 **/

package com.springmvc.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    String value() default "LUV";

    String message() default "must start with LUV";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
