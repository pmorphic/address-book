package uk.co.gumtree.addressbook.service;

import org.junit.Test;
import uk.co.gumtree.addressbook.bean.Contact;
import uk.co.gumtree.addressbook.enums.Gender;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

public class ContactFactoryTest {

    @Test
    public void itShouldCreateContactFromAddressBookFileLine() throws ParseException {
        Date expectedDob = ContactFactory.DOB_FORMATTER.parse("16/03/77");

        Contact contact = ContactFactory.fromAddressBookFileLine("Bill McKnight, Male, 16/03/77");

        assertEquals("Bill McKnight", contact.getName());
        assertEquals(Gender.M, contact.getGender());
        assertEquals(expectedDob, contact.getDateOfBirth());
    }

    @Test
    public void itShouldReturnNullIfUnableToParseDate() throws ParseException {
        Contact contact = ContactFactory.fromAddressBookFileLine("Bill McKnight, Male, 16-03-1977");

        assertNull(contact);
    }

    @Test
    public void itShouldReturnNullIfInvalidGenderSpecified() throws ParseException {
        Contact contact = ContactFactory.fromAddressBookFileLine("Bill McKnight, None, 16/03/77");

        assertNull(contact);
    }

    @Test
    public void itShouldReturnNullIfLineDoesNotHave3Parts() throws ParseException {
        assertNull(ContactFactory.fromAddressBookFileLine("Bill McKnight, Male"));
        assertNull(ContactFactory.fromAddressBookFileLine("Mary McKnight, Female, 16/03/77, UK"));
    }
}