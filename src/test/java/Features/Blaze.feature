Feature: Blaze


Scenario: Verify Blazedemo page opened in browser and user is able to purchase ticket 

Given the BlazeDemo page is opened in Chrome Browser
When the pageTitle is displayed 
And user clicks on hyperlink and see a new tab is opened 
And user verifies that the url has string vacation 
Then User selects Mexico is departure city and London in destination city
And user selects the flight with lowest price and navigated to the purchase page
And the user verifies total cost is available and clicks on purchase flight
Then the user is navigated to the purchase conf page and store the id

