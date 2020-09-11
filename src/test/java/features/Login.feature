Feature: Application Login

Scenario Outline: Home Page Login
Given User has opened "https://www.google.com/gmail/about/#" and navigate to login page
When User login using  <user> and <password>
Then Home Page is not populated

Examples:
|user       |password|
|sachinpd3  |1234|
|anu.style09|1234|