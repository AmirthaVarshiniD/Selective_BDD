@US37244_37246_All
Feature: To validate ELA Distribution Date

  Background: 
    Given SLT login as Agent ".\TestData\US26185_PF_TC1.xlsx"
    And Select state FL ".\TestData\US26185_PF_TC1.xlsx"
    And Selecting PF LOB in Agent ".\TestData\US26185_PF_TC1.xlsx"

  @US33776_TC1
  Scenario: Building
    And Navigate to LOB details page ".\TestData\US33776_TC1.xlsx"
    And In Coverages Screen ".\TestData\US33776_TC1.xlsx"
    And Adding Building Coverages
    And Adding Building and its optional Coverage ".\TestData\US33776_TC1.xlsx"
    Then Check ProMetrix ELA Date
    #    Then Rate PF Policy
