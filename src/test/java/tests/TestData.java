package tests;

import com.github.javafaker.Faker;
import utils.Randomizer;

public class TestData {
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = Randomizer.randomGender(),
            number = faker.number().digits(10),
            dayOfBirth = String.valueOf(faker.number().numberBetween(10, 20)),
            monthOfBirth = Randomizer.randomMonth(),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1950, 2005)),
            subject = Randomizer.randomSubjects(),
            fileName = "avatar.png",
            hobbie = Randomizer.randomHobbie(),
            currentAddress = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";
}
