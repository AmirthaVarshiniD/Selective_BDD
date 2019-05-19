Feature: To validate state scan edits validation for Auto LOB FL state

  Background: 
    Given login as Employee for CLAS with NBIS ".\TestData\Auto.xlsx"
    And Select state FL with effective date from jan 10,2019 ".\TestData\US_56112_AU_FL_VT37.xlsx"
    And Select AUTO LOB ".\TestData\US_56112_AU_FL_VT37.xlsx"
    And Navigate to Auto LOB page ".\TestData\US_56112_AU_FL_VT37.xlsx"
    And Navigate to Auto State Information ".\TestData\US_56112_AU_FL_VT37.xlsx"

  #56112
  @US_56112_TC002 @Reg16
  Scenario: Verify the user is able to navigate from Vehicle class code screen through validation class code,Vehicle type-37
    When Navigate to Vehicles and Drivers Screen ".\TestData\US_56112_AU_FL_VT37.xlsx"
    Then Verify the user is able to navigate from Vehicle class code screen through validation class code ".\TestData\US_56112_AU_FL_VT37.xlsx"

  @US_56112_TC003 @Reg16
  Scenario: Verify Vehicle weight field is available on Class code information section for Vehicle type 38
    When Navigate to Vehicles and Drivers Screen ".\TestData\US_56112_AU_FL_VT38.xlsx"
    Then Verify the user is able to navigate from Vehicle class code screen  through Generate class code ".\TestData\US_56112_AU_FL_VT38.xlsx"

  @US_56112_TC005 @Reg16
  Scenario: Verify Vehicle weight field is available on Class code information section for Vehicle type 9
    When Navigate to Vehicles and Drivers Screen ".\TestData\US_56112_AU_FL_VT9.xlsx"
    Then Verify Vehicle weight field is available on Class code information section ".\TestData\US_56112_AU_FL_VT9.xlsx"

  @US_56112_TC008
  Scenario: Verify Vehicle weight field is available on Class code information section for Vehicle type 11
    When Navigate to Vehicles and Drivers Screen ".\TestData\US_56112_AU_FL_VT11.xlsx"
    Then Verify generate class code on Class code information section ".\TestData\US_56112_AU_FL_VT11.xlsx"

  @US_56112_TC011 @Reg16
  Scenario: Verify Vehicle weight field is available on Class code information section for Vehicle type 13
    When Navigate to Vehicles and Drivers Screen ".\TestData\US_56112_AU_FL_VT13.xlsx"
    Then Verify generate class code functiona;ity for vehicle type 13 ".\TestData\US_56112_AU_FL_VT13.xlsx"
