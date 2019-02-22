package com.ds.testdata;

import java.util.Locale;

import org.apache.commons.lang3.RandomStringUtils;

import com.ds.model.User;
import com.github.javafaker.Faker;

/**
 * This class is used to create Fake Test Data
 */
public class TestDataGenerator {

    private Faker faker;

    public TestDataGenerator() {

        faker = new Faker(new Locale("en"));
    }

    public String name() {
        return faker.name().name();
    }

    public String email() {
        return faker.internet().emailAddress();
    }

    public String password() {
        return faker.internet().password(6, 20);
    }

    public String text() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    /**
     * Create and return a fake User Object
     *
     * @return
     */
    public static User createUser() {
        TestDataGenerator testData = new TestDataGenerator();
        String name = testData.name();
        String email = testData.email();
        String password = testData.password();
        User user = new User(name, email, password, password);
        return user;
    }
}
