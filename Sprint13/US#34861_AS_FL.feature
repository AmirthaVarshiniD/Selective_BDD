@US59390_All
Feature: To validate state scan edits validation for Auto LOB FL state

  Background: 
    #Given login as Employee for CLAS with NBIS ".\TestData\Auto.xlsx"
    Given Login to the application and select transaction ".\TestData\AccountInfo.xlsx"
    And Select state FL with effective date from jan 10,2019 ".\TestData\US59390_AS.xlsx"
    And Select Auto Non Dealer LOB ".\TestData\US59390_AS.xlsx"
    And In Auto Non Dealer LOB details page ".\TestData\US59390_AS.xlsx"
     And Navigating next Screen


  #US59390
  @US34861_TC3 @Reg190319
  Scenario: AS
    When Navigate to Vehicles and Drivers Screen ".\TestData\US59390_GR.xlsx"
    And Generate Class Code ".\TestData\US59390_GR.xlsx"
    And Enter Driver Information ".\TestData\US59390_GR.xlsx"
    Then Rate Policy
