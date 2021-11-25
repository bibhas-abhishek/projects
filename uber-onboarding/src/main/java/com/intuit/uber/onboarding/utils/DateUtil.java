/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- uber-onboarding: DateUtil
*- 26 Nov 2021 12:25 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

package com.intuit.uber.onboarding.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {

    public static long getYearDiff(Date d1, Date d2) {
        long diffInMillies = Math.abs(d2.getTime() - d1.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return diff;
    }
}
