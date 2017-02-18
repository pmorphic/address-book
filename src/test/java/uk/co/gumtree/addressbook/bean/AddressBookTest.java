package uk.co.gumtree.addressbook.bean;

import org.junit.Before;
import org.junit.Test;
import uk.co.gumtree.addressbook.enums.Gender;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {
    private AddressBook underTest;

    @Before
    public void setUp() throws Exception {
        this.underTest = new AddressBook();
    }

    @Test
    public void itShouldInitiallyBeEmpty() {
        assertEquals(0, underTest.getContacts().size());
    }

    @Test
    public void itShouldAddContactToAddressBook() throws ParseException {
        Contact contact = new Contact("name", Gender.F, new Date());
        underTest.addContact(contact);
        assertEquals(1, underTest.getContacts().size());
        assertEquals(contact, underTest.getContacts().get(0));
    }

    @Test
    public void itShouldEmptyListIfNoContacts() throws ParseException {
        assertEquals(0, underTest.getContacts().size());
    }

    @Test
    public void itShouldReturnImmutableListOfContacts() throws ParseException {
        Contact contact = new Contact("name", Gender.F, new Date());
        underTest.addContact(contact);
        List<Contact> actual = underTest.getContacts();

        try {
            actual.add(contact);
            fail("Expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {

        }
    }

}