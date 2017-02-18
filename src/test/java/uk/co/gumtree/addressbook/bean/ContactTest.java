package uk.co.gumtree.addressbook.bean;

import org.junit.Test;
import uk.co.gumtree.addressbook.enums.Gender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void itShouldCreateContactFromAddressBookFileLine() throws ParseException {
        Date expectedDob = Contact.DOB_FORMATTER.parse("16/03/77");

        Contact contact = new Contact("Bill McKnight, Male, 16/03/77");

        assertEquals("Bill McKnight", contact.getName());
        assertEquals(Gender.M, contact.getGender());
        assertEquals(expectedDob, contact.getDateOfBirth());
    }

}