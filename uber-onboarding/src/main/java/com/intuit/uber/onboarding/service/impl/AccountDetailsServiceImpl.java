/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- uber-onboarding: AccountServiceImpl
*- 27 Nov 2021 12:50 AM
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
import com.intuit.uber.onboarding.model.entity.AccountDetails;
import com.intuit.uber.onboarding.model.entity.User;
import com.intuit.uber.onboarding.repository.AccountDetailsRepository;
import com.intuit.uber.onboarding.service.AccountDetailsService;
import com.intuit.uber.onboarding.service.UserService;

@Service
@Transactional
public class AccountDetailsServiceImpl implements AccountDetailsService {

    @Autowired
    private UserService              userService;

    @Autowired
    private AccountDetailsRepository accountDetailsRepository;

    @Override
    public void initAccountDetails(User user) {
        AccountDetails details = new AccountDetails();
        details.setUser(user);
        details.setIsOnline(false);
        accountDetailsRepository.save(details);
    }

    @Override
    public AccountDetails updateAccountDetails(Long id,
                                               AccountDetails details) throws CustomException {
        Optional<User> userOptional = userService.findUser(id);
        if (userOptional.isPresent()) {
            AccountDetails dbDetails = accountDetailsRepository.findByUser(userOptional.get());
            dbDetails.setIsOnline(details.getIsOnline());
            return accountDetailsRepository.save(dbDetails);
        }
        throw new CustomException("User details not found");
    }
}
