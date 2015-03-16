
@txn
Feature: Contacts

  Scenario: read contact

    Given there is a contact with name = 'John' and full name = 'Doe'
    When I perform GET request on "/rest/contacts"
    Then the status code should be 200
    And the response should be
    """
    [{
    "id":"123",
    "name":"John",
    "fullName":"Doe"
    }]
    """
