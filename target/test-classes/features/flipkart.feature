
@tag
Feature: order a product in online site

Background:
    Given lounch the browser
    And open the website

  @tag1
  Scenario: product buying
    When search the product "iphone 15"
    And  click the product
    And click addcart the product
    Then I validate the outcomes
   
    
     Scenario: product buying
    When search the product "iphone 15"
    And  click the product
    And click buy now the product
    Then I validate the outcomes
  
   
    
    
    

 
