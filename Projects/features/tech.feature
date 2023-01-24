Feature: Home page UI Validations 
 
@tag1
Scenario: Verify and Check the Usability in all aspects as a end user in the site
  Given Open the Tech Monitor website
  Then verify menu and submenus are aligned 
     |Technology           |AI and automation~Cloud~Cybersecurity~Data~Data Centre~Hardware~Networks~Software                     |
     |Leadership           |Digital Transformation~Finance and procurement~Governance~Innovation~Strategy~Sustainability~Workforce|
     |Policy               |Big Tech~Digital economy~Education and employment~Geopolitics~Privacy and data protection             |
     | Future of cybercrime|Beyond RPA~ESG and IT~ESG and IT~On the edge~The new world of work                                    |
     
@tag1
Scenario: To Check the Usability in all aspects as a end user in the site
  Given Open the Tech Monitor website
  Then verify articles should be aligned
     |Latest                  | 
     |Technology              |
     |Leadership              |
     |Policy                  |
     |Government Computing    |
     |The future of cybercrime|
     |Partner Content         |
     |White papers            |
     
     
@tag1
Scenario:verify user able to load the articles by clicking on that
  Given Open the Tech Monitor website
  When user get all articles links
  Then user should be able to see articles should loaded by clicking on it
      
@tag2
Scenario: Verify of all websiteLogos are displayed in homePage
  Given Open the Tech Monitor website
  Then verify logo should be displayed properly
    