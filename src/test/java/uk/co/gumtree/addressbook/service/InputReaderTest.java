package uk.co.gumtree.addressbook.service;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
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
    @Mock
    AddressBookService addressBookService;

    @Test
    public void itShouldReadForGivenInputFile() throws IOException {
        Resource inputResource = new ClassPathResource("/addressBookValid");

        new InputReader(addressBookService, inputResource);

        verify(addressBookService, times(5)).addContact(isA(Contact.class));
    }

    @Test
    public void itShouldIgnoreInvalidAddressBookLines() throws IOException {
        Resource inputResource = new ClassPathResource("/addressBookInvalid");

        new InputReader(addressBookService, inputResource);

        verifyZeroInteractions(addressBookService);
    }

}