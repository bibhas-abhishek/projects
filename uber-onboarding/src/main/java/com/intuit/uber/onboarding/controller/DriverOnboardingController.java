/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- uber-onboarding: SignupController
*- 26 Nov 2021 12:01 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

package com.intuit.uber.onboarding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.uber.onboarding.exception.CustomException;
import com.intuit.uber.onboarding.model.entity.CustomResponseEntity;
import com.intuit.uber.onboarding.model.entity.DriverOnboardingDetails;
import com.intuit.uber.onboarding.service.DriverOnboardingService;
import com.intuit.uber.onboarding.service.impl.SignupServiceImpl;

@RestController
@RequestMapping("/api/onboarding")
public class DriverOnboardingController {

    @Autowired
    private SignupServiceImpl       signupService;

    @Autowired
    private DriverOnboardingService driverOnboardingService;

    @PutMapping("/update/{id}")
    public CustomResponseEntity updateOnboardingDetails(@PathVariable Long id,
                                                        @RequestBody DriverOnboardingDetails details) {
        try {
            DriverOnboardingDetails dbDetails = driverOnboardingService.updateOnboarding(id,
                details);
            return new CustomResponseEntity(HttpStatus.OK, dbDetails,
                HttpStatus.OK.getReasonPhrase());
        } catch (CustomException customException) {
            return new CustomResponseEntity(HttpStatus.BAD_REQUEST, null,
                customException.getMessage());
        } catch (Exception exception) {
            return new CustomResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
    }
}
