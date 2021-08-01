Feature: All scenarios with respect to Create Delete and Restore

    
    Scenario: TC001 Create a file
    Given the user has logged into mega
    When the user creates a file
    Then the user should be allowed to create a file successfully
    
   
   Scenario: TC002 Remove a file
    Given the user has logged into mega
    When the user removes a file
    Then the user should be allowed to remove a file successfully

    Scenario: TC003 Restore a file
    Given the user has logged into mega
    When the user navigates to Rubbish bin
    And the user restores a file
    Then the user should be allowed to restore a file successfully

  
   
