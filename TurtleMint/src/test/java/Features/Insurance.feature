@Turtlemint_Insurance
Feature: Turtlemint life Insurance 

Scenario Outline: Buy Term Insurance

Given User land on the turtlemint homepage
And Select life insurance option 
Then User select term life Plans from the option and fill in the profile
Then User select <Gender> based on parameter passed
Then User select Date of birth
Then User select <Smoke_Tobacco> tobacco smoke based on Parameter 
Then User select <Annual_income> Annual income based on the parameter passed
And click on Next button
Then User Select <Sum_Assured> Sum Assured 
And click on Next button
Then Enter contact details and click Next
And click on Next button
Then click on View details button based on<Insurance_Name>

##PNBMETLI
##AEGONLI
##BAJAJLI
##MAXLIFELI
##TATAAILI
##HDFCLI
##TATAAIALI
##LICLI

Examples:
     |Gender|Smoke_Tobacco|Annual_income| Sum_Assured|Insurance_Name|
     |Male |Yes|7 Lac to 10 Lac|₹35 Lakhs|MAXLIFELI|
     
     