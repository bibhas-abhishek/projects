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
public enum ProcessState {

                          INITIATED(1, "initiated"),

                          IN_PROGRESS(2, "in_progress"),

                          COMPLETED(3, "completed");

    private final int    id;

    private final String value;
}
