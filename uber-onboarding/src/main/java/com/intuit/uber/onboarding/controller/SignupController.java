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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.uber.onboarding.exception.CustomException;
import com.intuit.uber.onboarding.model.entity.CustomResponseEntity;
import com.intuit.uber.onboarding.model.entity.User;
import com.intuit.uber.onboarding.repository.UserRepository;
import com.intuit.uber.onboarding.service.SignupService;

@RestController
@RequestMapping("/api")
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SignupService  signupService;

    @PostMapping("/signupUser")
    public CustomResponseEntity signupUser(@RequestBody User user) {
        try {
            signupService.validateUserForSignup(user);
            return new CustomResponseEntity(HttpStatus.CREATED, userRepository.save(user),
                HttpStatus.CREATED.getReasonPhrase());
        } catch (CustomException customException) {
            return new CustomResponseEntity(HttpStatus.BAD_REQUEST, null,
                customException.getMessage());
        } catch (Exception exception) {
            return new CustomResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
    }

    @GetMapping("/getUser/{id}")
    public CustomResponseEntity getCustomer(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new CustomResponseEntity(HttpStatus.OK, user, HttpStatus.OK.getReasonPhrase());
        }
        return new CustomResponseEntity(HttpStatus.NOT_FOUND, null,
            HttpStatus.NOT_FOUND.getReasonPhrase());
    }
}
