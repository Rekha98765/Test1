@AllTestCase
Feature: Home page UI Validations 
 
 @tag1
  Scenario: To Check the Usability in all aspects as a end user in the site
  Given Open the PMI Website
  Then Verify the scroller buttons are working properly in the website
      
  
@tag2
  Scenario: Verify websiteLogos are displayed in homePage
  Given Open the PMI Website
  Then Verify the website logo in the header
  
  
@tag3
  Scenario: To verify the menus in the header
  Given Open the PMI Website
  Then Check wether their are four menus in the header
  Then Click each and every menu and it should be navigated to the respective pages
  |Home           |
  |Events         |
  |Partner With Us|
  |Contact        |
  

@tag4
  Scenario Outline: To verify the search functionality in home page
  Given Open the PMI Website
  Then Select data in the "filters" under Find your community and click on Search button
  
  Examples:
  |filters                                       |
  |Banking, Financial Services & Insurance (BFSI)|
  
  
@tag5
  Scenario: Verify the sections in the home page
  Given Open the PMI Website
  Then Verify the following sections in the home page
   |About Us                       |
   |Browse by sector               |
   |Our Brands                     |
   |Featured events                |
   |What our customers say about us|
   |Sponsors                       |
  Then User has to Click on View more events button under Featured events section in home page
  
@tag6 
  Scenario: Verify if visitor is able to register for an upcoming conference event
  Given Open the PMI Website
  Then User Should click on Events menu on website and Verify if all the events are displaying as per their configuration
  Then User has to Click on any upcoming conference event and verify the date, time of the event
  Then Click each and every menu and it should be direct to the respective page
   |Agenda            |
   |Speakers          |
   |Sponsors to follow|
  Then Click on Register button
  Then User has to Click on Register Now button, enter all details 
  
 
@tag7 
  Scenario: Verify if visitor is able to register for an upcoming conference event
  Given Open the PMI Website
  Then User Should click on Events menu on website and Verify if all the events are displaying as per their configuration
  Then User has to Click on any upcoming Webinar event and verify the date, time of the event
  Then Click on Speakers menu and it should be direct to the respective page
  
  
@tag8
  Scenario:  Verify if visitor is able to register for an on demand event
  Given Open the PMI Website
  Then User Should click on Events menu on website and Verify if all the events are displaying as per their configuration
  Then User has to Click on any on demand Webinar event and verify the date, time of the event
  Then Click Speakers menu and it should be direct to the respective page
  Then Click on View on demand button and User has to enter all details on Register page
  
  
 
@tag9
  Scenario:  Verify if footer elements are taking to the respective pages
  Given Open the PMI Website
  Then User has to scroll down to the footer
  Then User has to Click on the footer elements and verify if visitor is navigating to respective pages
   |Home           |
   |Events         |
   |Partner With Us|
   |Contact        |
   
   
@tag9
  Scenario: Verify the footer elements are directing to the respective pages
  Given Open the PMI Website
  Then User has to scroll down to the footer
  Then User has to Click on the footer elements and verify the visitor is navigating to respective page
   |T&C |
   |GDPR|
   
  
  
   
  
  
  