@UniqueBrowser 
@issue:QAAUTO-13 
Feature: Smoke Test 

Scenario: Login 
	Given I Login to AMS Application 
		|Username|Password|
		|adminacct|@@admin|
		
Scenario: Open SSRS Report Viewer
Given I have logged in to AMS
When I Click on TMWLogo menu hub
And I Navigate to Reports in firstlevel menu
And I Navigate to Reports - SSRS in secondlevel menu
And I Navigate to SSRS Report Viewer in thirdlevel menu
Then SSRS Report Viewer Page should be displayed 

Scenario Outline: Report Generation Without Inputs
Given I am in a SSRS Report Viewer Page
When I Click on Reports menu hub
And I Navigate to Standard Reports in firsttree menu 
And I Navigate to <SubReport Option> in secondtree menu 
And I Navigate to <SubChildReport Option> in thirdtree menu
And I Navigate to <Report> in Listtree and wait till progress disapper
And I Click on RunReport button and wait till progress disapper
Then Report Title should be displayed with <ReportTitle> 

Examples:
|SubReport Option         |SubChildReport Option    |Report                                     |ReportTitle                                |
|AMS SSRS Report Library  |Accounting               |Account Analysis                           |Account Analysis                           | 
|AMS SSRS Report Library  |Accounting               |Account Disbursement Analysis              |Account Disbursement Analysis              |
|AMS SSRS Report Library  |Accounting               |Accounting Export Batch Detail             |Accounting Export Batch Detail             |
|AMS SSRS Report Library  |Accounting               |Current Book Value by Inventory Account    |Current Book Value by Inventory Account    |
|AMS SSRS Report Library  |Customers                |Customer Gross Profit                 	    |Customer Gross Profit                      |
|AMS SSRS Report Library  |Customers                |Customer Invoices Listing				    |Customer Invoices Listing                  |
|AMS SSRS Report Library  |Customers                |Customer Listing                           |Customer Listing						    |
|AMS SSRS Report Library  |Customers                |Customer Unit Life Cycle Cost              |Customer Unit Life Cycle Cost              |
|AMS SSRS Report Library  |Customers                |Customer Units Listing                     |Customer Units Listing                     |
|AMS SSRS Report Library  |Customers                |Parts Gross Profit                         |Parts Gross Profit Summary                 |
|AMS SSRS Report Library  |Customers                |Sales Cost and Gross Profit                |Sales Cost and Gross Profit                |
|AMS SSRS Report Library  |Customers                |Trend Monthly Sales                        |Monthly Sales Report                       |
|AMS SSRS Report Library  |Customers                |Customer Unit Component Cost Report        |Customer Unit Component Cost Report        |
|AMS SSRS Report Library  |Customers                |Customer Cost Summary Report               |Customer Cost Summary Report               |
|AMS SSRS Report Library  |Customers                |Customer Unit Component Cost Summary Report|Customer Unit Component Cost Summary Report|
|AMS SSRS Report Library  |Customers                |Customer Unit Cost of Ownership Report     |Customer Unit Cost of Ownership Report     |
|AMS SSRS Report Library  |Customers                |Customer Unit Reason for Repair Analysis   |Customer Unit Reason for Repair Analysis   |
|AMS SSRS Report Library  |Customers                |Invoice Billing                            |Invoice Billing Report                     |
|AMS SSRS Report Library  |Customers                |Selling Restrictions                       |Selling Restrictions                       |
|AMS SSRS Report Library  |Employees                |Approved Time Cards                        |Approved Time Cards                        |
|AMS SSRS Report Library  |Employees                |Employee Indirect Labor Log                |Employee Indirect Labor Log                |
|AMS SSRS Report Library  |Employees                |Employee Labor Time Log                    |Employee Labor Time Log                    |
|AMS SSRS Report Library  |Employees                |Employee Listing                           |Employee Listing                           |
|AMS SSRS Report Library  |Employees                |Employee Master                            |Employee Master                            |
|AMS SSRS Report Library  |Employees                |Employee Time Analysis                     |Employee Time Analysis                     |
|AMS SSRS Report Library  |Employees                |Payroll Time Exported                      |Payroll Time Exported                      |
|AMS SSRS Report Library  |Employees                |TINA Employee Time Card                    |TINA Employee Time Card                    |
|AMS SSRS Report Library  |Employees                |Mechanic Actual Vs Billed Hours            |Mechanic Actual Vs Billed Hours            |
|AMS SSRS Report Library  |Employees                |Driver Cost Detail Report                  |Driver Cost Detail Report                  |
|AMS SSRS Report Library  |Employees                |Driver Cost Summary Report                 |Driver Cost Summary Report                 |
|AMS SSRS Report Library  |Employees                |Estimated Time Vs Actual Time              |Estimated Time Vs Actual Time              |
|AMS SSRS Report Library  |Fixed Cost Reports       |Fixed Cost                                 |Fixed Cost Report                          |
|AMS SSRS Report Library  |Orders                   |Invalid Order Numbers                      |Invalid Order Numbers                      |
|AMS SSRS Report Library  |Orders                   |Job Codes                                  |Job Codes                                  |
|AMS SSRS Report Library  |Orders                   |Job Codes by Shop                          |Job Codes by Shop                          |
|AMS SSRS Report Library  |Orders                   |Order Inquiries_Campaign                   |Order Inquiries - Campaign                 |
|AMS SSRS Report Library  |Orders                   |Order Inquiries_Fuel Ticket                |Order Inquiries - Fuel Tickets             |
|AMS SSRS Report Library  |Orders                   |Order Inquiries_Indirects                  |Order Inquiries - Indirects                |
|AMS SSRS Report Library  |Orders                   |Order Inquiries_Purchase Orders            |Order Inquiries - Purchase Orders          |
|AMS SSRS Report Library  |Orders                   |Order Inquiries_Repair Orders              |Order Inquiries - Repair Orders            |
|AMS SSRS Report Library  |Orders                   |Order Inquiries_Transfers                  |Order Inquiries - Transfers                |
|AMS SSRS Report Library  |Orders                   |Order Inquiries_Warranty Claims            |Order Inquiries - Warranty Claims          |
|AMS SSRS Report Library  |Orders                   |Job Codes by Component                     |Job Codes by Component                     |
|AMS SSRS Report Library  |Orders                   |Order Inquiries_Invoice Orders             |Order Inquiries - Invoices                 |
|AMS SSRS Report Library  |Part Inventory           |Inventory Adjustment Listing               |Inventory Adjustment Listing               |
|AMS SSRS Report Library  |Part Inventory           |Inventory Month-End Balances               |Inventory Month-End Balances               |
|AMS SSRS Report Library  |Part Inventory           |Part Inventory Summary by Cost             |Part Inventory Summary by Cost             |
|AMS SSRS Report Library  |Part Inventory           |Part Inventory Summary by Shop             |Part Inventory Summary By Shop             |
|AMS SSRS Report Library  |Part Inventory           |Parts Catalog Kits Listing                 |Parts Catalog Kits Listing                 |
|AMS SSRS Report Library  |Part Inventory           |Parts Catalog Listing                      |Parts Catalog Listing                      |
|AMS SSRS Report Library  |Part Inventory           |Parts Catalog Substitute Part List         |Parts Catalog Substitute Part List         |
|AMS SSRS Report Library  |Part Inventory           |Parts Catalog Superseded Parts List        |Parts Catalog Superseded Parts List        |
|AMS SSRS Report Library  |Part Inventory           |Parts Pending on Orders                    |Parts Pending on Orders                    |
|AMS SSRS Report Library  |Part Inventory           |Parts Usage                                |Parts Usage                                |
|AMS SSRS Report Library  |Part Inventory           |Physical Inventory Adjustment Log          |Physical Inventory Adjustment Log          |
|AMS SSRS Report Library  |Part Inventory           |Parts Pending on Orders                    |Parts Pending on Orders                    |
|AMS SSRS Report Library  |Part Inventory           |Historical Part Inventory Listing          |Historical Part Inventory Listing          |
|AMS SSRS Report Library  |Part Inventory           |Part Inventory Kit Listing                 |Part Inventory Kit Listing                 |
|AMS SSRS Report Library  |Part Inventory           |Part Inventory Listing                     |Part Inventory Listing                     |
|AMS SSRS Report Library  |Part Inventory           |Part Inventory Listing by Bin              |Part Inventory Listing By Bin              |
|AMS SSRS Report Library  |Part Inventory           |Part Inventory Listing by Cost             |Part Inventory Listing By Cost             |
|AMS SSRS Report Library  |Part Inventory           |Part Inventory Summary by Part Type        |Part Inventory Summary By Part Type        |
|AMS SSRS Report Library  |Part Inventory           |Part Reorder Point Analysis                |Part Reorder Point Analysis                |
|AMS SSRS Report Library  |Period Close           	|Period Close Account Analysis              |Period Close: Account Analysis             |
|AMS SSRS Report Library  |Period Close           	|Period Close Fixed Cost	                |Period Close: Fixed Cost	                |
|AMS SSRS Report Library  |Period Close           	|Period Close Invoice Analysis              |Period Close: Invoice Analysis             |
|AMS SSRS Report Library  |Period Close           	|Period Close Non-Inventory Analysis        |Period Close: Non-Inventory Analysis       |
|AMS SSRS Report Library  |Period Close           	|Period Close Purchase Orders               |Period Close: Purchase Order Analysis      |
|AMS SSRS Report Library  |Purchasing           	|Division Transaction Summary               |Division Transaction Summary               |
|AMS SSRS Report Library  |Purchasing           	|Part Purchase History                      |Part Purchase History                      |
|AMS SSRS Report Library  |Purchasing           	|Purchase Order Accrual                     |Purchase Order Accrual                     |
|AMS SSRS Report Library  |Purchasing           	|Comdata Transaction Report                 |Comdata Transaction Report                 |
|AMS SSRS Report Library  |Purchasing           	|PO Accrual Summary                         |Daily Summary by Account                   |
|AMS SSRS Report Library  |Shops                	|Bill Rate by Shop and Unit Type            |Bill Rate by Shop and Unit Type            |
|AMS SSRS Report Library  |Shops                	|Shop Component Cost Analysis               |Shop Component Cost Analysis               |
|AMS SSRS Report Library  |Shops                	|Shop Cost Analysis                         | Shop Cost Analysis                        |
|AMS SSRS Report Library  |Shops                	|Shop Foreign Repair Analysis               |Shop Foreign Repair Analysis               |
|AMS SSRS Report Library  |Shops                	|Shop Labor Log                             |Shop Labor Log                             |
|AMS SSRS Report Library  |Shops                	|Shop Listing                               |Shop Listing                               |
|AMS SSRS Report Library  |Shops                	|Shop Reason for Repair Analysis            |Shop Reason for Repair Analysis            |
|AMS SSRS Report Library  |Shops                	|Shop Scheduled Maintenance Performance     |Scheduled Maintenance Performance          |
|AMS SSRS Report Library  |Shops                	|Margin Report by Charge Category and Customer Type|Margin Report By Charge Category and Customer Type|
|AMS SSRS Report Library  |Shops                	|Daily Invoice Detail Report                |Daily Invoice Detail Report                |
|AMS SSRS Report Library  |Shops                	|Daily Closed Invoice Report                |Daily Closed Invoice Report                |
|AMS SSRS Report Library  |Shops                	|Shift Daily Cash Drawer Worksheet          |Shift/Daily Cash Drawer Worksheet          |
|AMS SSRS Report Library  |Shops                	|Invoice DR Status Report                   |Invoice DR Status Report                   |
|AMS SSRS Report Library  |Sys Mgr Reports          |Codekeys                                   |Codekeys                                   |
|AMS SSRS Report Library  |Sys Mgr Reports          |Diagnostics                                |Diagnostics                                |
|AMS SSRS Report Library  |Sys Mgr Reports          |Master Tools List                          |Master Tools List                          |
|AMS SSRS Report Library  |Sys Mgr Reports          |Diagnostic Definitions                     |Diagnostic Definitions                     |
|AMS SSRS Report Library  |Sys Mgr Reports          |Integration Error Messages                 |Integration Error Messages                 |
|AMS SSRS Report Library  |Tires                    |Tire Catalog Listing                       |Tire Catalog Listing                       |
|AMS SSRS Report Library  |Tires                    |Tire Change Report                         |Tire Change Report                         |
|AMS SSRS Report Library  |Tires                    |Tire Sales By Vendor                       |Tire Sales By Vendor Report                |
|AMS SSRS Report Library  |Units                    |Age of Units                               |Age of Units                               |
|AMS SSRS Report Library  |Units                    |PM Costs                                   |PM Costs                                   |
|AMS SSRS Report Library  |Units                    |PMs Due                                    |PMs Due                                    |
|AMS SSRS Report Library  |Units                    |Unit Chronic Repairs                       |Unit Chronic Repairs                       |
|AMS SSRS Report Library  |Units                    |Unit Component Cost                        |Unit Component Cost                        |
|AMS SSRS Report Library  |Units                    |Unit Component Cost Summary                |Unit Component Cost Summary                |
|AMS SSRS Report Library  |Units                    |Unit Cost Detail                           |Unit Cost Detail                           |
|AMS SSRS Report Library  |Units                    |Unit Cost Summary                          |Unit Cost Summary                          |
|AMS SSRS Report Library  |Units                    |Unit Down Time Analysis                    |Unit Down Time Analysis                    |
|AMS SSRS Report Library  |Units                    |Unit Fuel Ticket History                   |Unit Fuel Ticket History                   |
|AMS SSRS Report Library  |Units                    |Unit Fuel Utilization                      |Unit Fuel Utilization Detail               |
|AMS SSRS Report Library  |Units                    |Unit Inventory                             |Unit Inventory                             |
|AMS SSRS Report Library  |Units                    |Unit Licenses Due                          |Unit Licenses Due                          |
|AMS SSRS Report Library  |Units                    |Unit Life Cycle Cost                       |Unit Life Cycle Cost                       |
|AMS SSRS Report Library  |Units                    |Unit Master                                |Unit Master                                |
|AMS SSRS Report Library  |Units                    |Unit Master History                        |Unit Master History                        |
|AMS SSRS Report Library  |Units                    |Unit Parts Usage Listing                   |Unit Parts Usage Listing                   |
|AMS SSRS Report Library  |Units                    |Unit PM Master Listing                     |Unit PM Master Listing                     |
|AMS SSRS Report Library  |Units                    |Unit Repair Costs by Repair Shop           |Unit Repair Costs by Repair Shop           |
|AMS SSRS Report Library  |Units                    |Unit Cost By Utilization Report            |Unit Cost By Utilization Report            |
|AMS SSRS Report Library  |Units                    |Unit Cost of Ownership Report              |Unit Cost of Ownership Report              |
|AMS SSRS Report Library  |Units                    |Unit Repair Inquiry                        |Unit Repair Inquiry                        |
|AMS SSRS Report Library  |Units                    |Unit Cost Summary by Month Report          |Unit Cost Summary by Month Report          |
|AMS SSRS Report Library  |Units                    |Unit Reason for Repair Analysis            |Unit Reason for Repair Analsysis           |
|AMS SSRS Report Library  |Units                    |Unit Down Time Analysis Detailed           |Unit Down Time Analysis Detailed           |
|AMS SSRS Report Library  |Value Engineering        |Maintenance System Cost		            |Maintenance System Cost					|
|AMS SSRS Report Library  |Value Engineering        |Tire Maintenance Costs			            |Tire Maintenance Costs						|
|AMS SSRS Report Library  |Vendors			        |Back Order Purchase			            |Back Order Purchase						|
|AMS SSRS Report Library  |Vendors			        |PO Accrual						            |PO Accrual									|
|AMS SSRS Report Library  |Vendors			        |Vendor Listing					            |Vendor Listing								|
|AMS SSRS Report Library  |Vendors			        |Vendor Master					            |Vendor Master								|
|AMS SSRS Report Library  |Vendors			        |Vendor Part Listing			            |Vendor Part Listing						|
|AMS SSRS Report Library  |Vendors			        |Vendor Part Supplier			            |Vendor Part Supplier						|
|AMS SSRS Report Library  |Vendors			        |Vendor Repair Cost Detail		            |Vendor Repair Cost Detail					|
|AMS SSRS Report Library  |Vendors			        |Vendor Repair Cost Summary		            |Vendor Repair Cost Summary					|
|AMS SSRS Report Library  |Vendors			        |Vendor RO Accrual				            |Vendor RO Accrual							|
|AMS SSRS Report Library  |Vendors			        |Vendor Purchases				            |Vendor Purchases							|
|AMS SSRS Report Library  |Warranty			        |Units Warranty Status			            |Units Warranty Status						|
|AMS SSRS Report Library  |Warranty			        |After-Market Potential Warranty Claim      |After-Market Potential Warranty Claim		|
|AMS SSRS Report Library  |Warranty			        |OEMExtended Potential Warranty	            |OEMExtended Potential Warranty				|
|AMS SSRS Report Library  |Warranty			        |Unit Warranty Claims			            |Unit Warranty Claims						|
|AMS SSRS Report Library  |Warranty			        |Units With After-Market Part Warranties    |Units With After-Market Part Warranties	|
|AMS SSRS Report Library  |Warranty			        |Unit Components Warranty Status Report     |Unit Components Warranty Status Report		|



Scenario Outline: Report Generation With Inputs
Given I am in a SSRS Report Viewer Page
When I Click on Reports List hub
And I Navigate to Standard Reports in firsttree menu 
And I Navigate to <SubReport Option> in secondtree menu 
And I Navigate to <SubChildReport Option> in thirdtree menu
And I Navigate to <Report> in Listtree and wait till progress disapper
And I Enter <TextBox> Text value with "<TextBoxValue>"
And I Click on RunReport button and wait till progress disapper
Then Report Title should be displayed with <ReportTitle> 
Examples:
 |SubReport Option         |SubChildReport Option    |Report                       |TextBox        |TextBoxValue     |ReportTitle                  |
 |AMS SSRS Report Library  |Customers                |Customer Master              |CustomerID     |001              |Customer Master              |
 |AMS SSRS Report Library  |Customers                |National Account Requirements|IntegrationName|ALL              |National Account Requirements|