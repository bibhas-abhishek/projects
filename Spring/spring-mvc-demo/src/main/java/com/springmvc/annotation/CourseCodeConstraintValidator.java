/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 17 Mar 2018
 **/

package com.springmvc.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if (s != null)
            result = s.startsWith(coursePrefix);
        else
            return true;
        return result;
    }

}
