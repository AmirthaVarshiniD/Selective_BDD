@US20530_20511_20517
Feature: To validate the GL state scan edits validation for GL LOB FL state

  Background: 
    Given SLT login as Agent ".\TestData\US26185_PF_TC1.xlsx"
    And Select state FL ".\TestData\US26185_PF_TC1.xlsx"
    And Selecting GL LOB in Agent ".\TestData\US#20530_20511_20517.xlsx"

  @US20530_20511_20517_TC
  Scenario: GL-NBQU
    And Entering GL LOB Details ".\TestData\US#20530_20511_20517.xlsx"
    Then Rate policy
    Then Verify Schedule IRPM field in Pricing screen
    And User Navigates to Notepad Screen and verify GL MOD and GL Schedule MOD

  
