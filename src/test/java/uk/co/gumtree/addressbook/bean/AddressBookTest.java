package uk.co.gumtree.addressbook.bean;

import org.junit.Before;
import org.junit.Test;

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

}