package uk.co.gumtree.addressbook;

import org.apache.log4j.Logger;
import uk.co.gumtree.addressbook.bean.AddressBook;
import uk.co.gumtree.addressbook.bean.Contact;
import uk.co.gumtree.addressbook.enums.Gender;
import uk.co.gumtree.addressbook.service.AddressBookService;
import uk.co.gumtree.addressbook.service.InputReader;

import java.io.IOException;

public class Application {
    private static final Logger LOG = Logger.getLogger(Application.class);

    public static void main( String... args ) throws IOException {
        if (args.length != 1) {
            throw new IllegalArgumentException("Address book file path must be specified");
        }

        final AddressBook addressBook = new AddressBook();
        final AddressBookService addressBookService = new AddressBookService(addressBook);
        final InputReader inputReader = new InputReader(addressBookService);

        inputReader.read(args[0]);

        long numberOfMales = addressBookService.getCountByGender(Gender.MALE);
        Contact oldestContact = addressBookService.getOldestContact();
        long ageDifferenceInDays = addressBookService.getAgeDifferenceInDays("Bill McKnight", "Paul Robinson");

        LOG.info("Number of males " + numberOfMales);
        LOG.info("Oldest contact in address book " + oldestContact);
        LOG.info("Age difference in days between Bill and Paul " + ageDifferenceInDays);
    }

}
