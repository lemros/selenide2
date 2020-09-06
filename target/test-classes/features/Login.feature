Feature: Test prihlasenia

  Background: User navigates to home page
    Given I am on the "int moja" page

  Scenario: Successful login with virtual mobile token
    When I fill in Ippid with 97994385
    And I fill in Pin with 13579
    Then I click on Log in Button

  Scenario Outline: Failed login using wrong credentials
    When I fill in <ippidInput> with <ippid>
    And I fill in <pinInput> with <pin>
    Then I click on Log in Button
    And I should see <warning> message
    Examples:
      | ippidInput | ippid    | pinInput | pin  | warning     |
      | Ippid      | 97994385 | Pin      | 1357 | Je nám líto |
      | Ippid      | 97994385 | Pin      | 1357 | nieco       |

  Scenario: Successful login with virtual mobile token #2
    When I am logged with mobileToken

  Scenario: Successful login with virtual mobile token #3
    When nieco
    And I fill in Ippid with: 97994385
    And I fill in Pin with: 12345
    Then Iclick on Login Button




