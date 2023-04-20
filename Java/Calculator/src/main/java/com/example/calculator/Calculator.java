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

    public double squareRoot(double num) {
        if (num < 0) {
            throw new ArithmeticException("cannot calculate square root of a negative number");
        }
        return Math.sqrt(num);
    }

    public int factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("cannot calculate factorial of a negative number");
        }
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    public double logBase10(double num) {
        if (num <= 0) {
            throw new ArithmeticException("cannot calculate logarithm of a non-positive number");
        }
        return Math.log10(num);
    }

    public double naturalLog(double num) {
        if (num <= 0) {
            throw new ArithmeticException("cannot calculate natural logarithm of a non-positive number");
        }
        return Math.log(num);
    }

    public double sin(double num) {
        return Math.sin(num);
    }

    public double cos(double num) {
        return Math.cos(Math.toRadians(num));
    }

    public double tan(double num) {
        return Math.tan(Math.toRadians(num));
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
