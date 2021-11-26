/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- uber-onboarding: UserType
*- 25 Nov 2021 11:44 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

package com.intuit.uber.onboarding.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum UserType {

                      RIDER(1, "rider"),

                      DRIVER(2, "driver"),

                      ADMIN(3, "admin");

    private final int    id;

    private final String value;
}
