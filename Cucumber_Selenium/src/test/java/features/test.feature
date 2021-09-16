Feature: Email Login
  Verify that user is able to login in to the yahoomail

  Background: Login as a authenticated user
    Given user is on homepage
    When user navigates to login page
    And user enters "sunilrawattest@yahoo.com" and "Ultr@Mild"
    Then success message is displayed

  Scenario: Composing an email with students information
  	Given I logged in to the yahooemail 
    And I am composing an email
    And I entered the recepient email id
    When I put the subject of email as student information
    And I have entered the student details in the body
      | Student  | English | Hindi | Maths |
      | Student1 |    2222 |  1111 |  5555 |
      | Student2 |    3333 |  4444 |  6666 |
    Then I have sent email to recepient
