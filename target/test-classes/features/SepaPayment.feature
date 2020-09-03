Feature: Create Sepa Payment

  Scenario: Create Sepa Payment with only mandatory fieds
    Given I am logged
    Then I fill <receiverIban> <amount> <dueDate> <>1