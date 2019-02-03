@UniqueBrowser 
Feature: RO Regression 

@CreateStandardRO
Scenario: Login
    Given I Login to AMS Application
    |Username|Password|
	|adminacct|@@admin|
	
Scenario: Open Repair Order Details Page
Given I have logged in to AMS
When I Click on TMWLogo List hub
And I Navigate to Orders in firstlevel menu
And I Navigate to Repair Order Details in secondlevel menu
Then Repair Order Details Page should be displayed 

@CreateStandardRO
@issues:QAAUTO-55,QAAUTO-152
Scenario Outline: Create Repair Order
Given I am in a Repair Order Details Page
When I Click on Shop Search button 
And I Click on ShopList Search button
And I select <Shop> from Shop table
And I Click on ShopListOk button
Then Repair Shop textbox should be successfully updated with <Shop>
When I Click on Unit Search button 
And I Click on UnitList Search button 
And I select <Unit> from Unit table
And I Click on UnitListOk button 
When I Click on Customer Search button 
And I Click on CustomerList Search button
And I select <Customer> from Customer table
And I Click on CustomerListOk button
Then Customer textbox should be successfully updated with <Customer>
Then Unit textbox should be successfully updated with <Unit>
And I Enter CustomerEstimate Text value with "<Estimate>" 
#When I Click on ExistingRepair Cancel button
And I Click on Save button
Then History tab should be displayed
And Store Order No value


Examples:
|Shop|Customer|Unit          |Estimate|
|01  |001-01  |0016          |1000    |

@ReopenClosedRO
Scenario: Open Repairs Page
Given I am in a Repair Order Details Page
When I Click on TMWLogo List hub
And I Navigate to Orders in firstlevel menu
And I Navigate to Repairs in secondlevel menu
Then Repairs Page should be displayed 

@ReopenClosedRO
@issue:QAAUTO-86
Scenario Outline: Close Repair Order RO 
Given I am in a Repairs Page
When I Click on SearchIcon button
And I Click on ResetSearch button
And I Enter OrderInput Text value with Stored Value
And I Click on SearchRepairOrder button 
And I Click on Complete Order button Which has <Unit> value
And I Click on CloseOrderOk button and wait till multiple progress disapper
And I Click on Close Order button Which has <Unit> value
And I Enter MeterReading Text value with "<Reading>"
And I Click on CloseOrderOk button 
And I Click on CloseOrderOk button 
And I Click on CloseOrderOk button 
Then Repairs Page should be displayed 

Examples:
|Unit  |Reading|
|0016  |7882   |