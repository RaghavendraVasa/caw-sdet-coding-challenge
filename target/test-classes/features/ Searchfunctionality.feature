Feature: As a user of the application i want to search product and sort search results in Amazon  
 Background:
  Given user is successfully naviaged to "https://www.amazon.in/"
  
  @seacrchfunctionality
  Scenario Outline:  search functionality 
     When user enters "<product>" in searchbox in amazon
     And user click on searchbox in homepage
     And user waits for page to load
     Then search results should display
     When user sorts products from high to low
     Then search results count should change
     Examples:
      |product|
      |mobile|
      #|Refridgerator|