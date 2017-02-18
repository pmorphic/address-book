package uk.co.gumtree.addressbook.service;


import org.junit.Before;
import org.junit.Test;
import uk.co.gumtree.addressbook.bean.AddressBook;

import static org.junit.Assert.assertNotNull;

public class InputReaderTest {
    private InputReader underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new InputReader();
    }

    @Test
    public void itShouldReturnAddressBookForGivenInputFile() {
        String filePath = getClass().getResource("/addressBookValid").getPath();
        AddressBook addressBook = underTest.read(filePath);
        assertNotNull(addressBook);
    }

}