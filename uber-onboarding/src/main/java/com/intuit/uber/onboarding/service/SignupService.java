/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- uber-onboarding: SignupService
*- 26 Nov 2021 12:28 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

package com.intuit.uber.onboarding.service;

import org.springframework.stereotype.Service;

import com.intuit.uber.onboarding.exception.CustomException;
import com.intuit.uber.onboarding.model.entity.User;
import com.intuit.uber.onboarding.model.enums.IdentityType;
import com.intuit.uber.onboarding.model.enums.UserType;

@Service
public class SignupService {

    public void validateUserForSignup(User user) throws CustomException {
        if (user.getUserType().equals(UserType.DRIVER)
            && !user.getIdentityType().equals(IdentityType.DRIVING_LICENCE)) {
            throw new CustomException("Driver needs a driving licence as id proof");
        }

        if (user.getAge() < 18) {
            throw new CustomException("User is below the legal age to drive");
        }
    }
}
