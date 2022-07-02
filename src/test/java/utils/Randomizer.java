package utils;

import java.util.Random;

public class Randomizer {

    public static String randomGender() {

        String[] gender = {"Male", "Female", "Other"};
        String random = (gender[new Random().nextInt(gender.length)]);
        return random;
    }

    public static String randomSubjects() {

        String[] subject = {"English", "German", "Biology", "Hindi", "Chemistry", "Maths"};
        String random = (subject[new Random().nextInt(subject.length)]);
        return random;
    }

    public static String randomHobbie() {

        String[] hobby = {"Sports", "Reading"};
        String random = (hobby[new Random().nextInt(hobby.length)]);
        return random;
    }

    public static String randomMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        String random = (month[new Random().nextInt(month.length)]);
        return random;
    }

}
