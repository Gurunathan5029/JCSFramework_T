@UniqueBrowser 
Feature: IWS

Scenario: Login
    Given I Login to AMS Application
    |Username|Password|
	|adminacct|@@admin|
	
Scenario: Open IWS Page
Given I have logged in to AMS
When I Click on TMWLogo List hub
And I Navigate to Activities in firstlevel menu
And I Navigate to Interactive Workstation in secondlevel menu
Then Interactive Workstation Page should be displayed 

Scenario: Launch IWS as StandAlone
Given I am in a Interactive Workstation Page
When I execute IWS Ranorex Smoke Test
