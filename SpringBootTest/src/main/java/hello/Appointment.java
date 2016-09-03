/*
 * Copyright Omnifone Limited 2009-2016. All rights reserved.
 * This source code includes confidential proprietary information.
 */
package hello;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.Instant;

public class Appointment implements Booking {
    private final String appointmentId;
    private final Instant bookingDateTime;
    private final Instant startDateTime;
    private final Instant endDateTime;
    private final String customerId;
    private final Integer promotions;

    public Appointment(String appointmentId, Instant bookingDateTime, Instant startDateTime, Instant endDateTime, String customerId, Integer promotions) {
        this.appointmentId = appointmentId;
        this.bookingDateTime = bookingDateTime;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.customerId = customerId;
        this.promotions = promotions;
    }

    public Appointment(String appointmentId, Instant bookingDateTime, Instant startDateTime, Instant endDateTime, String customerId) {
        this(appointmentId, bookingDateTime, startDateTime, endDateTime, customerId, 0);
    }

    public String getAppointmentId() {
        return appointmentId;
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

    public Integer getPromotions() {
        return promotions;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Appointment rhs = (Appointment) obj;
        return new EqualsBuilder()
                .append(this.appointmentId, rhs.appointmentId)
                .append(this.bookingDateTime, rhs.bookingDateTime)
                .append(this.startDateTime, rhs.startDateTime)
                .append(this.endDateTime, rhs.endDateTime)
                .append(this.customerId, rhs.customerId)
                .append(this.promotions, rhs.promotions)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(appointmentId)
                .append(bookingDateTime)
                .append(startDateTime)
                .append(endDateTime)
                .append(customerId)
                .append(promotions)
                .toHashCode();
    }
}
