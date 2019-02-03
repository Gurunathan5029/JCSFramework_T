@UniqueBrowser 
Feature: RO Regression 

Scenario: Login
    Given I Login to AMS Application
    |Username|Password|
	|adminacct|@@admin|
	
Scenario: Open Repair Order
Given I have logged in to AMS
When I Click on TMWLogo List hub
And I Navigate to Orders in firstlevel menu
And I Navigate to Repair Order Details in secondlevel menu
Then Repair Order Details Page should be displayed 

@issues:QAAUTO-55,QAAUTO-152
Scenario Outline: Create Repair Order
Given I am in a Repair Order Details Page
When I Click on Shop Search button
And I Click on ShopList Search button
And I select <Shop> from Shop table
And I Click on ShopListOk button
Then Repair Shop textbox should be successfully updated with <Shop>
When I Click on Customer Search button
And I Click on CustomerList Search button
And I select <Customer> from Customer table
And I Click on CustomerListOk button
Then Customer textbox should be successfully updated with <Customer>
When I Click on Unit Search button 
And I Click on UnitList Search button 
And I select <Unit> from Unit table
And I Click on UnitListOk button 
Then Unit textbox should be successfully updated with <Unit>
#When I Click on ExistingRepair Cancel button
And I Click on Save button
Then History tab should be displayed
And Store Order No value


Examples:
|Shop|Customer|Unit  |
|01  |1       |1010  |

Scenario Outline: Repair Orders Status Change Validation
Given I am in a Repair Order Details Page
And I login to AMS Database
When I Click on ROStatus List hub and Select "<Status>"
And I Click on Save button
Then Selected <FieldName> value should be similar to <Value> where its <WhereField> is StoredValue in ORDERS table

Examples:
|FieldName|Value      |WhereField  |WhereValue|Status    |
|STATUS   |PENDING    |ORDERNUM    |97527     |PENDING   |
|STATUS   |COMPLETE   |ORDERNUM    |97527     |COMPLETE  |
|STATUS   |CANCELED   |ORDERNUM    |97527     |CANCELED  |
|STATUS   |OPEN       |ORDERNUM    |97527     |OPEN      |

 