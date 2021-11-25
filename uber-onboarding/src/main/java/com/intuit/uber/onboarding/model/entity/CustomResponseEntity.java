/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- uber-onboarding: CustomResponseEntity
*- 26 Nov 2021 12:44 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

package com.intuit.uber.onboarding.model.entity;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomResponseEntity {

    private HttpStatus httpStatus;

    private Object     data;

    private String     message;
}
