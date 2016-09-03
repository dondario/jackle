/*
 * Copyright Omnifone Limited 2009-2016. All rights reserved.
 * This source code includes confidential proprietary information.
 */
package hello;

public class PreferenceRatingSystem implements RatingSystem {
    public Integer rate(Appointment appointment, Preference preference) {
        return appointment.getPromotions();
    }
}
