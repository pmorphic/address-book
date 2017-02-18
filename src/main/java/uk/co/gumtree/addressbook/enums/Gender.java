package uk.co.gumtree.addressbook.enums;

public enum Gender {
    M("Male"),
    F("Female");

    private String name;

    private Gender(String name) {
        this.name = name;
    }
}
