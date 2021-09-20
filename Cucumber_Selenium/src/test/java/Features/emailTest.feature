Feature: Email Login
  Verify that user is able to login in to the yahoomail

  @emailLoginTest
  Scenario: Login as a authenticated user
    #Given I open a <webpage> "www.yahoo.com"
    #And I navigate to login page
    #TODO: read username and password from file in resource directory
    #Make your test readable and consistent
    Given user is on homepage
    When I navigates to login page
    And I enters "sunilrawattest@yahoo.com" and "Ultr@Mild"
    Then success message is displayed

  Scenario: Replying to an email
    Given I logged in to the yahooemail
    When I search the title of an email
    And I select the email to reply
    Then I send an reply to the email

  Scenario: Composing an email with students information
    Given I am composing an email
    And I entered the recepient email id
    When I put the subject of email as student information
    And I have entered the student details in the body
      | Student  | English | Hindi | Maths |
      | Student1 |    2222 |  1111 |  5555 |
      | Student2 |    3333 |  4444 |  6666 |
    Then I have sent email to recepient
