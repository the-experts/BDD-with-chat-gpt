Feature: Calculator App Test Cases

  Scenario Outline: Basic arithmetic operations
    Given I have a calculator app
    When I enter "<num1>" and "<num2>" and select "<operation>"
    Then the result should be "<result>"

    Examples:
      | num1 | num2 | operation | result |
      | 5    | 3    | add       | 8      |
      | 7    | 4    | subtract  | 3      |
      | 6    | 3    | multiply  | 18     |
      | 15   | 5    | divide    | 3      |
      | 3    | 3    | power     | 27     |
      | -2   | 3    | add       | 1      |
      | 9    | -3   | subtract  | 12     |
      | -4   | -5   | multiply  | 20     |
      | -12  | 4    | divide    | -3     |
      | 2    | -3   | power     | 0.125  |
  Scenario: Attempting division by zero
    Given I have a calculator app
    When I enter "10" and "0" and select "divide"
    Then the calculator should display an error message

  Scenario: Entering non-numeric values
    Given I have a calculator app
    When I enter "text" and "7" and select "add"
    Then the calculator should display an input validation error

  Scenario: Entering decimal values
    Given I have a calculator app
    When I enter "5.5" and "3.5" and select "add"
    Then the result should be "9"

  Scenario: Using the result of a previous calculation
    Given I have a calculator app
    And I enter "6" and "4" and select "add"
    When I use the result "10" and enter "2" and select "multiply"
    Then the result should be "20"

  Scenario: Calculating Exponents
    Given I have a calculator app
    When I enter "2" and "3" and select "power"
    Then the result should be "8"

    Given I have a calculator app
    When I enter "2.5" and "-2" and select "power"
    Then the result should be "0.16"

  Scenario: Calculating Square Roots
    Given I have a calculator app
    When I enter "25" and select "square root"
    Then the result should be "5"

    Given I have a calculator app
    When I enter "-9" and select "square root"
    Then the calculator should display an arithmetic error message

  Scenario: Calculating the Function of a Number
    Given I have a calculator app
    When I enter "4" and select "factorial"
    Then the result should be "24"

    Given I have a calculator app
    When I enter "0" and select "factorial"
    Then the result should be "1"

    Given I have a calculator app
    When I enter "-5" and select "factorial"
    Then the calculator should display an arithmetic error message

  Scenario: Calculating Logarithms
    Given I have a calculator app
    When I enter "10" and select "log base 10"
    Then the result should be "1"

    Given I have a calculator app
    When I enter "2.718281828" and select "natural log"
    Then the result should be "1"
