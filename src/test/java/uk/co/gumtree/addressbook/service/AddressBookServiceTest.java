package uk.co.gumtree.addressbook.service;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.gumtree.addressbook.bean.AddressBook;
import uk.co.gumtree.addressbook.bean.Contact;
import uk.co.gumtree.addressbook.enums.Gender;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddressBookServiceTest {
    @Mock private AddressBook addressBook;
    private Contact oldestContact = ContactFactory.fromAddressBookFileLine("Wes Jackson, Male, 14/08/74");

    private AddressBookService underTest;

    @Before
    public void setup() {
        this.underTest = new AddressBookService(addressBook);
    }

    @Test
    public void itShouldReturn0NumberOfMalesIfAddressBookEmpty() {
        when(addressBook.getContacts()).thenReturn(new ArrayList<Contact>());

        long actual = underTest.getCountByGender(Gender.M);

        assertEquals(0, actual);
    }

    @Test
    public void itShouldReturnNumberOfMales() {
        when(addressBook.getContacts()).thenReturn(getDefaultContacts());

        long actual = underTest.getCountByGender(Gender.M);

        assertEquals(3, actual);
    }

    @Test
    public void itShouldReturnNumberOfFemales() {
        when(addressBook.getContacts()).thenReturn(getDefaultContacts());

        long actual = underTest.getCountByGender(Gender.F);

        assertEquals(2, actual);
    }

    @Test
    public void itShouldReturnOldestPerson() {
        when(addressBook.getContacts()).thenReturn(getDefaultContacts());

        Contact actual = underTest.getOldestContact();

        assertEquals(oldestContact, actual);
    }

    @Test
    public void getOldestPersonShouldReturnContactIfOnly1ContactInAddressBook() {
        when(addressBook.getContacts()).thenReturn(ImmutableList.of(oldestContact));

        Contact actual = underTest.getOldestContact();

        assertEquals(oldestContact, actual);
    }

    @Test
    public void getOldestPersonShouldReturnNullIfNoContactInAddressBook() {
        when(addressBook.getContacts()).thenReturn(ImmutableList.of(oldestContact));

        Contact actual = underTest.getOldestContact();

        assertEquals(oldestContact, actual);
    }

    private List<Contact> getDefaultContacts() {
        Contact contact1 = ContactFactory.fromAddressBookFileLine("Bill McKnight, Male, 16/03/77");
        Contact contact2 = ContactFactory.fromAddressBookFileLine("Paul Robinson, Male, 15/01/85");
        Contact contact3 = ContactFactory.fromAddressBookFileLine("Gemma Lane, Female, 20/11/91");
        Contact contact4 = ContactFactory.fromAddressBookFileLine("Sarah Stone, Female, 20/09/80");
        return ImmutableList.of(contact1, contact2, contact3, contact4, oldestContact);
    }

}