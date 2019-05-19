@US59390_All
Feature: To validate state scan edits validation for Auto LOB FL state

  Background: 
    Given login as Employee for CLAS with NBIS ".\TestData\Auto.xlsx"
    And Select state FL with effective date from jan 10,2019 ".\TestData\US_56561_Garage.xlsx"
    And Select Garage LOB ".\TestData\US_56561_Garage.xlsx"
    And Navigate to Garage LOB details page and select Med Symbol ".\TestData\US59390_GR.xlsx"

  #US59390
  @US59390_TC2
  Scenario: Verify Med Pay coverage is available on Vehicle Optional Coverages Page
    When Navigate to Vehicles and Drivers Screen ".\TestData\US59390_GR.xlsx"
    And Generate Class Code ".\TestData\US59390_GR.xlsx"
    Then Verify Med Pay coverage is available on Vehicle Optional Coverages Page

  #  And Enter Driver Information ".\TestData\US59390_GR.xlsx"
  # Then Rate Policy
  
  
