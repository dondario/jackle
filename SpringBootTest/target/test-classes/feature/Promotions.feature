# Created by darrenseeto at 28/07/2016
Feature: Promotions
  How a customer can get promoted into and who should be promoted first

  Scenario: A user I want a customer who has a preference for a free slot moved
    Given the following appointments exist:
      | appointmentId | customerId  | bookingDateTime         | startDateTime             | endDateTime             | promotions |
      | 1             | Darren      | 2014-12-03T10:15:30.00Z | 2014-12-04T11:00:00.00Z   | 2014-12-04T12:00:00.00Z | 0          |
    And the following preferences exist:
      | preferenceId  | customerId  | bookingDateTime         | startDateTime             | endDateTime             | appointmentId |
      | 1             | Darren      | 2014-12-03T10:15:30.00Z | 2014-12-04T10:00:00.00Z   | 2014-12-04T11:00:00.00Z | 1             |
    When we try to fill the empty slot starting at "2014-12-04T10:00:00.00Z" and ending at "2014-12-04T11:00:00.00Z"
    Then preferenceId "1"  for "Darren" should be chosen to fill the slot

  Scenario: A user I want a customer who has already been promoted to be promoted over somebody who has not.
    Given the following appointments exist:
      | appointmentId | customerId  | bookingDateTime         | startDateTime             | endDateTime             | promotions |
      | 1             | Darren      | 2014-12-03T10:15:30.00Z | 2014-12-04T10:00:00.00Z   | 2014-12-04T11:00:00.00Z | 0          |
      | 2             | Julien      | 2014-12-03T12:15:30.00Z | 2014-12-04T16:00:00.00Z   | 2014-12-04T17:00:00.00Z | 1          |
    And the following preferences exist:
      | preferenceId  | customerId  | bookingDateTime         | startDateTime             | endDateTime             | appointmentId |
      | 1             | Darren      | 2014-12-03T10:15:30.00Z | 2014-12-04T09:00:00.00Z   | 2014-12-04T09:30:00.00Z | 1             |
      | 2             | Julien      | 2014-12-03T12:15:30.00Z | 2014-12-04T09:00:00.00Z   | 2014-12-04T09:30:00.00Z | 2             |
    When we try to fill the empty slot starting at "2014-12-04T09:00:00.00Z" and ending at "2014-12-04T09:30:00.00Z"
    Then preferenceId "2"  for "Julien" should be chosen to fill the slot

  Scenario: Two customers have the same preference but one has an appointment at a later date
    Given: Customer A has an appointment 3 days away and Customer B has an appointment for 5 days away and they both have a preference for the same slot
    Then customer B should be moved




