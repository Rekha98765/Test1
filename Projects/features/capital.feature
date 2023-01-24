@AllTestCases
Feature: Home page UI Validations 
 
 @tag1
 Scenario: To Check the Usability in all aspects as a end user in the site
  Given Open the Capital Monitor website
  Then verify menu and submenus are aligned 
	   |Institution |Asset owners~Banks~Government~Investment managers                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
     |Asset class |Alternative assets~Equity~Fixed income		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |		
     |Sector      |Consumer~Energy and Utilities~Healthcare~Industrials~Raw materials~Tech                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
  	 |Region      |Americas~Asia~Europe~Middle East and Africa and Africa                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
   	 |SDGs        |SDG 1, No Poverty~SDG 2, Zero Hunger~SDG 3, Good Health and Well-Being~SDG 4, Quality Education~SDG 5, Gender Equality~SDG 6, Clean Water And Sanitation~SDG 7, Affordable and Clean Energy~SDG 8, Decent Work and Economic Growth~SDG 9, Industry Innovation and Infrastructure~SDG 10, Reduced Inequalities~SDG 11, Sustainable Cities and Communities~SDG 12, Responsible Consumption and Production~SDG 13, Climate Action~SDG 14, Life Below Water~SDG 15, Life On Land~SDG 16, Peace, Justice and Strong Institutions~SDG 17, Partnerships for the Goals|
     |Factor      |Impact~Responsible~Sustainable                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
  
 @tag1
 Scenario: To Check the Usability in all aspects as a end user in the site
  Given Open the Capital Monitor website
  Then verify articles and links should be aligned properly
     |Sustainable Development Goals|
     |Government                   |
     |Asset Owners                 |
     |Investment Managers          |
     |ESG Research                 |
     |Banks                        |
     
 @tag1
 Scenario:verify user able to load the articles by clicking on that
  Given Open the Capital Monitor website
  When user get all articles links
  Then user should see articles should loaded by clicking on it
    
  
 @tag2
 Scenario: Verify of all websiteLogos are displayed in homePage
  Given Open the Capital Monitor website
  Then verify logo and banner should be displayed properly
   
 @tag3
 Scenario: Verification of Newsletter sign up functionality using "Receive our Newsletter" Popup in pre header
 Given Open the Capital Monitor website
 When User Click on "Receive our Newsletter" popup  from pre header   
 Then User able to see NewsLetter Signup popup should be opened     
 Then User has to Select the Newsletter checkbox , Enter email id   and Select the Consent Checkbox.                                                                                                                                                                                                                                                                                                            4.                                                                                                                                                                                                                               3. NewsLetter Signup popup should be opened                                                                                                                                                                                                                                                                   4. Select the Newsletter checkbox , Enter email id   and Select the Consent Checkbox
   
   
 @tag4
 Scenario: Verification of Newsletter sign up functionality using "Receive our Newsletter" Popup in pre footer
 Given Open the Capital Monitor website 
 When User Click on "Receive our Newsletter" popup  from pre footer 
 Then User able to see NewsLetter Signup popup should be opened     
 Then User has to Select the Newsletter checkbox , Enter email id   and Select the Consent Checkbox   footer                                                                                                                                                                                                                                                                                                       4.                                                                                                                                                                                                                               3. NewsLetter Signup popup should be opened                                                                                                                                                                                                                                                                   4. Select the Newsletter checkbox , Enter email id   and Select the Consent Checkbox
 
 
 @tag5
 Scenario: Verification of Newsletter sign up functionality using "View All Newsletters" Popup in pre header
 Given Open the Capital Monitor website
 When user has to Click the "View All Newsletters" popup  from pre header   
 Then User can able to see NewsLetter Signup popup should be opened     
 Then User Should be able to Select the Newsletter checkbox , Enter email id   and Select the Consent Checkbox.                                                                                                                                                                                                                                                                                                            4.                                                                                                                                                                                                                               3. NewsLetter Signup popup should be opened                                                                                                                                                                                                                                                                   4. Select the Newsletter checkbox , Enter email id   and Select the Consent Checkbox
 
 
 @tag6
 Scenario: Verification of Newsletter sign up functionality using "View All Newsletters" Popup in pre footer
 Given Open the Capital Monitor website
 When user has to Click the "View All Newsletters" popup  from pre footer   
 Then User can able to see NewsLetter Signup popup should be opened     
 Then User able to Select the Newsletter checkbox , Enter email id and Select the Consent Checkbox                                                                                                                                                                                                                                                                                                            4.                                                                                                                                                                                                                               3. NewsLetter Signup popup should be opened                                                                                                                                                                                                                                                                   4. Select the Newsletter checkbox , Enter email id   and Select the Consent Checkbox
 
 
 @tag7
 Scenario: Verify Whether all the Menus are  displaying as per the configuration in the backend 
  Given Open the Capital Monitor website
  Then Click on each menu one by one And check whether it is directing to its respective page
    |Institution|   
    |Asset class|
    |Sector     |
    |Region     |
    |SDGs       |
    |Factor     |
    |Events     |
    
    
 @tag8
 Scenario: To Check the Usability in all aspects as a end user in the site
  Given Open the Capital Monitor website
  Then Click on each submenu one by one and verify_user_able_to_navigating_to_its_respective_page 
     |Institution |Asset owners~Banks~Government~Investment managers                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
     |Asset class |Alternative assets~Equity~Fixed income		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |		
     |Sector      |Consumer~Energy and Utilities~Healthcare~Industrials~Raw materials~Tech                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
  	 |Region      |Americas~Asia~Europe~Middle East and Africa and Africa                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
   	 |SDGs        |SDG 1, No Poverty~SDG 2, Zero Hunger~SDG 3, Good Health and Well-Being~SDG 4, Quality Education~SDG 5, Gender Equality~SDG 6, Clean Water And Sanitation~SDG 7, Affordable and Clean Energy~SDG 8, Decent Work and Economic Growth~SDG 9, Industry Innovation and Infrastructure~SDG 10, Reduced Inequalities~SDG 11, Sustainable Cities and Communities~SDG 12, Responsible Consumption and Production~SDG 13, Climate Action~SDG 14, Life Below Water~SDG 15, Life On Land~SDG 16, Peace, Justice and Strong Institutions~SDG 17, Partnerships for the Goals|
     |Factor      |Impact~Responsible~Sustainable                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
    
    
   
 @tag9
 Scenario Outline: Verify Whether all the Menus are  displaying as per the configuration in the backend 
  Given Open the Capital Monitor website 
  When user clicks on All Sections tab                  
  Then Click on each extra menus one by one And check user able to see it is directing to its respective page '<link>'
   
  Examples:
   |link        |
   |Home        |
   |About us    |
   |Contact us  |
   |Newsletter  |
   |ESG research|
   |Partners    |
   
 @tag10
 Scenario Outline: To Verify the Search Functionality present in the Header section 
  Given Open the Capital Monitor website
  When user clicks on "<Search Icon>"
  Then user has to enter an "<Search term>" in the Search  box 
  Then user has to Click the Search Icon and Verify user able to navigating to respective page
    
    Examples:
    |Search term        |
    |Terms and condition|
    
    
 @tag11   
 Scenario: To Check the Usability in Sustainable Development Goals as a end user in the site
  Given Open the Capital Monitor website
  Then verify articles and links should be aligned properly
   |Sustainable Development Goals|
 
 @tag11
 Scenario: verify user able to load the  Sustainable Development Goals by clicking on that
  Given Open the Capital Monitor website
  When user get all articles links
  Then user should see articles should loaded by clicking on it
 
 
 @tag12
  Scenario Outline: Verify under the end of article  such as "mail", "Linked In","Twitter" and "Facebook" are working Properly
    Given Open the Capital Monitor website
    When user Click an article in the home page                     
    And Check whether the selected article is directing to the respective article page
    And Click on each and every Sharing Options
    |Share on LinkedIN|
    |Share on Twitter |
    |Share on facebook|  
    Then verify whether clicking any sharing options are directing to the respective pages with the link of the article and sharetext 
 
  
 @tag13
  Scenario Outline: verify the Social media links in the footer 
   Given Open the Capital Monitor website
   When user able to Scroll down to the footer section                    
   And Click on any Social media icon and user able to directed to the Capitalmonitor home page to the respective social media
   |twitter |
   |linkedin|
 
 
@tag14 
 Scenario Outline: Verification of menus configured in the Footer section 
    Given Open the Capital Monitor website
    When user able to Scroll down to the footer section                    
    Then Check whether there are  "<menus>" icons in the footer section
    And Click on any menu and it should be directed to the  respective page    
   |About us               |
   |Contact us             |
   |Newsletter             |
   |Our marketing solutions|
   |Privacy policy         |
   |Terms and conditions   |
   |Resources              |
   
@tag15
 Scenario Outline: Verifying links under Websites In Our Network 
    Given Open the Capital Monitor website
    When user able to Scroll down to the footer section                    
    Then Check whether there are  "<Websites>" icons in the footer section
    And Click on any menu and it should be directed to the  respective page with details.   
   |Tech Monitor      |
   |The New Statesman |
   |Press Gazette     |
   |Spears            |
   |World of Fine wine|
   |Elite Traveler    |
 
 @tag16
  Scenario Outline: verify the whitepaper download functionality
    Given Open the Capital Monitor website
    When user Click on "ESG Research" menu under '<All Sections>'
    Then user must be directed to WhitePapers page after clicking the "ESG Research"
    And  user able to see "Enter Your email" textbox in the WhitePaper Article
    And  user must be able to enter email id and '<verious details>'
    

    Examples:
    |All Sections|verious details                                                                                        |
    |ESG research|Your work email address,First Name,Last Name,Company,job_title,Country,phone, Download free white paper|
    
       
 @tag17
  Scenario Outline: verify the "Partners" page 
    Given Open the Capital Monitor website
    When user Click on "Partners" menu under '<All Sections>'tab
    Then user must be directed to Partners page 
    Then  user must able to search the company name using '<Search option>'
    And  The User must be provided with the list of companies starting in the respective alphabet 
    Then The User must be directed to the respective Company Details page after Clicking the company name and "Read more" under the Company name
    
    Examples:
    |Search option|
    |abrdn        |
    
 @tag18
  Scenario: verify whether Clicking the Author name in the article
    Given Open the Capital Monitor website
    When user should see the Author name under heading of each "<article>"
    Then user must be able to Click on the "<author>"and The user should be directed to the respective page
    Then verify user able to see all the articles written by the same author

 @tag19
  Scenario Outline: Verification of Tags in the articl of the homepage
    Given  Open the Capital Monitor website
    Then user has to click on any "artical"
    Then user must able to see tags under the article in the name of '<Topics in this article>'
    Then user has to Click on the topic and then user should be directed to the respective page
    
    Examples: 
    |Topics in this article|
    |Climate change        |
    
                                                                                                                  
    
 
 