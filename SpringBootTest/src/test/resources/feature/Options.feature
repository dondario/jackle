Feature: Options
  What options a customer can define

  Scenario: A patient specifies a specific slot as an option
    When a user specifies a specific slot as an option
    Then the users preference should be stored

  Scenario: A patient specifies a range that covers multiple slots on a specific day
    When a user asks for Monday from 2pm to 5pm
    Then the users preference for a Monday slot between 2pm to 5pm  should be stored

  Scenario: A patient asks for before or after work slots
    When a user asks for any day after 5pm
    Then the users preference for any slot between after 5pm on any day shoudl be stored
