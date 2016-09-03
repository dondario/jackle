/*
 * Copyright Omnifone Limited 2009-2016. All rights reserved.
 * This source code includes confidential proprietary information.
 */
package hello;

public class Customer {
    private final String customerId;
    public Customer(String customerId) {
        this.customerId = customerId;
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
        Customer rhs = (Customer) obj;
        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(this.customerId, rhs.customerId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder()
                .append(customerId)
                .toHashCode();
    }
}
