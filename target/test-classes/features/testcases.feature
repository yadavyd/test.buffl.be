#  Clicking on  New campaign button creates new record with name "/" and status of the record "Missing Required Data"
#  Clients can search for created campaign
#  Clicking on campaign name allow user to edit the form
#  Client can deleted campaign record
#  The client can view the shared link of the created form

@creatingcampaign @smoke
Scenario: client should be able to create new campaign with name /  with out filling out required fields and it is visible on my campaigns page
  When user login
  When user clicks on New campaign button
  When user clicks on logo button on the header
  Then campaign with name "/" is visible on My Campaigns page and it has status Missing Required Data

@creatingcampaign @smoke
Scenario: client should be able to create new campaign filling all required fields and it has status testing
  When user login
  When user clicks on New campaign button
  When user clicks on upload button on edit block and choose image
  When user fills out type campaign name here field with "test"
  When user fills out write campaign description here field with "Campaign Description"
  When user fills out amount of responses required field with "3"
  When user clicks on the logo of the header
  Then campaign with name "test" is visible on My Campaigns page and it has status Testing

@creatingcampaign @smoke
Scenario: After filling all required fields and clicking Check data button the pop up appears with "Campaign is valid"
  When user login
  When user clicks on New campaign button
  When user clicks on upload button on edit block and choose image
  When user fills out type campaign name here field with "test"
  When user fills out write campaign description here field with "Campaign Description"
  When user fills out amount of responses required field with "3"
  When user clicks on Check data button on the header
  Then pop up CAMPAIGN DATA CHECK appears with "Campaign is valid"

@creatingcampaign @smoke
  Scenario: After filling all required fields and clicking Logic map button the pop up appears with structure of the questions
  When user login
  When user clicks on New campaign button
  When user clicks on upload button on edit block and choose image
  When user fills out type campaign name here field with "test"
  When user fills out write campaign description here field with "Campaign Description"
  When user fills out amount of responses required field with "3"
  When user drag and drop element Open question
  Then pop up LOGIC MAP appears and it has "Welcome", "1. Question", "Thank you"

@creatingcampaign @smoke
Scenario: client should be able to create new campaign filling all required fields and make request approval and it has status Approval Request Sent
  When user login
  When user clicks on New campaign button
  When user clicks on upload button on edit block and choose image
  When user fills out type campaign name here field with "test"
  When user fills out write campaign description here field with "Campaign Description"
  When user clicks on Request approval button on the header
  Then user verifies Request approval button has status disabled
  When user clicks on the logo of the header
  Then campaign with name "test" is visible on My Campaigns page and it has status Approval Request Sent

@creatingcampaign @smoke
Scenario: client should be able to drag and drop elements from build block to the questions block
  When user login
  When user clicks on New campaign button
  When user drag and drop element Open question
  Then user verifies that Type your Open Question here field is visible
  Then user verifies that Minimum Answer Length field is visible
  Then user verifies that Maximum Answer Length field is visible

@creatingcampaign @smoke
Scenario: client should be able to delete elements from question block
  When user login
  When user clicks on New campaign button
  When user drag and drop element Open question
  Then user verifies that Type your Open Question here field is visible
  When user clicks on Type your Open Question here field
  Then Delete button on Edit block appears
  When user click on Delete button
  Then user verifies that block has deleted

@creatingcampaign @smoke
Scenario: can navigate through the blocks with minimap
  When user login
  When user clicks on New campaign button
  When user drag and drop element Open question
  Then user verifies that Type your Open Question here field is visible
  When user clicks on the next icon
  Then user verifies that next block has status active

@creatingcampaign @smoke
Scenario: Gender, Age settings by default has status disabled
  When user login
  When user clicks on New campaign button
  When user clicks on Settings button on the header
  Then user verifies that Age has status disabled
  Then user verifies that Gender has status disabled

@creatingcampaign @smoke @negative
Scenario: clicking on Check data on the header without filling required fields show pop up with errors and they are visible under welcome block
  When user login
  When user clicks on New campaign button
  When user clicks on Check data button on the header
  Then pop up CAMPAIGN DATA CHECK appears with "Errors found"
  Then pop up has error "Campaign name is missing"
  Then pop up has error "Campaign description is missing"
  Then pop up has error "Amount of responses is missing"
  Then pop up has error "Cover image is missing"
  When user clicks on the logo of the header
  Then user verifies that errors are visible under welcome block