package uk.co.gumtree.addressbook.enums;

import org.junit.Test;

import static org.junit.Assert.*;

public class GenderTest {

    @Test
    public void itShouldReturnEnumFromName() {
        assertEquals(Gender.MALE, Gender.fromName("Male"));
        assertEquals(Gender.FEMALE, Gender.fromName("Female"));
    }

}