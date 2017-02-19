package uk.co.gumtree.addressbook.service;

import org.junit.Test;
import uk.co.gumtree.addressbook.bean.Contact;
import uk.co.gumtree.addressbook.enums.Gender;

import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;

public class ContactFactoryTest {

    @Test
    public void itShouldCreateContactFromAddressBookFileLine() throws ParseException {
        Date expectedDob = ContactFactory.DOB_FORMATTER.parse("16/03/77");

        Contact contact = ContactFactory.fromAddressBookFileLine("Bill McKnight, Male, 16/03/77").get();

        assertEquals("Bill McKnight", contact.getName());
        assertEquals(Gender.MALE, contact.getGender());
        assertEquals(expectedDob, contact.getDateOfBirth());
    }

    @Test
    public void itShouldReturnNullIfUnableToParseDate() throws ParseException {
        Optional<Contact> contactOptional = ContactFactory.fromAddressBookFileLine("Bill McKnight, Male, 16-03-1977");

        assertFalse(contactOptional.isPresent());
    }

    @Test
    public void itShouldReturnNullIfInvalidGenderSpecified() throws ParseException {
        Optional<Contact> contactOptional = ContactFactory.fromAddressBookFileLine("Bill McKnight, None, 16/03/77");

        assertFalse(contactOptional.isPresent());
    }

    @Test
    public void itShouldReturnNullIfLineDoesNotHave3Parts() throws ParseException {
        assertFalse(ContactFactory.fromAddressBookFileLine("Bill McKnight, Male").isPresent());
        assertFalse(ContactFactory.fromAddressBookFileLine("Mary McKnight, Female, 16/03/77, UK").isPresent());
    }
}