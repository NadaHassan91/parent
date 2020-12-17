Feature: Creat Event and Weekly Schedule


  Background: Open Site
    Given Navigate web site
    And Login using user name "demo@parent.eu" and password "12345678"
    And click on kids palace
    And Click on calendar

  Scenario: User can create event
    And Click on create event
    And Add the required fields and save
    Then Assert that event is created successfully


    Scenario: User can edit event
      And Click on event
      And Click on edit
      And Edit event name and save
      Then Assert that event is edited successfully

    Scenario: User can delete event
      And Click on event
      And Click on Delete
      Then Assert that event is deleted successfully

