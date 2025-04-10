Feature: To test messaging functionality of LinkdIn

Background: 
Given User is on the messaging page

#SANITY TESTING
@searchbar  
Scenario: to validate sending message by searching a person

When User will search a person on the searchbar
And write a "<text>" in the textbox
|Hello, its a automated message|
And click on the send button
Then message will be sent to respective person


@manageconvo
Scenario: To test manage conversation dropdown 

When User will click on messaging dropdown icon
And click on manage conversation option
And Select the conversation to be managed
And click on mark as unread option
Then coversations will be displayed as unread

@chatfunction
Scenario: To test function of chat dropdown

When Search a "<name>" on the searchbar
|Dattesh Kachore|
And click on dropdown icon in the chat
And click on move to other option in dropdown
And click on other button
Then the person will be displayed in OTHER menu


@videomeet
Scenario: To test instant video meet option

When User searches a "<name1>" in search bar
|mihir|
And click on camera icon in the chat
And click on the instant video meeting option
Then meeting link will be sent to the respective person

@newconversation
Scenario: To start a conversation with a connection
When Search the name of the "<person>" to message
|Shravani Pande|
And Click on the name
Then start typing in the textbox 






