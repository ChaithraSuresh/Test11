Feature: Login to application
	
 Scenario: Check Swiggy site
		Given I am on automationpractice
		When I click on findfood link
		And I search restaurant
		And I verify the item
		And I add food to cart
		Then I verify number of items
	
	
		


