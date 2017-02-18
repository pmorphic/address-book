package uk.co.gumtree.addressbook.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.gumtree.addressbook.bean.AddressBook;
import uk.co.gumtree.addressbook.bean.Contact;
import uk.co.gumtree.addressbook.enums.Gender;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddressBookServiceTest {
    @Mock private AddressBook addressBook;
    private AddressBookService underTest;

    @Before
    public void setup() {
        this.underTest = new AddressBookService(addressBook);
    }

    @Test
    public void itShouldReturn0NumberOfMalesIfAddressBookEmpty() {
        when(addressBook.getContacts()).thenReturn(new ArrayList<Contact>());

        int actual = underTest.getCountByGender(Gender.M);
        assertEquals(0, actual);
    }
}