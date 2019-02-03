@version:Release1 @UniqueBrowser
Feature: Employee Creation

  Scenario: Login
    Given I Login to AMS Application
      | Application | Username  | Password |
      | AMS         | adminacct | @@admin  |

  Scenario: Employee Creation Form Verification
    Given I am in a AMS Default Page
    When I Click on Employees button
    And I Click on Add New button and wait till progress disapper
    Then I Click on Cancel button and wait till progress disapper

  Scenario Outline: Employee Creation With Valid Details
    Given I Click on Add New button and wait till progress disapper
    When I Enter EmployeeID Text value with "<ID>"
    And I Click on EmployeeType List hub and wait till progress disapper
    And I Click on EmployeeType List hub and Select "<Employeetype>" and wait till progress disapper
    And I Enter FirstName Text value with "<FirstName>"
    And I Enter LastName Text value with "<LastName>"
    And I Click on PrimaryShift List hub and Select "<PrimaryShift>"
    And I Enter Shop Text value with "<Shop>"
    And I Click on Address Textbox and wait till progress disapper
    And I Enter Address Text value with "<Address>"
    And I Enter City Text value with "<City>"
    And I Click on EmployeeState List hub and Select "<State>"
    And I Enter ZipCode Text value with "<ZipCode>"
    And I Click on Status List hub and Select "<Status>"
    And I Enter Hired Text value with "<Hired>"
    And I Click on EmployeeClassification List hub and Select "<Classification>"
    And I Click on EmployeePaygrade List hub and Select "<PayGrade>"
    And I Click on Save button and wait till progress disapper
    Then EmployeeName should be successfully created with "<FirstName>", "<LastName>"

    Examples: 
      | Button1Name | Employeetype | ID     | FirstName | LastName | PrimaryShift | Shop | Address           | City    | State | ZipCode | Status | Hired     | Classification | PayGrade | Button2Name |
      | Add New     | Employee     | 905091 | Guru      | Nathan   | DAY          |   01 | No 120,Cross Road | Chennai | AB    |  600115 | ACTIVE | 8/30/2016 | CLERK          | A        | Save        |
