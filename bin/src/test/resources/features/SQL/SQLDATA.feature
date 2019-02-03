Feature: SQL Validations
Scenario: Login
    Given I Login to AMS Application
    |Username|Password|
	|adminacct|@@admin|
	
Scenario: Employee Creation Form Verification 
	Given I am in a AMS Default Page 	
	When I Click on Employees button
	And I Click on Add New button and wait till progress disapper
	Then I Click on Cancel button and wait till progress disapper

Scenario Outline: Employee Creation With SQL Comparison
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
	And Compare created EMPLOYEE details with SQL	
	
	Examples: 
	   |Button1Name|Employeetype|ID       |FirstName|LastName   |PrimaryShift|Shop|Address          |City   |State  |ZipCode|Status|Hired    |Classification|PayGrade |Button2Name|
	   |Add New    |Employee    |9751977   |Guru     |Testing    |DAY         |01  |No 120,Cross Road|Chennai|AB     |600115 |ACTIVE|8/30/2016|CLERK         |A       |Save       |
	   
Scenario Outline: Adding Records To Database
Given I login to AMS Database
When I add data to EMPLOYEE table with unique <EMPID> value
And  I add data to ORDERS table with unique <ORDERID> value
And I add data to ORDERASSMT table with unique <ASSIGNID> value

Examples:
|EMPID |ORDERID|ASSIGNID|
|100203|200303 |300403  |

Scenario Outline: DBCheck
Given I have logged in to AMS
Then the Selected <FieldName> value should be similar to <Value> where its <WhereField> is <WhereValue> in EMPLOYEE table 
And I Update the <FieldName> value to <UpValue> where its <WhereField> is <WhereValue> in EMPLOYEE table
And the Select <FieldName> should contain <UpValue> in EMPLOYEE table 
And Delete in EMPLOYEE table where its <FieldName> is <UpValue> 

Examples:
|FieldName|Value|WhereField|WhereValue|UpValue|
|FIRSTNAME|Guru |EMPID     |97527     |GuruN  |
