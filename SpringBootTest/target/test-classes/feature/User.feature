# Created by darrenseeto at 28/07/2016
Feature: User
  How a user can choose to fill their schedules

  Scenario: As a user I want to fill a slot with a user of my choice who has a preference for that slot
    Given: That there are customers who have the preference for the slot
    Then the user can choose from a list of customers who have a prefernce for that slot

  Scenario: A user wants to fill up all the slots within a given time period
    Given: That there are customers with preferences for those slots
    Then the system should consolidate customers with those preferences into that time period

