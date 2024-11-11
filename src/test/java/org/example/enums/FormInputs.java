package org.example.enums;

public enum FormInputs {
    FIRST_NAME("Victor"),
    LAST_NAME("Dabija"),
    USER_EMAIL("dabija.victor@ceiti.com"), // Replace with your actual email
    GENDER("Male"),
    PHONE_NUMBER("1078727091"), // Replace with your actual phone number
    DATE_OF_BIRTH("30 Jul 2005"),
    SUBJECT_MATH("Maths"),
    SUBJECT_BIOLOGY("Biology"),
    SPORTS_HOBBY_ID("hobbies-checkbox-1"),
    MUSIC_HOBBY_ID("hobbies-checkbox-3"),
    HOBBIES("Sports, Music"),
    FILE_PATH("/home/victor/college/testare/automatedTesting/src/test/resources/pictures/user.png"), // Adjust the path if needed
    ADDRESS("Răspopeni"), // Update with your actual address if different
    STATE("NCR"),
    CITY("Delhi");

    private final String value;

    FormInputs(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
