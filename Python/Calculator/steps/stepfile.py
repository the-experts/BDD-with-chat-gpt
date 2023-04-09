from behave import given, when, then

from Calculator import Calculator

@given('de rekenmachine is ingeschakeld')
def step_impl(context):
    context.calc = Calculator()


@when('ik twee getallen invoer: {num1:d} en {num2:d}')
def step_impl(context, num1, num2):
    context.calc.input_number(num1)
    context.calc.input_number(num2)

@when('ik twee decimalen invoer: {num1:f} en {num2:f}')
def step_impl(context, num1, num2):
    context.calc.input_number(num1)
    context.calc.input_number(num2)

@when('ik twee negatieve getallen invoer: {num1:d} en {num2:d}')
def step_impl(context, num1, num2):
    context.calc.input_number(num1)
    context.calc.input_number(num2)

@when('ik meerdere getallen invoer: {num1:d}, {num2:d}, {num3:d} en {num4:d}')
def step_impl(context, num1, num2, num3, num4):
    context.calc.input_number(num1)
    context.calc.input_number(num2)
    context.calc.input_number(num3)
    context.calc.input_number(num4)

@when('ik de optelknop indruk')
def step_impl(context):
    context.calc.add()

@when('ik de aftrekknop indruk')
def step_impl(context):
    context.calc.subtract()

@when('ik de vermenigvuldigknop indruk')
def step_impl(context):
    context.calc.multiply()

@when('ik de deelknop indruk')
def step_impl(context):
    context.calc.divide()

@then('zou de uitvoer gelijk moeten zijn aan {result:d}')
def step_impl(context, result):
    assert context.calc.get_output() == result

@then('zou de uitvoer gelijk moeten zijn aan {result:f}')
def step_impl(context, result):
    assert context.calc.get_output() == result
