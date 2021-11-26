/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- uber-onboarding: AccountDetailsService
*- 27 Nov 2021 12:44 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

package com.intuit.uber.onboarding.service;

import org.springframework.stereotype.Component;

import com.intuit.uber.onboarding.exception.CustomException;
import com.intuit.uber.onboarding.model.entity.AccountDetails;
import com.intuit.uber.onboarding.model.entity.User;

@Component
public interface AccountDetailsService {

    void initAccountDetails(User user);

    AccountDetails updateAccountDetails(Long id, AccountDetails details) throws CustomException;
}
