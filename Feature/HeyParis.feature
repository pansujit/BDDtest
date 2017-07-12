#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
Feature: Reqdy2Go Hey Paris
	This wil check functionality of the "hey paris" in Ready2go app.
Scenario: "Hey Paris"
Given User should have apk installed
	And launched the app
	When Click on the main menu on the left tip side
	And Click on the 'Hey Paris' menu
	Then 'Hey paris' should be displayed on the top
When User tapped on the source input field
	And type the text 'hello' and send enter key.
	Then In the target field 'bonjour' should be displayed
	When click on the favourite icon
	Then the Icon should be changed 'light green'
	When click on the Expand Icon
	Then 'learn more' text page should be appear
	When Click on the 'learn more page'
	Then Translator page should be displayed
	Then dictionary item should be displayed
	When Click on the 'hello(noun)' expand button
	Then 'pl:hello' should be displayed
	When Click on the 'hello(intj)' expand button
	Then 'bonjour' should be displayed.

