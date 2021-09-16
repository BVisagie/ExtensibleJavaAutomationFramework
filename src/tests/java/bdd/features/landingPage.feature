Feature: Landing Page Features
  This section will test all landing page features

  Scenario: Checking the landing page title
    Given I navigate to the landing page of the application
    And I retrieve the landing page title
    Then The title should be equal to "Wikipedia"