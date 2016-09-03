/*
 * Copyright Omnifone Limited 2009-2016. All rights reserved.
 * This source code includes confidential proprietary information.
 */
package hello;

import java.time.Instant;

public class Preference implements Booking {
    private final String preferenceId;
    private final Instant bookingDateTime;
    private final Instant startDateTime;
    private final Instant endDateTime;
    private final String customerId;
    private final String appointmentId;

    public Preference(String preferenceId, Instant bookingDateTime, Instant startDateTime, Instant endDateTime, String customerId, String appointmentId) {
        this.preferenceId = preferenceId;
        this.bookingDateTime = bookingDateTime;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.customerId = customerId;
        this.appointmentId = appointmentId;
    }

    public String getPreferenceId() {
        return preferenceId;
    }

    public Instant getBookingDateTime() {
        return bookingDateTime;
    }

    public Instant getStartDateTime() {
        return startDateTime;
    }

    public Instant getEndDateTime() {
        return endDateTime;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }
}
