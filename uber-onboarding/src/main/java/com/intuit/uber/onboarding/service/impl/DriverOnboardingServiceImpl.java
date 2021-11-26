/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- uber-onboarding: DriverOnboardingServiceImpl
*- 26 Nov 2021 9:05 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

package com.intuit.uber.onboarding.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intuit.uber.onboarding.exception.CustomException;
import com.intuit.uber.onboarding.model.entity.DriverOnboardingDetails;
import com.intuit.uber.onboarding.model.entity.User;
import com.intuit.uber.onboarding.model.enums.ProcessState;
import com.intuit.uber.onboarding.repository.DriverOnboardingRepository;
import com.intuit.uber.onboarding.service.DriverOnboardingService;
import com.intuit.uber.onboarding.service.UserService;

@Service
@Transactional
public class DriverOnboardingServiceImpl implements DriverOnboardingService {

    @Autowired
    private UserService                userService;

    @Autowired
    private DriverOnboardingRepository driverOnboardingRepository;

    @Override
    public void initOnboarding(User user) {
        DriverOnboardingDetails details = new DriverOnboardingDetails();
        details.setUser(user);
        details.setBackgroundCheck(ProcessState.INITIATED);
        details.setDocumentCollection(ProcessState.INITIATED);
        details.setTrackingDevice(ProcessState.INITIATED);
        driverOnboardingRepository.save(details);
    }

    @Override
    public DriverOnboardingDetails updateOnboarding(Long id,
                                                    DriverOnboardingDetails details) throws CustomException {
        Optional<User> userOptional = userService.findUser(id);
        if (userOptional.isPresent()) {
            DriverOnboardingDetails dbDetails = driverOnboardingRepository
                .findByUser(userOptional.get());
            dbDetails.setBackgroundCheck(details.getBackgroundCheck());
            dbDetails.setDocumentCollection(details.getDocumentCollection());
            dbDetails.setTrackingDevice(details.getTrackingDevice());
            return driverOnboardingRepository.save(dbDetails);
        }
        throw new CustomException("User details not found");
    }
}
