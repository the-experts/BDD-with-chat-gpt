package com.example;

import com.intuit.karate.junit5.Karate;

public class BookstoreTest {

    @Karate.Test
    public Karate testBookstore() {
        return Karate.run("bookstore").relativeTo(getClass());
    }
}