Feature: This feature file is designed to check the functionalities in Admin page

#Scenario: This scenario is designed to check the links order
#    Given as an user I want to launch Firefox browser
#    When browser is launched verify home page is displayed
#    And click on Admin page
#    Then Login to admin page with user name and password 
#    Then verify the Admin page content tabs order
#    Then verify the broken links in admin page
    
Scenario: This scenario is designed to verify the fields order in Add staff page
	Given as an user I want to launch Firefox browser
    When browser is launched verify home page is displayed
    And click on Admin page
    Then Login to admin page with "username" and "password"
    |admin|admin|
    And click on Add staff member in Admin page
    Then verify the fields order in add staff page
    
    
 Scenario: This scenario is designed to verify the fields order in Add staff page
	Given as an user I want to launch Firefox browser
    When browser is launched verify home page is displayed
    And click on Admin page
    Then Login to admin page with "username" and "password"
    |admin|admin|
    And click on Add staff member in Admin page
    Then Enter mandatory fields in add staff member page
    |Subhash|M|12-08-2017|12-08-2018|HYD|917751|madam5@q.com|test|
    |Subhash1|F|12-08-2016|12-08-2018|HYD1|9177511|madam9@m.com|test1|
        
#Scenario: This scenario is designed to verify the number of invalid inputs in Add Staff member
#	Given as an user I want to launch Firefox browser
#    When browser is launched verify home page is displayed
#    And click on Admin page
#    Then Login to admin page with user name and password
#    And click on Add staff member in Admin page
#    Then verify the number of invalid inputs in Add Staff member

    