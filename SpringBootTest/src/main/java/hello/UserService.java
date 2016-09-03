/*
 * Copyright Omnifone Limited 2009-2016. All rights reserved.
 * This source code includes confidential proprietary information.
 */
package hello;

import java.util.List;

public class UserService {
    List<Customer> customers;

    public UserService(List<Customer> customers) {
        this.customers = customers;
    }

    public Customer createFetchUser(String userId) {
        Customer customer = new Customer(userId);
        int indexOfUser = customers.indexOf(customer);

        if(indexOfUser > -1) {
            return customers.get(indexOfUser);
        }

        customers.add(customer);
        return customer;
    }
}
