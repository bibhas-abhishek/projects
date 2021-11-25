/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- uber-onboarding: IdentityType
*- 25 Nov 2021 11:52 PM
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
public enum IdentityType {

                          AADHAR(1, "aadhar"),

                          DRIVING_LICENCE(2, "driving_licence");

    private final int    id;

    private final String value;
}
