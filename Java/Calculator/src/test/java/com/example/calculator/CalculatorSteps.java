package com.example.calculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.*;

public class CalculatorSteps {
    Calculator calculator;
    double result;
    String errorMessage;

    @Given("I have a calculator app")
    public void i_have_a_calculator_app() {
        calculator = new Calculator();
        result = 0;
        errorMessage = "";
    }

    @When("I enter {string} and {string} and select {string}")
    public void i_enter_and_enter_and_select(String num1, String num2, String operation) {
        try {
            double number1 = Double.parseDouble(num1);
            boolean inRadians = false;
            double number2 = 0;
            if(num2.equals("true") || num2.equals("false")){
                inRadians = Boolean.parseBoolean(num2);
            } else {
                number2 = Double.parseDouble(num2);
            }



            switch (operation) {
                case "add":
                    result = calculator.add(number1, number2);
                    break;
                case "subtract":
                    result = calculator.subtract(number1, number2);
                    break;
                case "multiply":
                    result = calculator.multiply(number1, number2);
                    break;
                case "divide":
                    try {
                        result = calculator.divide(number1, number2);
                    } catch (ArithmeticException e) {
                        errorMessage = e.getMessage();
                    }
                    break;
                case "power":
                    result = calculator.power(number1, number2);
                    break;
                case "square root":
                    try {
                        result = calculator.squareRoot(number1);
                    } catch (ArithmeticException e) {
                        errorMessage = e.getMessage();
                    }
                    break;
                case "factorial":
                    try {
                        result = calculator.factorial((int) number1);
                    } catch (IllegalArgumentException e) {
                        errorMessage = e.getMessage();
                    }
                    break;
                case "log base 10":
                    result = calculator.logBase10(number1);
                    break;
                case "natural log":
                    result = calculator.naturalLog(number1);
                    break;
                case "sin":
                    result = calculator.sin(number1);
                    break;
                case "cos":
                    result = calculator.cos(number1);
                    break;
                case "tan":
                    result = calculator.tan(number1);
                    break;
            }
        } catch (NumberFormatException e) {
            errorMessage = "input validation error";
        }
    }

    @When("I enter {string} and select {string}")
    public void i_enter_and_select(String num1, String operation) {
        try {
            double number1 = Double.parseDouble(num1);

            switch (operation) {
                case "square root":
                    try {
                        result = calculator.squareRoot(number1);
                    } catch (ArithmeticException e) {
                        errorMessage = e.getMessage();
                    }
                    break;
                case "factorial":
                    try {
                        result = calculator.factorial((int) number1);
                    } catch (IllegalArgumentException e) {
                        errorMessage = e.getMessage();
                    }
                    break;
                case "log base 10":
                    result = calculator.logBase10(number1);
                    break;
                case "natural log":
                    result = calculator.naturalLog(number1);
                    break;
            }
        } catch (NumberFormatException e) {
            errorMessage = "input validation error";
        }
    }

    @Then("the result should be {string}")
    public void the_result_should_be(String expectedResult) {
        assertEquals(Double.parseDouble(expectedResult), result, 0.0001);
    }

    @Then("the calculator should display an error message")
    public void the_calculator_should_display_an_error_message() {
        assertTrue(errorMessage.contains("division by zero"));
    }
    @Then("the calculator should display an arithmetic error message")
    public void the_calculator_should_display_an_arithmetic_error_message() {
        System.out.println(errorMessage);
        assertTrue(errorMessage.contains("cannot calculate"));
    }

    @Then("the calculator should display an input validation error")
    public void the_calculator_should_display_an_input_validation_error() {
        // Assuming your calculator.validateInputs() method returns an error message if inputs are not valid
        errorMessage = calculator.validateInputs("text", "7");
        assertTrue(errorMessage.contains("input validation error"));
    }

    @When("I use the result {string} and enter {string} and select {string}")
    public void i_use_the_result_and_enter_and_select(String prevResult, String num, String operation) {
        double previousResult = Double.parseDouble(prevResult);
        double number = Double.parseDouble(num);

        switch (operation) {
            case "add":
                result = calculator.add(previousResult, number);
                break;
            case "subtract":
                result = calculator.subtract(previousResult, number);
                break;
            case "multiply":
                result = calculator.multiply(previousResult, number);
                break;
            case "divide":
                try {
                    result = calculator.divide(previousResult, number);
                } catch (ArithmeticException e) {
                    errorMessage = e.getMessage();
                }
        }
    }

}
