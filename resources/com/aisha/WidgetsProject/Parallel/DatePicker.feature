@DatePicker
Feature: To verify functionality of date pickers 

  Background: 
  URL is launched and Widgets option is selected and Date Picker is selected 
    Given user launches url for Date picker test 
      And user selects Widgets from list of options for date picker test 
     When Date picker is selected
     Then  Date picker should load properly

  Scenario: To verify todays date is present in calendar 
    Given Date text box is selected
     Then todays date is present
    
  Scenario: To verify todays date is highlighted in calendar 
    Given Date text box is selected
     Then todays date should be highlighted

  Scenario: To verify all months are selected are visible in the date picker
  	Given Date text box is selected
    #And Month dropdown is selected
    Then verify month selected is visible in date picker
      | January   | 
      | February  | 
      | March     | 
      | April     | 
      | May       | 
      | June      | 
      | July      | 
      | August    | 
      | September | 
      | October   | 
      | November  | 
      | December  |
          
  Scenario: To verify year selected is visible in date picker
  	Given Date text box is selected
  	#And year dropdown is selected
  	Then verify year selected is visible in date picker
  		
  Scenario: To verify a particular date gets selected
  	Given Date text box is selected
  	#And Month dropdown is selected
  	And verify month selected is visible in date picker
  		|December|
  	And year is selected
  		|Year |
  		|1996 |
  	And date is selected
  		|Date |
  		|13   |
  	Then verify the date is visible in the date text box
  		|Date      |
  		|12/13/1996|
		
   Scenario: To verify the forward button are clickable 
   	Given Date text box is selected
   	And forward button is clicked 
   	Then verify the month value changes
   		|Button Type|
   		|Forward    |

   Scenario: To verify the backward button are clickable 
   	Given Date text box is selected
   	And backward button is clicked
   	Then verify the month value changes
   		|Button Type|
   		|Backward   |