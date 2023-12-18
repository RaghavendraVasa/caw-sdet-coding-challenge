Feature: As a user of the application i want to login to Amazon  
 Background:
  Given user is successfully naviaged to "https://www.amazon.in/"
  
  @loginAmazon
  Scenario Outline:  login functionality 
     When user click on signIn button
     When user enters username in sign in page
     And user submit the username in sign in page
     When user enters password in sign in page
     And user submit the password sign in page
     Then user should be navigate to homepage
     When use click on delivey address locator
     And user update delivery address in Choose your location popup
     Then location should should updated to "Hyderabad 500032‌"                