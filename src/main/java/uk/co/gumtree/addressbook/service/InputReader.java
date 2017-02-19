package uk.co.gumtree.addressbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.gumtree.addressbook.bean.AddressBook;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;

@Service
public class InputReader {

    private final AddressBookService addressBookService;

    @Autowired
    public InputReader(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    public void read(String filePath) throws IOException {
        Files.lines(Paths.get(filePath))
                .map(ContactFactory::fromAddressBookFileLine)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(addressBookService::addContact);
    }

}
