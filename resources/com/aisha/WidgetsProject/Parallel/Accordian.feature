@Accordian
Feature: To verify the functionality of Accordian

  Background: URL is launched and Widgets option is selected 
    Given user launches url 
      And user selects Widgets from list of options 
     When Accordian is selected 
     Then Accordian page should be visible
     
 
  Scenario Outline: To verify three accordians are visible 
    Given accordian page is loaded 
     Then verify accordian "<text>" are visible 
    Examples: 
      | text                     | 
      | What is Lorem Ipsum?     | 
      | Where does it come from? | 
      | Why do we use it?        | 
  

  Scenario Outline: To verify text of accordians 
    Given accordian page is loaded 
     When question '<question>' number <number> '<sample>' accordian is clicked
     Then verify the text contains '<description>' text
    Examples: 
     |number| question                 | description                          | sample 		   |
     |1		| What is Lorem Ipsum?     | Lorem Ipsum is simply dummy          | firstAccordian |
     |2		| Where does it come from? | Contrary to popular belief,          | secondAccordian|
     |3	    | Why do we use it?        | It is a long established fact that a | thirdAccordian |
 
  
