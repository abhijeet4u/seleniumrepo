Feature: Appliction Login

Scenario: login With valid credentials
Given Open any browser
And Navigate to login page
When user enters Mobile Number as "8888996163" and password as "abhi@143" into the fields
And User click on submit button 
And User click on  Alert
Then Verify user is able to successfully login
