package uk.co.gumtree.addressbook;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import uk.co.gumtree.addressbook.bean.AddressBook;
import uk.co.gumtree.addressbook.bean.Contact;
import uk.co.gumtree.addressbook.enums.Gender;
import uk.co.gumtree.addressbook.service.AddressBookService;
import uk.co.gumtree.addressbook.service.InputReader;

import java.io.IOException;

@SpringBootApplication
public class Application {
    private static final Logger LOG = Logger.getLogger(Application.class);

    public static void main( String... args ) throws IOException {
        final ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        final AddressBookService addressBookService = ctx.getBean(AddressBookService.class);

        long numberOfMales = addressBookService.getCountByGender(Gender.MALE);
        Contact oldestContact = addressBookService.getOldestContact();
        long ageDifferenceInDays = addressBookService.getAgeDifferenceInDays("Bill McKnight", "Paul Robinson");

        LOG.info("Number of males " + numberOfMales);
        LOG.info("Oldest contact in address book " + oldestContact);
        LOG.info("Age difference in days between Bill and Paul " + ageDifferenceInDays);
    }

}
