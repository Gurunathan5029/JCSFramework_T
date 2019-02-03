@UniqueBrowser 
@issue:QAAUTO-13 
Feature: Random Selection 

Scenario: Login 
	Given I Login to AMS Application 
		|Username|Password|
		|adminacct|@@admin|
	
Scenario Outline: Build Validation
	Given I have logged in to AMS Default
	When I Click on TMWLogo List hub 
	And I Navigate to <Selected Option> in firstlevel menu 
	And I Navigate to <Sub Option> in secondlevel menu 
	And I Navigate to <subchild option> in thirdlevel menu
	Then <Page Name> Page should be displayed 
	
	Examples: 
		|Selected Option|Sub Option               |subchild option             |Page Name                |
		|Home           |My Profile               |                            |My Profile               |
		|Home           |Read the News            |                            |Read the News            |
		|Home           |Take Survey              |                 		   |Take Survey              |
		|Home           |View Terms & Conditions  |                 		   |View Terms & Conditions  |
		|Security       |Work With Users          |Create User                 |Create User              |
		|Security       |Work With Users          |Mass Create Users           |Mass Create Users        |
		|Security       |Work With Users          |Review Users                |Review Users             |
		|Security       |Work With Users          |Review Roles                |Review Roles             |
		|Security       |Work With Users          |Manage Roles                |Manage Roles             |
		|Security       |Work With Users          |Mass Delete                 |Mass Delete              |
#		|Security       |Work With Users          |Review Profiles             |Review Profiles          |
#		|Security       |Work With Users          |Manage Password Email       |Manage Password Email    |
#		|Security       |Work With Users          |Manage Security Questions   |Manage Security Questions|
#		|Security       |Work With Users          |Review T&C Acceptance       |Review T&C Acceptance    |
#		|Security       |Work With Users          |Upload T&C Document         |Upload T&C Document      |
#		|Security       |Page Security            |Manage Page Definitions     |Manage Page Definitions  |
#		|Security       |Page Security            |Manage Pages                |Manage Pages             |
#		|Security       |Page Security            |Assign Page to Roles        |Assign Page to Roles     |
#		|Security       |Page Security            |Assign Role to Pages        |Assign Role to Pages     |	
#		|Admin	        |News                     |Post News Items             |Post News Items          |	
#		|Admin	        |News                     |Manage News Types           |Manage News Types        |	
#		|Admin	        |News                     |Manage News Items           |Manage News Items        |	
#		|Admin	        |News                     |Approve News Comments       |Approve News Comments    |	
#		|Admin	        |Theme                    |Manage Themes               |Manage Themes            |
#		|Admin	        |Surveys                  |Create Survey               |Create Survey            |
#		|Admin	        |Surveys                  |Manage Survey Types         |Manage Survey Types      |
#		|Admin	        |Usage Reports            |Monitor All Usage           |Monitor All Usage        |
#		|Admin	        |Usage Reports            |View Graph by Page          |View Graph by Page       |
#		|Admin	        |Usage Reports            |View Graph by Role          |View Graph by Role       |
#		|Admin	        |Logging                  |Log Viewer                  |Log Viewer               |		
#		|Configuration  |Grid Configuration Maintenance|                       |Grid Configuration Maintenance|
#		|Configuration  |Settings Manager         |                            |Settings Manager         |
#		|Configuration  |Report Configuration     |                            |Report Configuration     |
#		|Configuration  |Menu Maintenance         |                            |Menu Maintenance         |
#		|Configuration  |Logging Configuration    |                            |Logging Configuration    |
#		|Configuration  |Menu Localization        |                            |Menu Localization        |
#		|Masters        |Company                  |                            |Company                  |
#		|Masters        |Customers                |                            |Customers                |
#		|Masters        |Employees                |                            |Employees                |
#		|Masters        |Parts Catalog            |                            |Parts Catalog            |		
#		|Masters        |Shops                    |                            |Shops                    |
#		|Masters        |Units                    |                            |Units                    |
#		|Masters        |Vendor Parts             |                            |Vendor Parts             |
#		|Masters        |Vendors                  |                            |Vendors                  |
#		|Orders         |Campaign Create          |                            |Campaign Create          |
#		|Orders         |Campaigns                |                            |Campaigns                |
#		|Orders         |Credit Memos             |                            |Credit Memos             |
#		|Orders         |Delivery Receipts        |                            |Delivery Receipts        |
#		|Orders         |Estimate Details         |                            |Estimate Details         |
#		|Orders         |Estimates                |                            |Estimates                |
#		|Orders         |Fuel Tickets             |                            |Fuel Tickets             |
#		|Orders         |Indirect Charges         |                            |Indirect Charges         |
#		|Orders         |Inspections              |                            |Inspections              |
#		|Orders         |Invoice Details          |                            |Invoice Details          |
#		|Orders         |Invoices                 |                            |Invoices                 |
#		|Orders         |Potential Warranties     |                            |Potential Warranties     |
#		|Orders         |Purchase Create          |                            |Purchase Create          |
#		|Orders         |Purchases                |                            |Purchases                |
#		|Orders         |Quick Quote              |                            |Quick Quote              |
#		|Orders         |Repair Order Details     |                            |Repair Order Details     |
#		|Orders         |Repair Template          |                            |Repair Template          |
#		|Orders         |Repairs                  |                            |Repairs                  |
#		|Orders         |Retail Invoice           |                            |Retail Invoice           |
#		|Orders         |TMT First Step           |                            |TMT First Step           |
#		|Orders         |Warranty Claim           |                            |Warranty Claim           |
#		|Orders         |Warranty Claims          |                            |Warranty Claims          |
#		|Inventory      |Part Fee/Tax Definition  |                            |Part Fee/Tax Definition  |
#		|Inventory      |Parts Request            |                            |Parts Request            |
#		|Inventory      |Parts Transfer           |                            |Parts Transfer           |
#		|Inventory      |Physical Inventory       |                            |Physical Inventory       |
#		|Inventory      |Requisition List         |                            |Requisition List         |
#		|Activities     |Accounting               |Accounting                  |Accounting               |
#		|Activities     |Accounting               |IES Accounting              |IES Accounting           |
#		|Activities     |Employee Dashboard       |Edit Employee Information   |Edit Employee Information|
#		|Activities     |Payroll                  |Payroll Approval            |Payroll Approval         |
#		|Activities     |Payroll                  |Production-Based Pay        |Production-Based Pay     |
#		|Activities     |Payroll                  |View Payroll                |View Payroll             |
#		|Activities     |Tires                    |Tire Configuration          |Tire Configuration       |
#		|Activities     |Tires                    |Tire Review                 |Tire Review              |
#		|Activities     |Barcode Labels           |                            |Barcode Labels           |
#		|Activities     |Clone Unit               |                            |Clone Unit               |
#		|Activities     |Daily Code Generator     |                            |Daily Code Generator     |
#		|Activities     |Document Viewer          |                            |Document Viewer          |
#		|Activities     |Fixed Cost               |                            |Fixed Cost               |
#		|Activities     |Fuel Data Imports        |                            |Fuel Data Imports        |
#		|Activities     |Interactive Workstation  |                            |Interactive Workstation  |
#		|Activities     |Meter Readings           |                            |Meter Readings           |
#		|Activities     |Parts Bid Price Update   |                            |Parts Bid Price Update   |
#		|Activities     |Parts Price Update       |                            |Parts Price Update       |
#		|Activities     |Parts Reorder Point      |                            |Parts Reorder Point      |
#		|Activities     |Parts Search By Shop     |                            |Parts Search By Shop     |
#		|Activities     |Parts Workstation        |                            |Parts Workstation        |
#		|Activities     |PO Approval              |                            |PO Approval              |
#		|Activities     |PO Invoice Matching      |                            |PO Invoice Matching      |
#		|Activities     |RO Approval              |                            |RO Approval              |
#		|Activities     |Shop Planner             |                            |Shop Planner             |
#		|Activities     |Shop Scheduler           |                            |Shop Scheduler           |
#		|Activities     |The DAWG Configuration   |                            |The DAWG Configuration   |
#		|Activities     |Unit In Inventory        |                            |Unit In Inventory        |
#		|Setup          |Options                  |Application Options         |Application Options      |
#		|Setup      	|Options                  |Customer Options            |Customer Options         |
#		|Setup      	|Options                  |Integration Options         |Integration Options      |
#		|Setup      	|Options                  |Shop Options                |Shop Options        	 |
#		|Setup     	 	|Options                  |User Options                |User Options        	 |
#		|Setup     	 	|Options                  |User Preferences            |User Preferences         |
#		|Setup      	|Payment Processing       |Card Reader Types           |Card Reader Types        |
#		|Setup     	 	|Payment Processing       |Processor                   |Processor        		 |
#		|Setup      	|Payment Processing       |Terminals                   |Terminals        		 |
#		|Setup      	|Repair Order Setup       |Job Code Definitions        |Job Code Definitions     |
#		|Setup      	|Repair Order Setup       |Pick List Definitions       |Pick List Definitions    |
#		|Setup      	|Repair Order Setup       |Standard Services           |Standard Services        |
#		|Setup      	|Retail                   |Selling Restrictions        |Selling Restrictions     |
#		|Setup     		|Approval Levels          |                            |Approval Levels        	 |
#		|Setup     		|Auto Bill Definitions     |                           |Auto Bill Definitions    |
#		|Setup     		|Auto Fleet Definition    |                            |Auto Fleet Definition    |
#		|Setup     		|Bay Configuration        |                            |Bay Configuration        |
#		|Setup     		|Calender Setup           |                            |Calender Setup        	 |
#		|Setup     		|Component Specifications |                            |Component Specifications |
#		|Setup     		|Diagnostic Definitions   |                            |Diagnostic Definitions   |
#		|Setup     		|Discounts                |                            |Discounts         		 |
#		|Setup     		|Fuel Import Setup        |                            |Fuel Import Setup        |
#		|Setup     		|Integration Tool Kit REST|                            |Integration Tool Kit REST|
#		|Setup     		|Integration Tool Kit Test|                            |Integration Tool Kit Test|
#		|Setup     		|Meters, Fluids, PMs Setup|                            |Meters, Fluids, PMs Setup|
#		|Setup     		|Module Licenses          |                            |Module Licenses - SERVICE CENTER|
#		|Setup     		|Pay Grades               |                            |Pay Grades        		 |
#		|Setup     		|Price Tables             |                            |Price Tables        	 |
#		|Setup     		|Promotion Definitions    |                            |Promotion Definitions    |
#		|Setup     		|Re-Open Order            |                            |Re-Open Order        	 |
#		|Setup     		|Shop Restrictions        |                            |Shop Restrictions        |
#		|Setup     		|Standard Messages        |                            |Standard Messages        |
#		|Setup     		|System Setup             |                            |System Setup        	 |
#		|Setup    		|Tax Rates & Fees         |                            |Tax Rates & Fees         |
#		|Setup     		|Tools Catelog            |                            |Tools Catelog            |
#		|Setup     		|Units of Measure         |                            |Units of Measure       	 |
#		|Setup     		|User Fields              |                            |User Fields        		 |
#		|Setup     		|Work Shifts              |                            |Work Shifts       		 |		
#		|Tiles     		|Parts Manager Tile       |                            |01 Parts Manager Tile 		 |
#		|Tiles     		|Service Writer Tile      |                            |01 Service Writer Tile  	 |
#		|Tiles     		|Shop Manager Tile        |                            |01 Shop Manager Tile    	 |
#		|Reports    	|Reports - SSRS           |Report Setup                |Report Setup      		 |
#		|Reports     	|Reports - SSRS           |SSRS Report Viewer          |SSRS Report Viewer       |
#		|Reports     	|Reports - SQL            |Manage Reports              |Manage Reports      	 |
#		|Reports     	|Reports - SQL            |Manage Report Variables     |Manage Report Variables  |
#		|Reports     	|Reports - SQL            |Manage Report Forms         |Manage Report Forms      |
#		|Reports     	|Reports - SQL            |Report Viewer               |Report Viewer      		 |	
#		|Reports     	|Report Scheduler         |                            |Report Scheduler      	 |	
#		|Dev     		|POSTransactionTestPage   |                            |POSTransactionTestPage   |	
#		|Dev     		|Developer Example        |                            |Developer Example      	 |	
		
		
		
		
		
		
       