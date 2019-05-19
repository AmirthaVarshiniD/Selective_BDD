@US37244_37246_All
Feature: To validate ELA Distribution Date

  Background: 
    Given login as Employee for CLAS with NBIS ".\TestData\AccountInfo.xlsx"
    And Select state FL with effective date from jan 10,2019 ".\TestData\US26185_PF_TC2.xlsx"
    And Selecting PF LOB ".\TestData\US26185_PF_TC2.xlsx"

  @US33776_TC5  
  Scenario: To validate ELA Distribution Date-NBQU
    And Navigate to LOB details page ".\TestData\US33776_TC5.xlsx"
    And In Coverages Screen ".\TestData\US33776_TC5.xlsx"
    And Adding Building Coverages
    And Adding Building and its optional Coverage ".\TestData\US33776_TC5.xlsx"
    Then Check ProMetrix ELA Date

  #    Then Rate PF Policy
  @US33776_TC3
  Scenario: To validate ELA Distribution Date-REIS
    And Navigate to LOB details page ".\TestData\US33776_TC5.xlsx"
    And In Coverages Screen ".\TestData\US33776_TC5.xlsx"
    And Adding Building Coverages
    And Adding Building and its optional Coverage ".\TestData\US33776_TC5.xlsx"
    Then Rate PF Policy
    And Issue Policy ".\TestData\IR_TC02.xlsx"
    Then Add Other Location for FL during Renewal ".\TestData\COP.xlsx"
    And Edit Property LOB
     Then Check ProMetrix ELA Date
#And  Then Check ProMetrix ELA Date for other Location