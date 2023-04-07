package com.example.calculator;

public class Calculator {

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("division by zero");
        }
        return num1 / num2;
    }

    public double power(double num1, double num2) {
        return Math.pow(num1, num2);
    }

    public String validateInputs(String num1, String num2) {
        try {
            Double.parseDouble(num1);
            Double.parseDouble(num2);
        } catch (NumberFormatException e) {
            return "input validation error";
        }
        return "";
    }
}
