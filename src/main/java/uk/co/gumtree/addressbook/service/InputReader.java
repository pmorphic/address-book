package uk.co.gumtree.addressbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class InputReader {

    private final AddressBookService addressBookService;

    @Autowired
    public InputReader(AddressBookService addressBookService,
                       @Value("${input.file.path}") Resource inputResource) throws IOException {
        this.addressBookService = addressBookService;
        read(inputResource);
    }

    private void read(Resource inputResource) throws IOException {
        Files.lines(Paths.get(inputResource.getURI()))
                .map(ContactFactory::fromAddressBookFileLine)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(addressBookService::addContact);
    }

}
