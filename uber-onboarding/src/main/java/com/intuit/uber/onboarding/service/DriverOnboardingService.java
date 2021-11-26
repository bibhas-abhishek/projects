/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- uber-onboarding: DriverOnboardingService
*- 26 Nov 2021 9:02 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

package com.intuit.uber.onboarding.service;

import org.springframework.stereotype.Component;

import com.intuit.uber.onboarding.exception.CustomException;
import com.intuit.uber.onboarding.model.entity.DriverOnboardingDetails;
import com.intuit.uber.onboarding.model.entity.User;

@Component
public interface DriverOnboardingService {

    void initOnboarding(User user);

    DriverOnboardingDetails updateOnboarding(Long id,
                                             DriverOnboardingDetails details) throws CustomException;
}
