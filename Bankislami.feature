Feature: Bankislami site

  Scenario: Open bank islami website
    When open url "https://uatsharepoint.bankislami.com.pk/"
    And enter keyword in search textbox and click on enter
    Then search page title should be " - Google Search"
    And click on link
    Then page title should be "bankislami"