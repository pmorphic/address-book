package uk.co.gumtree.addressbook.service;

import uk.co.gumtree.addressbook.bean.AddressBook;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class InputReader {

    private final AddressBookService addressBookService;

    public InputReader(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    public void read(String filePath) throws IOException {
        Files.lines(Paths.get(filePath))
                .map(ContactFactory::fromAddressBookFileLine)
                .filter(Objects::nonNull)
                .forEach(addressBookService::addContact);
    }

}
