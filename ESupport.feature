Feature: Create A E-Support

  Scenario: Open url and create a new E-Support
    When open ESupport url "https://uatsharepoint.bankislami.com.pk/_login/default.aspx?ReturnUrl=%2fsites%2fesupport%2f_layouts%2f15%2fAuthenticate.aspx%3fSource%3d%252Fsites%252Fesupport&Source=%2Fsites%2Fesupport"
    And click on dropdown and select form for ESupport
    Then enter login details of ESupport
    Then click on sign in button of ESupport
    And get the total count of previous ES tickets
#    And click on create ticket ES menu link
    Then open ESupport create ticket and fill the form and click on submit ticket button
#    And click on ESupport Dashboard menu link
    And get the total count of new ES tickets