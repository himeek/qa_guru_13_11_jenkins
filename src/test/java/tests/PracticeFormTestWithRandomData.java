package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class PracticeFormTestWithRandomData extends TestBase {

    @Test
    @DisplayName("Practice form page test")
    void successfulTest() {
        step("Open form page", () -> {
            practiceFormPage.openPage();
        });
        step("Fill out form", () -> {
            practiceFormPage.setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setUserEmail(testData.email)
                    .setGender(testData.gender)
                    .setUserNumber(testData.number)
                    .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                    .setSubjects(testData.subject)
                    .setUploadFile(testData.fileName)
                    .setHobbies(testData.hobbie)
                    .setCurrentAddress(testData.currentAddress)
                    .setState(testData.state)
                    .setCity(testData.city)
                    .submitClick();
        });
        step("Check results", () -> {
            practiceFormPage.checkResults("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResults("Student Email", testData.email)
                    .checkResults("Gender", testData.gender)
                    .checkResults("Mobile", testData.number)
                    .checkResults("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                    .checkResults("Subjects", testData.subject)
                    .checkResults("Hobbies", testData.hobbie)
                    .checkResults("Picture", testData.fileName)
                    .checkResults("Address", testData.currentAddress)
                    .checkResults("State and City", testData.state + " " + testData.city);
        });
    }
}
