package com.soumen.simplebilling.util;

import lombok.experimental.UtilityClass;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class AppUtils {
    public static Integer noOfDaysBetween(Date usageEndDate, Date usageStartDate) {
        long diffInMs = Math.abs(usageEndDate.getTime() - usageStartDate.getTime());
        return Math.toIntExact(TimeUnit.DAYS.convert(diffInMs, TimeUnit.MILLISECONDS));
    }

    public static Double cubicFeetToKwh(Double unitsUsed) {
        return (unitsUsed * 2.83 * 39.2 * 1.02264) / 3.6;
    }
}
