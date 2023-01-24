@AllTestCases
Feature: Home page UI Validation
      
@tag1
 Scenario: To Check the Usability in all aspects as a end user in the site
  Given Open the City Monitor website
  Then Verify the menus are aligned properly
       |Community     | 
       |Economy       |
       |Environment   |  
       |Government    |
       |Housing       |
       |Infrastructure|
       |Smart cities  |
       |Transport     |
       |World         |

       
@tag1
 Scenario: To Check the Usability in all aspects as a end user in the site
  Given Open the City Monitor website
  Then Verify the submenus are aligned properly
       |Asia-Pacific                     |
       |Central America and the Caribbean|
       |Europe                           |
       |Middle East and North Africa     |
       |North America                    |
       |South America                    |
       |Sub-Saharan Africa               | 
       
@tag1
 Scenario: To Check the Usability in all aspects as a end user in the site
  Given Open the City Monitor website
  Then verify articles should be aligned 
       |Guides                    |
       |Housing                   |
       |Community                 |
       |Infrastructure & transport|   
       |Macroeconomics & politics |
       |Comment                   |
       |Partner content           |
       |Partner white papers      |
       
@tag1
 Scenario:verify user able to load the articles by clicking on that
  Given Open the City Monitor website
  Then user should be able to see articles should loaded by clicking on it 
        
       
         
@tag2
 Scenario: Verification of website logo
  Given Open the City Monitor website
  Then verify logo should be displayed properly
  
  
@tag3
 Scenario: Verification of all the menus in header
  Given Open the City Monitor website
  Then Click each and every menu and it should be directed to the respective pages
       |Community     |
       |Economy       |
       |Environment   |
       |Government    |
       |Housing       |
       |Infrastructure|
       |Smart cities  |
       |Transport     |
       |World         |
  Then Click on any artical
    
@tag4
 Scenario: Verification of all the menus in quick menu
  Given Open the City Monitor website
  And in quick menu (OR) all section menu,Click each menu one by one and check whether it is directing to its respective page 
       |Community     |
       |Economy       |
       |Environment   |
       |Government    |
       |Housing       |
       |Infrastructure|
       |Smart cities  |
       |Transport     |
       |World         |
  Then Click on any artical
        
        
@tag5
 Scenario: Verification of Extra menus configured under All Sections
  Given Open the City Monitor website
  And Click each Extramenu one by one and check whether it is directing to its respective page 
       |Contact us             |
       |GDPR                   |
       |Our marketing solutions|
       |Privacy Policy         |
       |Terms and Conditions   |
       |White papers           |
       |Partner companies      |
     
@tag6
 Scenario Outline: Verification of search functionality 
  Given Open the City Monitor website
  When User able to clicks on "<Search Icon>" in the application
  Then User able to enter an "<Search term>" in the Search  box 
  Then User has to Click the Search Icon and it ashould be directed to the respective page
    
  Examples:
  |Search term   |
  |Privacy Policy|
 
 
@tag7
 Scenario: To Check the Usability in Guides as a end user in the site
  Given Open the City Monitor website
  Then verify articles and links should be aligned properly
   |Guides|
 
@tag7
 Scenario: verify user able to load the Guides by clicking on that
  Given Open the City Monitor website
  When user get all articles links
  Then user should see articles should loaded by clicking on it
 

@tag8
  Scenario Outline: Verify under the end of article  such as "mail", "Linked In","Twitter" and "Facebook" are working Properly
    Given Open the City Monitor website
    When user Click an article in the home page                     
    And Check whether the selected article is directing to the respective article page
    And Click on each and every Sharing Options
    |Share on LinkedIN|
    |Share on Twitter |
    |Share on facebook|  
    Then verify whether clicking any sharing options are directing to the respective pages with the link of the article and sharetext 
  
@tag9
  Scenario Outline: verify the Social media links in the footer 
   Given Open the City Monitor website
   When user able to Scroll down to the footer section                    
   And Click on any Social media icon and user able to directed to the Capitalmonitor home page to the respective social media
    |twitter |
    |linkedin|
 
 
@tag10 
 Scenario Outline: Verification of menus configured in the Footer section 
  Given Open the City Monitor website
  When user able to Scroll down to the footer section                    
  Then Check whether there are  "<menus>" icons in the footer section
  And Click on any menu and it should be navigate to the  respective page    
    |Contact us             |
    |Our marketing solutions|
    |GDPR                   |
    |Terms and Conditions   |
    |Privacy Policy         |
    
@tag11
 Scenario Outline: Verifying links under Websites In Our Network 
  Given Open the City Monitor website
  When user able to Scroll down to the footer section                    
  Then Check whether there are  "<Websites>" icons in the footer section
  And Click on any menu and it should be their in the  respective page   
    |Tech Monitor      |
    |Capital Monitor   |
    |The New Statesman |
    |Press Gazette     |
    |Spears            |
    |World of Fine wine|
    |Elite Traveler    |
    
    
@tag12
 Scenario Outline: verify the whitepaper download functionality
  Given Open the City Monitor website
  When user Click on "White papers" menu under '<All Sections>' tab
  Then user must be directed to WhitePapers page after clicking the "WhitePapers" in th site
  And  user able to see "Enter Your email" textbox in the WhitePaper Article
  And  user must be able to enter email id and '<verious details>'
    

  Examples:
  |All Sections|verious details                                                                                        |
  |ESG research|Your work email address,First Name,Last Name,Company,job_title,Country,phone, Download free white paper|
    

@tag13
  Scenario: verify whether Clicking the Author name in the article
    Given Open the City Monitor website
    When user should see the Author name under heading of each "<article>" in site
    Then user must be able to Click on the "<author>"and The user should be navigeted to the respective page
    Then verify user able to see all the articles written by the same author
    
@tag14
  Scenario Outline: Verification of Tags in the articl of the homepage
    Given  Open the City Monitor website
    Then user has to click on any "artical"
    Then user must able to see tags under the article in the name of '<Topics in this article>'
    Then user has to Click on the topic and then user should be directed to the respective page
    
    Examples: 
    |Topics in this article|
    |Data                  |
 