/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- uber-onboarding: SignupController
*- 26 Nov 2021 12:01 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

package com.intuit.uber.onboarding.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.uber.onboarding.exception.CustomException;
import com.intuit.uber.onboarding.model.entity.CustomResponseEntity;
import com.intuit.uber.onboarding.model.entity.DriverOnboardingDetails;
import com.intuit.uber.onboarding.model.entity.User;
import com.intuit.uber.onboarding.service.DriverOnboardingService;
import com.intuit.uber.onboarding.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService             userService;

    @Autowired
    private DriverOnboardingService driverOnboardingService;

    @PostMapping("/user")
    public CustomResponseEntity signupUser(@RequestBody User user) {
        try {
            User dbUser = userService.userSignupService(user);
            DriverOnboardingDetails dbDetails = driverOnboardingService.initOnboarding(dbUser);
            return new CustomResponseEntity(HttpStatus.CREATED, dbDetails,
                HttpStatus.CREATED.getReasonPhrase());
        } catch (CustomException customException) {
            return new CustomResponseEntity(HttpStatus.BAD_REQUEST, null,
                customException.getMessage());
        } catch (Exception exception) {
            return new CustomResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
    }

    @GetMapping("/user/{id}")
    @Cacheable(value = "user", key = "#id")
    public CustomResponseEntity getCustomer(@PathVariable Long id) {
        Optional<User> user = userService.findUser(id);
        if (user.isPresent()) {
            return new CustomResponseEntity(HttpStatus.OK, user, HttpStatus.OK.getReasonPhrase());
        }
        return new CustomResponseEntity(HttpStatus.NOT_FOUND, null,
            HttpStatus.NOT_FOUND.getReasonPhrase());
    }
}
