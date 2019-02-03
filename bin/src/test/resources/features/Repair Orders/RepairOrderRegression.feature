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
|01  |101-1A  |00QAAUTOUNIT  |1000    |

@CreateStandardRO
@issues:QAAUTO-982
Scenario Outline: Repair Orders Status Change Validation
Given I am in a Repair Order Details Page
And I login to AMS Database
When I Click on ROStatus List hub and Select "<Status>"
And I Click on Save button
Then Selected <FieldName> value should be similar to <Value> where its <WhereField> is StoredValue in ORDERS table

Examples:
|FieldName|Value      |WhereField  |Status    |
|STATUS   |PENDING    |ORDERNUM    |PENDING   |
|STATUS   |COMPLETE   |ORDERNUM    |COMPLETE  |
#|STATUS   |CANCELED   |ORDERNUM    |CANCELED  |
|STATUS   |OPEN       |ORDERNUM    |OPEN      |

@CreateStandardRO
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
|JobCode       |Complaint  |RepairReason |Mechanic        |
|065-002;BROKEN|BROKEN     |ABUSE        |0001QAAUTO1    |

@CreateStandardRO
@issues:QAAUTO-980
Scenario Outline: Add Assignment to Section in RO
Given I am in a Repair Order Details Page
When I Click on Assignment button and wait till multiple progress disapper
And I Click on JobSearchIconAssign button 
And I Click on JobCodeReset button and wait till multiple progress disapper
And I Click on JobSearchListAssignSearch button
And I select <JobCode> from JobCodeInAssignment table
And I Click on JobSearchListAssignSearchOK button 
When I Click on MechanicSearchInAssignButton button
And I Click on MechanicResetSelectInAssignButton button
And I Click on MechanicSearchInAssignListButton button
And I select <Mechanic> from MechanicInAssignment table
And I Click on OkMechanicSelectInAssignButton button and wait till multiple progress disapper
And I Click on SaveAssignment button and wait till multiple progress disapper
And I Click on CloseAssignment button and wait till multiple progress disapper
Then Assignment tab should be displayed 
Examples:
|JobCode         |Mechanic |
|065-002;BROKEN  |0001QAAUTO2  |

@CreateStandardRO
Scenario Outline: Add Lines To Section 
Given I am in a Repair Order Details Page
When I Click on AddLine button
And I Click on LineType List hub and Select "<LineType>"
And I Enter LineDescripion Text value with "<Description>" 
And I Click on PartNumberSearchIcon button 
And I Click on PartNumberListSearch button
And I select <PartNumber> from PartNumberList table
And I Click on PartNumberListSearchOK button and wait till multiple progress disapper
And I Enter PartQuantity Text value with "<Quantity>" 
And I Enter ChargeAmount Text value with "<Amount>" 
And I Click on SaveLine button and wait till multiple progress disapper
Then Line tab should be displayed
Examples:
|LineType      |Description|PartNumber              |Quantity|Amount|
|PART          |Testing    |000001QAAUTO      |2    |180   |1000|


@CreateROTemplate
@issues:QAAUTO-978
Scenario Outline: Create RO Template
Given I am in a Repair Order Details Page
And I Click on SaveAsTemplate button 
And I am in a REPAIR TEMPLATE Page 
And I Enter TemplateName Text value with "<Name>" and wait till multiple progress disapper
And I Click on ShopSearch button and wait till multiple progress disapper
And I Click on ShopListSearch button
And I select <Shop> from Shop table
And I Click on ShopListOk button and wait till multiple progress disapper
And I Enter TemplateDescription Text value with "<Description>" 
And I Click on SaveTemplate button and wait till multiple progress disapper
Then the Select <FieldName> should contain <UpValue> in ORDERTEMPLATE table 
Examples:
|Name           |Shop          |Description        |FieldName  |UpValue        |
|TestTemplate121|01            |0001Test Template  |DESCRIPTION|TestTemplate121|

@CreateROFromROTemplate
@issues:QAAUTO-978
Scenario Outline: Create RO From RO Template
Given I am in a Repair Template Page
When I Click on Create RO button
Then I am in a Repair Order Details Page
And I Click on Save button
Then History tab should be displayed
And Store Order No value
Then the select <FieldName> should contain storedvalue in ORDERS table 
Examples:
|FieldName  |
|ORDERNUM   |

@CreateROFromROTemplate
Scenario Outline: Add Lines To Section in RO created From Template
Given I am in a Repair Order Details Page
When I Click on AddLine button
And I Click on LineType List hub and Select "<LineType>"
And I Enter LineDescripion Text value with "<Description>" 
And I Click on PartNumberSearchIcon button 
And I Click on PartNumberListSearch button
And I select <PartNumber> from PartNumberList table
And I Click on PartNumberListSearchOK button and wait till multiple progress disapper
And I Enter PartQuantity Text value with "<Quantity>" 
And I Enter ChargeAmount Text value with "<Amount>" 
And I Click on SaveLine button and wait till multiple progress disapper
Then Line tab should be displayed
Examples:
|LineType      |Description|PartNumber              |Quantity|Amount|
|PART          |Testing    |000001QAAUTO      |2       |180   |

@CreateROFromROTemplate
Scenario Outline: Error Message validation when part quantity exceeds 
Given I am in a Repair Order Details Page
When I Click on AddLine button
And I Click on LineType List hub and Select "<LineType>"
And I Enter LineDescripion Text value with "<Description>" 
And I Click on PartNumberSearchIcon button
And I Click on PartNumberListSearch button
And I select <PartNumber> from PartNumberList table
And I Click on PartNumberListSearchOK button and wait till multiple progress disapper
And I Enter PartQuantity Text value with "<Quantity>" 
And I Enter ChargeAmount Text value with "<Amount>" 
And I Click on SaveLine button and wait till multiple progress disapper
Then "<Error Message>" should be displayed for PartQuantityExceed
And I Click on PartQuanExceedOK button
And I Click on CancelLine button and wait till multiple progress disapper
Examples:
|LineType      |Description|PartNumber            |Quantity|Amount|Error Message                                                                  |                                                         
|PART          |Testing    |000001QAAUTOQUAN      |2       |180   |Error: Part: 000001QAAUTOQUAN- Requested number of parts exceeds parts on hand.|

@CreateROFromROTemplate
Scenario: Open Repairs Page
Given I am in a Repair Order Details Page
When I Click on TMWLogo List hub
And I Navigate to Orders in firstlevel menu
And I Navigate to Repairs in secondlevel menu
Then Repairs Page should be displayed 

@CreateROFromROTemplate
@issue:QAAUTO-86
Scenario Outline: Close Repair Order RO created From Template
Given I am in a Repairs Page
When I Click on SearchIcon button
And I Click on ResetSearch button and wait till multiple progress disapper
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
|Unit          |Reading|
|00QAAUTOUNIT  |1001015|

@CreateROFromROTemplate
Scenario: Open Invoice Page
Given I am in a Repairs Page
When I Click on TMWLogo List hub
And I Navigate to Orders in firstlevel menu
And I Navigate to Invoices in secondlevel menu
Then Invoices Page should be displayed

@CreateROFromROTemplate
Scenario Outline: Generate and verify Invoice for created RO created From Template
Given I am in a Invoices Page
When I Click on OpenSearchButton button
And I Click on InvoicesResetButton button and wait till multiple progress disapper
And I Click on DateOpened List hub and Select "<Date>"
And I Click on InvoiceSearchButton button
And I Click on Invoice button Which has Stored value
Then Invoice Details Page should be displayed
And RONumber should be displayed with Stored Value
And Store InvoiceNo value
Then the select <FieldName> should contain storedvalue in ORDERS table 

Examples:
|Unit                  |Date     |FieldName  |
|00QAAUTOUNIT          |Today    |ORDERNUM  |

@CreateROFromROTemplateList
Scenario: Open Repairs Page For RO Template List
Given I am in a Invoice Details Page
When I Click on TMWLogo List hub
And I Navigate to Orders in firstlevel menu
And I Navigate to Repairs in secondlevel menu
Then Repairs Page should be displayed

@CreateROFromROTemplateList
Scenario Outline: Select RO Template List 
Given I am in a Repairs Page
When I Click on SearchIcon button
And I Click on ResetSearch button and wait till multiple progress disapper
And I Click on OrderType List hub and Select "<OrderType>"
And I Click on SearchRepairOrder button and wait till small progress disapper
And I Click on Create RO button Which has <Template> value
Then Repair Order Details Page should be displayed 

Examples:
|Template             |OrderType  |
|0001Test Template    |ROTEMPLATE |

@CreateROFromROTemplateList
@issues:QAAUTO-978
Scenario Outline: Create RO From RO Template List
Given I am in a Repair Order Details Page
And I Click on Save button
Then History tab should be displayed
And Store Order No value
Then the select <FieldName> should contain storedvalue in ORDERS table 
Examples:
|FieldName  |
|ORDERNUM   |

@CreateROFromROTemplateList
Scenario Outline: Add Lines To Section RO created From Template List
Given I am in a Repair Order Details Page
When I Click on AddLine button
And I Click on LineType List hub and Select "<LineType>"
And I Enter LineDescripion Text value with "<Description>" 
And I Click on PartNumberSearchIcon button 
And I Click on PartNumberListSearch button
And I select <PartNumber> from PartNumberList table
And I Click on PartNumberListSearchOK button and wait till multiple progress disapper
And I Enter PartQuantity Text value with "<Quantity>" 
And I Enter ChargeAmount Text value with "<Amount>" 
And I Click on SaveLine button and wait till multiple progress disapper
Then Line tab should be displayed
Examples:
|LineType      |Description|PartNumber              |Quantity|Amount|
|PART          |Testing    |000001QAAUTO      |2       |180   |

@CreateROFromROTemplateList
Scenario: Open Repairs Page For Closing RO Created From Template List
Given I am in a Repair Order Details Page
When I Click on TMWLogo List hub
And I Navigate to Orders in firstlevel menu
And I Navigate to Repairs in secondlevel menu
Then Repairs Page should be displayed 

@CreateROFromROTemplateList
@issue:QAAUTO-86
Scenario Outline: Close Repair Order
Given I am in a Repairs Page
When I Click on SearchIcon button
And I Click on ResetSearch button and wait till multiple progress disapper
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
|Unit           |Reading|
|00QAAUTOUNIT   |1001015|

@CreateROFromROTemplateList
Scenario: Open Invoice Page
Given I am in a Repairs Page
When I Click on TMWLogo List hub
And I Navigate to Orders in firstlevel menu
And I Navigate to Invoices in secondlevel menu
Then Invoices Page should be displayed

@CreateROFromROTemplateList
Scenario Outline: Generate and verify Invoice for created RO
Given I am in a Invoices Page
When I Click on OpenSearchButton button
And I Click on InvoicesResetButton button and wait till multiple progress disapper
And I Click on DateOpened List hub and Select "<Date>"
And I Click on InvoiceSearchButton button
And I Click on Invoice button Which has Stored value
Then Invoice Details Page should be displayed
And RONumber should be displayed with Stored Value
And Store InvoiceNo value
Then the select <FieldName> should contain storedvalue in ORDERS table 

Examples:
|Unit          |Date     |FieldName  |
|00QAAUTOUNIT  |Today    |ORDERNUM   |


@CreateVendorRO
Scenario: Open Repair Order
Given I have logged in to AMS
When I Click on TMWLogo List hub
And I Navigate to Orders in firstlevel menu
And I Navigate to Repair Order Details in secondlevel menu
Then Repair Order Details Page should be displayed 

@CreateVendorRO
@issues:QAAUTO-55,QAAUTO-152
Scenario Outline: Create Vendor Repair Order
Given I am in a Repair Order Details Page
When I Click on Shop Search button 
And I Click on ShopList Search button
And I select <Shop> from Shop table
And I Click on ShopListOk button
Then Repair Shop textbox should be successfully updated with <Shop>
When I Click on ROType List hub and Select "<ROType>"
And I Click on VendorSearch button 
And I Click on VendorSearchList button
And I select <Vendor> from Vendor table
And I Click on VendorListOK button
Then Vendor textbox should be successfully updated with <Vendor>
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
And I Click on Save button
Then History tab should be displayed
And Store Order No value


Examples:
|Shop|Customer|Unit           |ROType   |Vendor|Estimate|
|01  |101-1A  |00QAAUTOUNIT   |VENDOR RO|FORDX |10000   |

@CreateVendorRO
@issues:QAAUTO-978
Scenario Outline: Create Sections To Vendor RO
Given I am in a Repair Order Details Page
And I Click on AddSectionButton button 
And I Click on JobCodeSearchButton button 
And I Click on JobCodeSearchListButton button
And I select <JobCode> from JobCode table
And I Click on OkJobCodeSelectButton button and wait till multiple progress disapper
And I Click on Complaint List hub and Select "<Complaint>"
And I Click on RepairReason List hub and Select "<RepairReason>"
And I Click on SaveSectionButton button 
#Then Assignment tab should be displayed
Examples:
|JobCode       |Complaint  |RepairReason |Mechanic   |
|065-002;BROKEN|BROKEN     |ABUSE        |0001QAAUTO1    |

@CreateVendorRO
Scenario Outline: Add Vendor Lines To Section in Vendor RO
Given I am in a Repair Order Details Page
When I Click on AddLine button
And I Click on LineType List hub and Select "<LineType>"
And I Enter LineDescripion Text value with "<Description>" 
And I Click on VendorPartNumberSearchIcon button 
And I Click on VendorPartNumberListSearch button
And I select <PartNumber> from VendorPartNumberList table
And I Click on VendorPartNumberListSearchOK button and wait till multiple progress disapper
And I Enter PartQuantity Text value with "<Quantity>" 
And I Enter ChargeAmount Text value with "<Amount>" 
And I Click on SaveLine button and wait till multiple progress disapper
Then Line tab should be displayed
Examples:
|LineType      |Description|PartNumber              |Quantity|Amount|
|PART          |Testing    |000001QAAUTO      |2       |180   |

@CreateVendorRO
Scenario: Open Repairs Page For Closing Vendor RO
Given I am in a Repair Order Details Page
When I Click on TMWLogo List hub
And I Navigate to Orders in firstlevel menu
And I Navigate to Repairs in secondlevel menu
Then Repairs Page should be displayed 

@CreateVendorRO
@issue:QAAUTO-86
Scenario Outline: Close Vendor Repair Order
Given I am in a Repairs Page
When I Click on SearchIcon button
And I Click on ResetSearch button and wait till multiple progress disapper
And I Enter OrderInput Text value with Stored Value
And I Click on OrderType List hub and Select "<OrderType>"
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
|Unit          |Reading|OrderType|
|00QAAUTOUNIT  |1001014|VENDOR RO|

@CreateVendorRO
Scenario: Open Invoice Page
Given I am in a Repairs Page
When I Click on TMWLogo List hub
And I Navigate to Orders in firstlevel menu
And I Navigate to Invoices in secondlevel menu
Then Invoices Page should be displayed

@CreateVendorRO
Scenario Outline: Generate and verify Invoice for created RO From Template List
Given I am in a Invoices Page
When I Click on OpenSearchButton button
And I Click on InvoicesResetButton button and wait till multiple progress disapper
And I Click on DateOpened List hub and Select "<Date>"
And I Click on InvoiceSearchButton button
And I Click on Invoice button Which has Stored value
Then Invoice Details Page should be displayed
And RONumber should be displayed with Stored Value
And Store InvoiceNo value
Then the select <FieldName> should contain storedvalue in ORDERS table 

Examples:
|Unit          |Date     |FieldName  |
|00QAAUTOUNIT  |Today    |ORDERNUM   |


@CreatePICKLIST
Scenario: Open Pick List Definitions
Given I have logged in to AMS
When I Click on TMWLogo List hub
And I Navigate to Setup in firstlevel menu
And I Navigate to Repair Order Setup in secondlevel menu
And I Navigate to Pick List Definitions in thirdlevel menu 
Then Pick List Definitions Page should be displayed 

@CreatePICKLIST
@issues:QAAUTO-55,QAAUTO-152
Scenario Outline: Create New PickList with Parts and Components 
Given I am in a Pick List Definitions Page
When I Click on AddNewPicklist button
And I Enter PickListDescription Text value with "<PickListDesc>" 
And I Click on PickListOK button
And I Click on AddNewPartButton button
And I Click on ShopSearchIcon button
And I Click on ShopSearchListButton button
And I select <Shop> from Shop table
And I Click on ShopListOkButton button 
And I Click on PartSearchIcon button
And I Click on PartListSearchButton button
And I select <Part> from Parts table
And I Click on PartsListOKButton button 
And I Enter PartQuantity Text value with "<Quantity>" 
And I Click on OKPickListButton button
And I Click on AssignmentsTab button
And I Click on AddAssignmentButton button
And I Click on ComponentSearchButton button
And I Enter ComponentDescription Text value with "<ComponentDesc>" 
And I Click on ComponentListSearchButton button
And I select <Component> from Component table
And I Click on ComponentLIstSearchOKButton button
And I Click on Complaint List hub and Select "<Complaint>"
And I Click on UnitSearchIcon button
And I Click on UnitSearchListButton button
And I select <Unit> from Unit table
And I Click on UnitListSearchOK button and wait till multiple progress disapper
And I Click on AssignmentOKButton button
Then Pick List textbox should be successfully updated with <PickListDesc> 
Then the Select <FieldName> should contain <PickListDesc> in ROPKLIST table 

Examples:
|PickListDesc    |Shop    |Unit          |Part              |Quantity|ComponentDesc|Component  |Complaint|FieldName|
|0001QAAUTO1     |01      |00QAAUTOUNIT  |001QAAUTONONSERIAL|200     |Test         |001-001-044|BROKEN   |DESCRIP  |

@CreateROwithPickList
Scenario: Open Repair Order Details Page for Creating RO With PickList items
Given I have logged in to AMS
When I Click on TMWLogo List hub
And I Navigate to Orders in firstlevel menu
And I Navigate to Repair Order Details in secondlevel menu
Then Repair Order Details Page should be displayed 

@CreateROwithPickList
@issues:QAAUTO-55,QAAUTO-152
Scenario Outline: Create Repair Order having PickList items
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
|Shop|Customer            |Unit           |Estimate|
|01  |101-1A              |00QAAUTOUNIT   |1000    |

@CreateROwithPickList
@issues:QAAUTO-982
Scenario Outline: Repair Orders Status Change Validation having PickList items
Given I am in a Repair Order Details Page
And I login to AMS Database
When I Click on ROStatus List hub and Select "<Status>"
And I Click on Save button
Then Selected <FieldName> value should be similar to <Value> where its <WhereField> is StoredValue in ORDERS table

Examples:
|FieldName|Value      |WhereField  |Status    |
|STATUS   |PENDING    |ORDERNUM    |PENDING   |
|STATUS   |COMPLETE   |ORDERNUM    |COMPLETE  |
#|STATUS   |CANCELED   |ORDERNUM    |CANCELED  |
|STATUS   |OPEN       |ORDERNUM    |OPEN      |

@CreateROwithPickList
@issues:QAAUTO-978
Scenario Outline: Create Sections To RO having PickList items
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
|065-002;BROKEN|BROKEN     |ABUSE        |0001QAAUTO1    |

@CreateROwithPickList
@issues:QAAUTO-980
Scenario Outline: Add Assignment to Section in RO having PickList items
Given I am in a Repair Order Details Page
When I Click on Assignment button and wait till multiple progress disapper
And I Click on JobSearchIconAssign button 
And I Click on JobCodeReset button and wait till multiple progress disapper
And I Click on JobSearchListAssignSearch button
And I select <JobCode> from JobCodeInAssignment table
And I Click on JobSearchListAssignSearchOK button 
When I Click on MechanicSearchInAssignButton button
And I Click on MechanicResetSelectInAssignButton button
And I Click on MechanicSearchInAssignListButton button
And I select <Mechanic> from MechanicInAssignment table
And I Click on OkMechanicSelectInAssignButton button and wait till multiple progress disapper
And I Click on SaveAssignment button and wait till multiple progress disapper
And I Click on CloseAssignment button and wait till multiple progress disapper
Then Assignment tab should be displayed 
Examples:
|JobCode         |Mechanic |
|065-002;BROKEN  |0001QAAUTO2  |

@CreateROwithPickList
Scenario Outline: Add Lines To Section To RO having PickList items
Given I am in a Repair Order Details Page
When I Click on AddLine button
And I Click on LineType List hub and Select "<LineType>"
And I Enter LineDescripion Text value with "<Description>" 
And I Click on PartNumberSearchIcon button 
And I Click on PartNumberListSearch button
And I select <PartNumber> from PartNumberList table
And I Click on PartNumberListSearchOK button and wait till multiple progress disapper
And I Enter PartQuantity Text value with "<Quantity>" 
And I Enter ChargeAmount Text value with "<Amount>" 
And I Click on SaveLine button and wait till multiple progress disapper
Then Line tab should be displayed
Examples:
|LineType      |Description|PartNumber              |Quantity|Amount|
|PART          |Testing    |000001QAAUTO            |2       |180   |

@CreateROwithPickList
Scenario: Open Repairs Page For closing RO created with Pick List Items
Given I am in a Repair Order Details Page
When I Click on TMWLogo List hub
And I Navigate to Orders in firstlevel menu
And I Navigate to Repairs in secondlevel menu
Then Repairs Page should be displayed 

@CreateROwithPickList
@issue:QAAUTO-86
Scenario Outline: Close Repair Order RO created From Picklist
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
|Unit         |Reading|
|00QAAUTOUNIT |1001014|

@ReopenClosedRO
Scenario: Open Repair Order Details Page
Given I have logged in to AMS
When I Click on TMWLogo List hub
And I Navigate to Orders in firstlevel menu
And I Navigate to Repair Order Details in secondlevel menu
Then Repair Order Details Page should be displayed 


@ReopenClosedRO
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
Then Unit textbox should be successfully updated with <Unit>
#When I Click on ExistingRepair Cancel button
And I Click on Save button
Then History tab should be displayed
And Store Order No value


Examples:
|Shop|Unit  |Estimate|
|01  |0017  |10000   |

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
|0017  |7882   |

@ReopenClosedRO
Scenario: Open Re-Open Order Page
Given I am in a Repairs Page
When I Click on TMWLogo List hub
And I Navigate to Setup in firstlevel menu
And I Navigate to Re-Open Order in secondlevel menu
Then Re-Open Order Page should be displayed

@ReopenClosedRO
Scenario Outline: Select Closed RO and Re-Open
Given I am in a Re-Open Order Page
When I Click on ShopList List hub and Select "<Shop>"
And I Click on OrderTypeList List hub and Select "<OrderType>"
And I Enter OrderNumberTextbox Text value with Stored Value
And I Click on Search button
And I select <OrderList> from OrderList table
And I Click on ReOpenOrder button
Then "<System Message1>""<System Message2>" should be thrown for ReopenedOrder for stored value
And Selected <FieldName> value should be similar to <Value> where its <WhereField> is StoredValue in ORDERS table

Examples:
|Shop|OrderType|OrderList|System Message1    |System Message2                  |FieldName|Value      |WhereField  |Status    |
|01  |REPAIR   | 0017    |Repair Order Number|has been successfully Re-Opened. |STATUS   |OPEN       |ORDERNUM    |OPEN      |

@CreateROWithTirePart
Scenario: Open Repair Order Details Page
Given I have logged in to AMS
When I Click on TMWLogo List hub
And I Navigate to Orders in firstlevel menu
And I Navigate to Repair Order Details in secondlevel menu
Then Repair Order Details Page should be displayed 

@CreateROWithTirePart
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

@CreateROWithTirePart
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

@CreateROWithTirePart
Scenario Outline: Add Lines To Section 
Given I am in a Repair Order Details Page
When I Click on AddLine button
And I Click on LineType List hub and Select "<LineType>"
And I Enter LineDescripion Text value with "<Description>"
And I Click on PartNumberSearchIcon button
And I Click on PartNumberListSearch button
And I select <PartNumber> from PartNumberList table
And I Click on PartNumberListSearchOK button and wait till multiple progress disapper
And I Enter PartQuantity Text value with "<Quantity>" 
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