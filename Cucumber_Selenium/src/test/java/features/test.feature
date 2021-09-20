Feature: Amazon SignUp
  Verify that I am unable to signup for Amazon

  Scenario: I try to sign up for amazon
    Given I am on amazon homepage
    When I entered all details
    	|	username		|	m_number		|	email_id							 |	password		|	password_check	|
    	|	Sunil Rawat	|	9971390073	|	sunilrawat85@gmail.com |	Abcdefgh@1	|	Abcdefgh@1	|
    Then I received a message that user already existed
