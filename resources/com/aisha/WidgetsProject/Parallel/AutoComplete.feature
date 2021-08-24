@AutoComplete
Feature: To verify the functionality of AutoComplete in ToolsDemoQA 

Background: URL is launched and Widgets option is selected and Auto Complete is selected 
	Given user launches url for autocomplete test
	And user selects Widgets from list of options for autocomplete test
	When AutoComplete is selected
	Then AutoComplete page should be visible
	
Scenario: To verify multiple text box accepts multiple colours 
	Given text box is selected 
		|multiple colour|
	When colour value is typed 
		|color  |boxtype        | 
		|Red    |multiple colour|
		|Green  |multiple colour|
		|Yellow |multiple colour|
		|Voilet |multiple colour|
	Then multiple colours should get accepted
		|color  |boxtype        | 
		|Red    |multiple colour|
		|Green  |multiple colour|
		|Yellow |multiple colour|
		|Voilet |multiple colour|
	
Scenario: To verify in multiple text box whether colours gets deleted upon clicking delete 
	Given text box is selected 
		|multiple colour|
	When colour value is typed 
		|color  |boxtype        | 
		|Red    |multiple colour|
		|Green  |multiple colour|
		|Yellow |multiple colour|
		|Voilet |multiple colour|
	And colors are deleted 
	Then verify the text box is empty 
	
Scenario: To verify in multiple text box whether colour gets deleted upon clicking delete 
	Given text box is selected 
		|multiple colour|
	When colour value is typed
		|color  |boxtype        | 
		|Red    |multiple colour|
	And colors are deleted 
	Then verify the text box is empty 
	
Scenario: To verify in multiple text box whether colours gets deleted with common delete 
	Given text box is selected 
		|multiple colour|
	When colour value is typed 
		|color  |boxtype        | 
		|Red    |multiple colour|
		|Green  |multiple colour|
		|Yellow |multiple colour|
		|Voilet |multiple colour|
	And common delete is clicked
	Then verify the text box is empty 
	
Scenario: To verify in single text box whether colour gets autocomplete on typing 
	Given text box is selected 
		|single colour|
	When colour value is typed  
		|color  |boxtype      | 
		|Red    |single colour|
	Then verify the colour is present 
		|color  |boxtype      | 
		|Red    |single colour|

Scenario: To verify in single text box does not accept more than one colour 
	Given text box is selected 
		|single colour|
	When colour value is typed 
		|color|boxtype    	| 
		|Red  |single colour|
		|Green|single colour|
	Then verify the colour is present 
		|color|boxtype    	| 
		|Red|single colour|
		
		
		
		
		
		
		
		
		
		
		
