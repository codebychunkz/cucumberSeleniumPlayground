Feature: Wikipedia

	Background:
		Given I navigate to Wikipedia

	Scenario: Finding wikipedia articles for Java
		When I search for the following term Java
		Then the headline should be Java

	Scenario: Controlling that the Evlution topic exists for the Fish articles
        When I search for the following term Fish
        Then the topics should contain Evolution