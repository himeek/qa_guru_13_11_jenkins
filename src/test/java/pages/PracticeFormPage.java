package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    public CalendarComponent calenderComponent = new CalendarComponent();

    public ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderSelect = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            fileInput = $("#uploadPicture"),
            hobbiesCheck = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit");

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public PracticeFormPage setGender(String value) {
        genderSelect.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calenderComponent.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage setSubjects(String value) {
        subjectsInput.sendKeys(value);
        subjectsInput.pressEnter();

        return this;
    }

    public PracticeFormPage setUploadFile(String value) {
        fileInput.uploadFromClasspath(value);

        return this;
    }

    public PracticeFormPage setHobbies(String value) {
        hobbiesCheck.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public PracticeFormPage setState(String value) {
        stateInput.click();
        $(byText(value)).click();

        return this;
    }

    public PracticeFormPage setCity(String value) {
        cityInput.click();
        $(byText(value)).click();

        return this;
    }

    public PracticeFormPage submitClick() {
        submitButton.click();

        return this;
    }

    public PracticeFormPage checkResults(String key, String value) {
        resultsTableComponent.checkResult(key, value);

        return this;
    }
}