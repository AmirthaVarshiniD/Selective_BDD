@US37244_37246_All
Feature: To validate state scan edits validation for PF LOB AL state

  Background: 
    #Given login as Employee for CLAS with NBIS ".\TestData\AccountInfo.xlsx"
    Given Login to the application and select transaction ".\TestData\AccountInfo.xlsx"
    And Select state FL with effective date from jan 10,2019 ".\TestData\US26185_PF_TC2.xlsx"
    And Selecting PF LOB ".\TestData\US26185_PF_TC2.xlsx"

  @US37244_37246_TC1  
  Scenario: Special Classes - Amusement Equipment in the Open - NBIS
    And Navigate to Location page and change city ".\TestData\US37244_TC1.xlsx"
    And In the Coverages Screen ".\TestData\US37244_TC1.xlsx"
    When Florida Sinkhole Loss Coverage is selected
    And Selecting Special Classes Coverage
    And Selecting Amusement Equipment in the Open Coverage ".\TestData\US37244_TC1.xlsx"
    Then Rate PF Policy

  @US37244_37246_TC2
  Scenario: Special Classes - Artificial Turf
    And Navigate to Location page and change city ".\TestData\US37244_TC2.xlsx"
    And In Coverages Screen ".\TestData\US37244_TC2.xlsx"
    When Florida Sinkhole Loss Coverage is selected
    And Selecting Special Classes Coverage
    And Selecting  Special Class - NOC coverage ".\TestData\US37244_TC2.xlsx"
    Then Rate PF Policy
    And Issue Policy ".\TestData\IR_TC02.xlsx"
    And Renew New Buisness Policy
    And Edit Property LOB
    And Add Optional Coverage
    And Selecting Artificial Turf coverage ".\TestData\US37244_TC2.xlsx"
    Then Rate PF Policy

  @US37244_37246_TC9
  Scenario: Special Classes -  Street Lights
    And Navigate to Location page and change city ".\TestData\US37244_TC9.xlsx"
    And In Coverages Screen ".\TestData\US37244_TC9.xlsx"
    When Florida Sinkhole Loss Coverage is selected
    And Selecting Special Classes Coverage
    And Selecting  Street Lights coverage ".\TestData\US37244_TC11.xlsx"
    Then Rate PF Policy
     And Issue Policy ".\TestData\IR_TC02.xlsx"
    And Renew New Buisness Policy
    And Edit Property LOB
    And Add Optional Coverage
    And Selecting  Property in the Open coverage ".\TestData\US37244_TC10.xlsx"
    Then Rate PF Policy

  @US37244_37246_TC3 
  Scenario: Special Classes -  Awnings and Canopies
    And Navigate to Location page and change city ".\TestData\US37244_TC3.xlsx"
    And In Coverages Screen ".\TestData\US37244_TC3.xlsx"
    When Florida Sinkhole Loss Coverage is selected
    And Selecting Special Classes Coverage
    And Selecting  Awnings and Canopies coverage ".\TestData\US37244_TC3.xlsx"
    And Selecting  Radio and TV Antenna coverage ".\TestData\US37244_TC15.xlsx"
    Then Rate PF Policy

  @US37244_37246_TC5
  Scenario: Special Classes -  Bleachers and Electronic Transformers
    And Navigate to Location page and change city ".\TestData\US37244_TC6.xlsx"
    And In Coverages Screen ".\TestData\US37244_TC6.xlsx"
    When Florida Sinkhole Loss Coverage is selected
    And Selecting Special Classes Coverage
    And Selecting  Bleachers coverage ".\TestData\US37244_TC4.xlsx"
    And Selecting  Electronic Transformers coverage ".\TestData\US37244_TC6.xlsx"
    And Selecting  Fences and Arbors coverage ".\TestData\US37244_TC8.xlsx"
    Then Rate PF Policy

  @US37244_37246_TC6
  Scenario: Special Classes -  Exhibit Stands
    And Navigate to Location page and change city ".\TestData\US37244_TC6.xlsx"
    And In Coverages Screen ".\TestData\US37244_TC6.xlsx"
    When Florida Sinkhole Loss Coverage is selected
    And Selecting Special Classes Coverage
    And Selecting  Exhibit Stands coverage ".\TestData\US37244_TC6.xlsx"
    Then Rate PF Policy
    And Exit TO DashBoard
    And Perform Requote ".\TestData\COP.xlsx"
    And Requote ".\TestData\COP.xlsx"
    And Edit Property LOB
    Then Rate Policy

  @US37244_37246_TC8
  Scenario: Special Classes -  Nursery Stock in the Open - NBIS
    And Navigate to Location page and change city ".\TestData\US37244_TC8.xlsx"
    And In the Coverages Screen ".\TestData\US37244_TC8.xlsx"
    When Florida Sinkhole Loss Coverage is selected
    And Selecting Special Classes Coverage
    And Selecting  Nursery Stock in the Open coverage ".\TestData\US37244_TC8.xlsx"
    Then Rate PF Policy

  @US37244_37246_TC7
  Scenario: Special Classes -  Fences and Arbors
    And Navigate to Location page and change city ".\TestData\US37244_TC1.xlsx"
    And In the Coverages Screen ".\TestData\PF_FL.xlsx"
    When Florida Sinkhole Loss Coverage is selected
    And Selecting Special Classes Coverage
    And Selecting  Fences and Arbors coverage ".\TestData\US37244_TC8.xlsx"
    Then Rate PF Policy

  @US37244_37246_TC166
  Scenario: Special Classes -  Swimming Pools
    And Navigate to Location page and change city ".\TestData\US37244_TC1.xlsx"
    And In the Coverages Screen ".\TestData\PF_FL.xlsx"
    When Florida Sinkhole Loss Coverage is selected
    And Selecting Special Classes Coverage
    And Selecting  Swimming Pools coverage ".\TestData\US37244_TC14.xlsx"
    Then Rate PF Policy

  @US37244_37246_TC12
  Scenario: Special Classes -  Tents and Fabrics - NBIS
    And Navigate to Location page and change city ".\TestData\US37244_TC12.xlsx"
    And In Coverages Screen ".\TestData\US37244_TC12.xlsx"
    When Florida Sinkhole Loss Coverage is selected
    And Selecting Special Classes Coverage
    And Selecting  Tents and Fabrics coverage ".\TestData\US37244_TC12.xlsx"
    Then Rate PF Policy

  @US37244_37246_TC13
  Scenario: Special Classes -  Water/Sewage Lift Pumps-NBIS
    And Navigate to Location page and change city ".\TestData\US37244_TC13.xlsx"
    And In Coverages Screen ".\TestData\US37244_TC13.xlsx"
    When Florida Sinkhole Loss Coverage is selected
    And Selecting Special Classes Coverage
    And Selecting  Water/Sewage Lift Pumps coverage ".\TestData\US37244_TC13.xlsx"
    Then Rate PF Policy

  @US37244_37246_TC14
  Scenario: Special Classes -  Rafts and Floating Equipment
    And Navigate to Location page and change city ".\TestData\US37244_TC14.xlsx"
    And In Coverages Screen ".\TestData\US37244_TC14.xlsx"
    When Florida Sinkhole Loss Coverage is selected
    And Selecting Special Classes Coverage
    And Selecting  Rafts and Floating Equipment coverage ".\TestData\US37244_TC14.xlsx"
    Then Rate PF Policy

  @US37244_37246_TC16 
  Scenario: BPP 
    And Navigate to Location page and change city ".\TestData\US37244_TC16.xlsx"
    And In Coverages Screen ".\TestData\US37244_TC16.xlsx"
    When Florida Sinkhole Loss Coverage is selected
    And Adding BPP optional Coverage ".\TestData\US37244_TC16.xlsx"
    And Adding Coverage Inflation Guard
    And Adding BPP Legal Liability optional Coverage ".\TestData\US37244_TC16.xlsx"
    Then Rate PF Policy
    And Exit TO DashBoard
    And Perform Requote ".\TestData\COP.xlsx"
    And Requote ".\TestData\COP.xlsx"
    And Edit Property LOB
    Then Rate Policy

  @US37244_37246_TC17
  Scenario: Building
    And Navigate to Location page and change city ".\TestData\US37244_TC17.xlsx"
    And In Coverages Screen ".\TestData\US37244_TC17.xlsx"
    When Florida Sinkhole Loss Coverage is selected
    And Adding Building Coverages
    And Adding Building and its optional Coverage ".\TestData\US37244_TC17.xlsx"
    And Adding Legal Liability optional Coverage ".\TestData\US37244_TC17.xlsx"
    And Adding Demolition Cost optional Coverage ".\TestData\US37244_TC17.xlsx"
    Then Rate PF Policy

  @US37244_37246_TC18
  Scenario: TIB
    And Navigate to Location page and change city ".\TestData\US37244_TC1.xlsx"
    And In Coverages Screen ".\TestData\US37244_TC18.xlsx"
    When Florida Sinkhole Loss Coverage is selected
    And Adding TIB Coverages ".\TestData\US37244_TC18.xlsx"
    And Adding EarthQuake Sprinkler Leakage Coverage ".\TestData\US37244_TC18.xlsx"
    And Adding Coverage Inflation Guard
    And Adding TIB optional Coverage Legal Liability ".\TestData\US37244_TC18.xlsx"
    Then Rate PF Policy
