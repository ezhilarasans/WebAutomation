Feature: SauceDemo Application

  Scenario Outline: Login and logout the application
    Given I open the Application in <browser> browser
    When I login the application using "<userName>" and password "<password>"
    Then The following elements should be shown on Home Screen
      | homePageHeader |
      | true           |
    When I logout the application
    Then The following elements should be shown on Home Screen
      | loginPageHeader |
      | true            |

    @regression
    Examples:
      | browser | userName      | password     |
      | CHROME  | standard_user | secret_sauce |
      | CHROME  | problem_user  | secret_sauce |
      | CHROME  | visual_user   | secret_sauce |