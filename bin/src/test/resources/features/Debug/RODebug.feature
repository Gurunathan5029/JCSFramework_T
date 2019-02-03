@UniqueBrowser 
Feature: RO Regression 

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
|Shop|Customer|Unit  |Estimate|
|01  |101-1A  |0016  |1000   |

@issues:QAAUTO-978
Scenario Outline: Create Sections To RO
Given I am in a Repair Order Details Page
And I Click on AddSectionButton button and wait till multiple progress disapper
And I Click on JobCodeSearchButton button
And I Click on JobCodeSearchListButton button
And I select <JobCode> from JobCode table
And I Click on OkJobCodeSelectButton button and wait till multiple progress disapper
And I Click on Complaint List hub and Select "<Complaint>"
And I Click on RepairReason List hub and Select "<RepairReason>"
When I Click on MechanicSearch button
And I Click on MechanicListReset button
And I Click on MechanicListSearch button
And I select <Mechanic> from Mechanic table
And I Click on MechanicListOk button
And I Click on SaveSectionButton button 
Then Assignment tab should be displayed
Examples:
|JobCode       |Complaint  |RepairReason |Mechanic   |
|000-001;PM     |WORN      |ABUSE        |Guru       |

Scenario Outline: Add Lines To Section 
Given I am in a Repair Order Details Page
When I Click on AddLine button
And I Click on LineType List hub and Select "<LineType>"
And I Enter LineDescripion Text value with "<Description>"
And I Click on PartNumberSearchIcon button
#And I Click on SerializedPartEnable button
And I Click on PartNumberListSearch button
And I select <PartNumber> from PartNumberList table
And I Click on PartNumberListSearchOK button and wait till multiple progress disapper
And I Enter PartQuantity Text value with "<Quantity>" 
#Then SerializedParts tab should be displayed
#When I Drag and Drop TableListItems in SerializedParts Dialog
#|TableListItem   |
#|000QAAUTO9      |
#And I Enter Position Text value with "<Position>" 
#And I Enter offdepth Text value with "<offdepth>" 
#And I Enter ondepth Text value with "<ondepth>"
#And I Enter offpressure Text value with "<offpressure>"
#And I Enter onpressure Text value with "<onpressure>"
#And I Enter removalreason Text value with "<removalreason>"
#And I Enter Destionation Text value with "<Destionation>"
#And I Click on SaveSerail button
And I Enter DOTNumber Text value with "<PartNumber>"
And I Enter DOTNumberQuan Text value with "<Quantity>"
And I Click on SelectDOT button
And I Click on SaveDOT button
And I Enter ChargeAmount Text value with "<Amount>" 
And I Click on SaveLine button and wait till multiple progress disapper
Then Line tab should be displayed


Examples:
|LineType      |Description|PartNumber       |Quantity|Amount|Position|offdepth|ondepth|offpressure|onpressure|removalreason|Destionation|
|PART          |Testing    |000000001TIRE    |1       |180   |LEFT    |10      |10     |10         |10        |PUNCTURE     |Inventory   |