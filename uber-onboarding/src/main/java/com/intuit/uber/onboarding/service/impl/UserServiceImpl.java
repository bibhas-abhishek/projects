/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- uber-onboarding: SignupService
*- 26 Nov 2021 12:28 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

package com.intuit.uber.onboarding.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intuit.uber.onboarding.exception.CustomException;
import com.intuit.uber.onboarding.model.entity.User;
import com.intuit.uber.onboarding.model.enums.IdentityType;
import com.intuit.uber.onboarding.model.enums.UserType;
import com.intuit.uber.onboarding.repository.UserRepository;
import com.intuit.uber.onboarding.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User userSignupService(User user) throws CustomException {
        if (user.getUserType().equals(UserType.DRIVER)
            && !user.getIdentityType().equals(IdentityType.DRIVING_LICENCE)) {
            throw new CustomException("Driver needs a driving licence as id proof");
        }

        if (user.getAge() < 18) {
            throw new CustomException("User is below the legal age to drive");
        }
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }
}
