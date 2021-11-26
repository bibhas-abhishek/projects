/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- uber-onboarding: SignService
*- 26 Nov 2021 6:29 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

package com.intuit.uber.onboarding.service;

import org.springframework.stereotype.Component;

import com.intuit.uber.onboarding.exception.CustomException;
import com.intuit.uber.onboarding.model.entity.User;

import java.util.Optional;

@Component
public interface UserService {

    User userSignupService(User user) throws CustomException;

    Optional<User> findUser(Long id);
}
