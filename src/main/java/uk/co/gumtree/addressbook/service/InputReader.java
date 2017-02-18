package uk.co.gumtree.addressbook.service;

import uk.co.gumtree.addressbook.bean.AddressBook;
import uk.co.gumtree.addressbook.bean.Contact;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Objects;

public class InputReader {

    public AddressBook read(String filePath) throws IOException {
        AddressBook addressBook = new AddressBook();
        Files.lines(Paths.get(filePath))
                .map(s -> {
                            try {
                                return new Contact(s);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                    )
                .filter(Objects::nonNull)
                .forEach(e -> addressBook.addContact(e));
        return addressBook;
    }

}
