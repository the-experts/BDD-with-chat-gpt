from behave import *

from requests import *

@given(u'url \'http://localhost:8000\'')
def step_impl(context):
    context.base_url = 'http://localhost:8000'

@given('path \'/books\'')
def step_impl(context):
    context.url = context.base_url + '/books'


@given('path \'/books/12345\'')
def step_impl(context):
    context.url = context.base_url + '/books/12345'


# @given('request \{ "title": \'Book 2\', "author": \'Author2\', "isbn": \'12345\', "price": 20.0 }')
@given('request { "title": \"{title}\", "author": \"{author}\", "isbn": \"{isbn}\", "price": {price} }')
def step_impl(context, title, author, isbn, price):
    context.request = {
        "title": title,
        "author": author,
        "isbn": isbn,
        "price": price
    }


@when('method post')
def step_impl(context):
    context.response = post(context.url, json=context.request)


@when('method get')
def step_impl(context):
    context.response = get(context.url)


@when('method delete')
def step_impl(context):
    context.response = delete(context.url)


@when('method put')
def step_impl(context):
    context.response = put(context.url, json=context.request)


@then('status {status}')
def step_impl(context, status):
    assert context.response.status_code == int(status)


@then('match response == {response}')
def step_impl(context, response):
    expected_response = eval(response)
    assert context.response.json() == expected_response


@then('match response contains {response}')
def step_impl(context, response):
    expected_response = eval(response)
    assert expected_response in context.response.json()

