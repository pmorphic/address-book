package uk.co.gumtree.addressbook.enums;

import java.util.Arrays;

public enum Gender {
    M("Male"),
    F("Female");

    private String name;

    private Gender(String name) {
        this.name = name;
    }

    public static Gender fromName(String name) {
        return Arrays.stream(Gender.values()).filter(e -> e.name.equals(name)).findAny().get();
    }
}
