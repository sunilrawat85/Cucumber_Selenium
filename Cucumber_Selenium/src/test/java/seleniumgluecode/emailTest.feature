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

# ToDo : Add Background

Feature: Email Login
  Verify that user is able to login in to the yahoomail

  @emailLoginTest
  Scenario: Login as a authenticated user
    #Given I open a webpage "www.yahoo.com"
    #And I navigate to login page
    Given user is on homepage
    When user navigates to login page
    #TODO: read username and password from file in resource directory
    And user enters "sunilrawattest@yahoo.com" and "Ultr@Mild"
    Then success message is displayed    
    
    Scenario: I replied to an email
    Given I logged in to the yahooemail 
    When I search the title of an email
    And I select the email to reply
    Then I send an reply to the email
    
    