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

    def get_output(self):
        return self.current_result
