import math


class Calculator:
    def __init__(self):
        self.reset()

    def reset(self):
        self.current_result = 0
        self.operands = []

    def input_number(self, num):
        self.operands.append(num)

    def add(self):
        self.current_result += sum(self.operands)
        self.current_result = round(self.current_result, 2)
        self.operands = []

    def subtract(self):
        self.current_result = self.operands[0]
        for operand in self.operands[1:]:
            self.current_result -= operand
        self.operands = []


    def multiply(self):
        self.current_result = math.prod(self.operands)
        self.operands = []

    def divide(self):
        if 0 in self.operands:
            raise ZeroDivisionError("Division by zero is not allowed")
        self.current_result /= math.prod(self.operands)
        self.operands = []

    def power(self):
        self.current_result = self.operands[0] ** self.operands[1]
        self.operands = []

    def square_root(self):
        if self.operands[0] < 0:
            raise ValueError("Square root of negative number is not allowed")
        self.current_result = math.sqrt(self.operands[0])
        self.operands = []

    def factorial(self):
        if self.operands[0] < 0:
            raise ValueError("Factorial of negative number is not allowed")
        self.current_result = math.factorial(int(self.operands[0]))
        self.operands = []

    def natural_log(self):
        if self.operands[0] <= 0:
            raise ValueError("Natural logarithm of non-positive number is not allowed")
        self.current_result = math.log(self.operands[0])
        self.operands = []

    def log_base_10(self):
        if self.operands[0] <= 0:
            raise ValueError("Logarithm of non-positive number is not allowed")
        self.current_result = math.log10(self.operands[0])
        self.operands = []

    def sine(self, in_radians=True):
        self.current_result = math.sin(self.operands[0] if in_radians else math.radians(self.operands[0]))
        self.operands = []

    def cosine(self, in_radians=True):
        self.current_result = math.cos(self.operands[0] if in_radians else math.radians(self.operands[0]))
        self.operands = []

    def tangent(self, in_radians=True):
        self.current_result = math.tan(self.operands[0] if in_radians else math.radians(self.operands[0]))
        self.operands = []

    def memory_store(self):
        self.memory = self.current_result

    def memory_recall(self):
        self.current_result = self.memory

    def memory_add(self):
        self.memory += self.current_result

    def memory_subtract(self):
        self.memory -= self.current_result

    def memory_clear(self):
        self.memory = 0

    def get_output(self):
        return self.current_result
