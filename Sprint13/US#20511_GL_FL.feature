@US#20530_20511_20517
Feature: To validate the GL state scan edits validation for GL LOB FL state

  Background: 
    Given Login as Employee and click new buisness issue ".\TestData\AccountInfo.xlsx"
    And login as Employee for CLAS with NBIS ".\TestData\US#20530_20511_20517.xlsx"
    And Select state FL with effective date from jan 10,2019 ".\TestData\US#20530_20511_20517.xlsx"

  @US#20530_20511_20517_TC1
  Scenario: GL
    And Select GL Lob ".\TestData\US#20530_20511_20517.xlsx"
    And Entering GL LOB Details ".\TestData\US#20530_20511_20517.xlsx"
    Then Rate policy
