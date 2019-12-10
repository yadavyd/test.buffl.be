@smoke
Feature: client should be able to login to the test.buffl.be and create test campaign with status Missing Required Data


  @creatingcampaign
  Scenario: client should be able to create new campaign with name "test" and it is visible on my campaigns page
    Given client sign in using credentials: Email "yaroslav_test@buffl.be" and Password "testing_qa"
    When user clicks on "New campaign" button
    Then user is navigated to form builder page
    Then user verifies that build container has "Single answer" item
    Then user verifies that build container has "Open question" item
    Then user verifies that build container has "Multiple answers" item
    Then user verifies that build container has "Rating Scale" item
    Then user verifies that build container has "Take a picture" item
    Then user verifies that build container has "Capture a video" item
    Then user verifies that build container has "Show a video" item
    Then user verifies that build container has "Showcase a website" item
    Then user verifies that text "Drag and drop a new block from the build menu" is present
    When user fills out "Type Campaign Name here" field with "test"
    When user fills out "Write Campaign Description here" field with "Campaign Description"
    When user fills out "Amount of responses required" field with "3"

    When user drag and drop "Open question" to the question block
    When user fills out "Type your Open Question here" field with "How do you like this service?"
    When user fills out "Minimum Answer Length" field with "14"
    When user fills out "Maximum Answer Length" field with "100"

    When user drag and drop "Showcase a website" to the question block
    When user fills out "Type your Showcase A Website Question here" field with "How do you like this website?"
    When user fills out "Website URL" field with "https://test.buffl.be/"

    Then user clicks on "Setting" button
    Then user verifies that row "Amount of responses required" contains "3"
    Then user verifies that row "Age" is "disabled"
    Then user verifies that row "Gender" is "disabled"
    Then user clicks on the logo of the header
    Then user is navigated to campaign page
    Then user verifies that campaign "test" is present on my campaign page
    Then user verifies that campaign "test" has amount "3"
    Then user verifies that campaign "test" has status "Missing Required Data"








