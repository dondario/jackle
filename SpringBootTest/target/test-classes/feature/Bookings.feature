# Created by darrenseeto at 28/07/2016 http://www.hascode.com/2014/12/bdd-testing-with-cucumber-java-and-junit/
Feature: Bookings
  How a customer interacts with the booking system.

  Scenario: Patient books an appointment
    Given there is a slot available
    When a user books an appointment
    Then it should be stored in the system

  Scenario: Patient books an appointment but has other preferences
    Given there is a slot available and the user has a preferred time
    When a user books an appointment
    Then they should specify a minimum of 3 other options

