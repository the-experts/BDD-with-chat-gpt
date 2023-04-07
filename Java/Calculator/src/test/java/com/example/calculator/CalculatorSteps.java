package com.example.calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void i_enter_and_select(String num1, String num2, String operation) {
        try {
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);

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
                break;
            case "power":
                result = calculator.power(previousResult, number);
                break;
        }
    }
}
