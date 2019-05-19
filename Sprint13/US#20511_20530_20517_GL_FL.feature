@US20530_20511_20517 
Feature: To validate GL IRPM/GL Schedule Mod/Schedule IRPM for GL LOB FL State

  Background: 
    #Given login as Employee for CLAS with NBIS ".\TestData\AccountInfo.xlsx"
    Given Login to the application and select transaction ".\TestData\AccountInfo.xlsx"
    And Select state FL with effective date from jan 10,2019 ".\TestData\US#20530_20511_20517.xlsx"
    And Select GL Lob ".\TestData\US#20530_20511_20517.xlsx"

  @US20530_20511_20517_TC1 
  Scenario: GL-NBQU
    And Entering GL LOB Details ".\TestData\US#20530_20511_20517.xlsx"
    Then Rate policy
    Then Verify Schedule IRPM field in Pricing screen
    And User Navigates to Notepad Screen and verify GL MOD and GL Schedule MOD

  @US20530_20511_20517_TC2
  Scenario: GL-PCNM
    And Entering GL LOB Details ".\TestData\US#20530_20511_20517.xlsx"
    Then Rate policy
    And Issue GL Policy ".\TestData\IR_TC02.xlsx"
    And Endorse Policy ".\TestData\IR_TC02.xlsx"
    And Edit GL LOB and Add Coverage
    And User Navigates to Notepad Screen and verify GL MOD and GL Schedule MOD

  @US20530_20511_20517_TC3 @reg_200319
  Scenario: GL-REIS
    And Entering GL LOB Details ".\TestData\US#20530_20511_20517.xlsx"
    Then Rate policy
    And Issue GL Policy ".\TestData\IR_TC02.xlsx"
    And Renew New Buisness Policy
    And Edit GL LOB and Rate Policy
    Then Verify Schedule IRPM field in Pricing screen
    And User Navigates to Notepad Screen and verify GL MOD and GL Schedule MOD

  @US20530_20511_20517_TC4 
  Scenario: GL-ReQuote
    And Entering GL LOB Details ".\TestData\US#20530_20511_20517.xlsx"
    Then Rate policy
    And Exit TO DashBoard
    And Perform Requote ".\TestData\COP.xlsx"
    And Requote ".\TestData\COP.xlsx"
    And Edit GL LOB
    Then Verify Schedule IRPM field in Pricing screen
    And User Navigates to Notepad Screen and verify GL MOD and GL Schedule MOD

  @US20530_20511_20517_TC5 @reg_200319
  Scenario: GL
    And Entering GL LOB Details ".\TestData\US#20530_20511_20517.xlsx"
    Then Rate policy
    Then Verify Schedule IRPM field in Pricing screen
    And User Navigates to Notepad Screen and verify GL MOD and GL Schedule MOD
