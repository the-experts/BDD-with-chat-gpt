Feature: Bookstore API

  Background:
    * url 'http://localhost:8000'

  Scenario: Creating a new book
    Given path '/books'
    And request { "title": "Book 2", "author": "Author2", "isbn": "12345", "price": 20.0 }
    When method post
    Then status 200
    And match response == { "title": 'Book 2', "author": 'Author2', "isbn": '12345', "price": 20.0 }

  Scenario: Retrieving a book by ISBN
    Given path '/books/12345'
    When method get
    Then status 200
    And match response == {"title":"Book 2","author":"Author2","isbn":"12345","price":20.0}

  Scenario: Retrieving a list of books
    Given path '/books'
    When method get
    Then status 200
    And match response contains {"title":"Book 2","author":"Author2","isbn":"12345","price":20.0}

  Scenario: Deleting a book
    Given path '/books/12345'
    When method delete
    Then status 200

  Scenario: Editing a book
    Given path '/books/12345'
    And request { "title": "Book 1.1", "author": "Author1", "isbn": "12345", "price": 15.0 }
    When method put
    Then status 200
    And match response == { "title": 'Book 1.1', "author": 'Author1', "isbn": '12345', "price": 15.0 }
