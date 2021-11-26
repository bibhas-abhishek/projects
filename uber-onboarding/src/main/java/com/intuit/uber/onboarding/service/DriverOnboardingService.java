/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- uber-onboarding: DriverOnboardingService
*- 26 Nov 2021 9:02 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

package com.intuit.uber.onboarding.service;

import com.intuit.uber.onboarding.exception.CustomException;
import org.springframework.stereotype.Component;

import com.intuit.uber.onboarding.model.entity.DriverOnboardingDetails;
import com.intuit.uber.onboarding.model.entity.User;

import java.util.Optional;

@Component
public interface DriverOnboardingService {

    DriverOnboardingDetails initOnboarding(User user);

    DriverOnboardingDetails updateOnboarding(Long id, DriverOnboardingDetails details) throws CustomException;
}
