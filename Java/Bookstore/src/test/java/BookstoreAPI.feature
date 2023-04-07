Feature: Book API

  Background:
    * url 'http://localhost:8080'

  Scenario: Get list of books
    Given path '/books'
    When method get
    Then status 200
    And match response == []

  Scenario: Create a book
    Given path '/books'
    And request { title: 'The Great Gatsby', author: 'F. Scott Fitzgerald', isbn: '9780141182636', price: 9.99 }
    When method post
    Then status 200
    And match response.title == 'The Great Gatsby'
    And match response.author == 'F. Scott Fitzgerald'
    And match response.isbn == '9780141182636'
    And match response.price == 9.99

  Scenario: Get a book by ISBN
    Given path '/books/9780141182636'
    When method get
    Then status 200
    And match response.title == 'The Great Gatsby'
    And match response.author == 'F. Scott Fitzgerald'
    And match response.isbn == '9780141182636'
    And match response.price == 9.99

  Scenario: Update a book
    Given path '/books/9780141182636'
    And request { price: 12.99 }
    When method put
    Then status 200
    And match response.price == 12.99

  Scenario: Delete a book
    Given path '/books/9780141182636'
    When method delete
    Then status 200
