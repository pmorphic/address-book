package uk.co.gumtree.addressbook.service;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.gumtree.addressbook.bean.AddressBook;
import uk.co.gumtree.addressbook.bean.Contact;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class)
public class InputReaderTest {
    private InputReader underTest;
    @Mock
    AddressBookService addressBookService;

    @Before
    public void setUp() throws Exception {
        underTest = new InputReader(addressBookService);
    }

    @Test
    public void itShouldReturnAddressBookForGivenInputFile() throws IOException {
        String filePath = getClass().getResource("/addressBookValid").getPath();

        underTest.read(filePath);

        verify(addressBookService, times(5)).addContact(isA(Contact.class));
    }

    @Test
    public void itShouldIgnoreInvalidAddressBookLines() throws IOException {
        String filePath = getClass().getResource("/addressBookInvalid").getPath();

        underTest.read(filePath);

        verifyZeroInteractions(addressBookService);
    }

}