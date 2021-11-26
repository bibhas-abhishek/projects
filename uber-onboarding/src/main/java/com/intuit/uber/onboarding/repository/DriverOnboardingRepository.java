/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- uber-onboarding: UserRepository
*- 26 Nov 2021 12:02 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

package com.intuit.uber.onboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intuit.uber.onboarding.model.entity.DriverOnboardingDetails;
import com.intuit.uber.onboarding.model.entity.User;

@Repository
public interface DriverOnboardingRepository extends JpaRepository<DriverOnboardingDetails, Long> {

    DriverOnboardingDetails findByUser(User user);
}
