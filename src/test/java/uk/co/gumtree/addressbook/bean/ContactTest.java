package uk.co.gumtree.addressbook.bean;

import org.junit.Test;
import uk.co.gumtree.addressbook.enums.Gender;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void itShouldCreate() throws ParseException {
        Date dob = Calendar.getInstance().getTime();

        Contact contact = new Contact("Bill McKnight", Gender.MALE, dob);

        assertEquals("Bill McKnight", contact.getName());
        assertEquals(Gender.MALE, contact.getGender());
        assertEquals(dob, contact.getDateOfBirth());
    }

}