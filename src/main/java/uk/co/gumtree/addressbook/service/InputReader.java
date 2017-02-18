package uk.co.gumtree.addressbook.service;

import uk.co.gumtree.addressbook.bean.AddressBook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InputReader {

    public AddressBook read(String filePath) throws IOException {
        Files.lines(Paths.get(filePath)).forEach(System.out::println);
        return new AddressBook();
    }

}
