package uk.co.gumtree.addressbook.service;

import org.apache.log4j.Logger;
import uk.co.gumtree.addressbook.bean.AddressBook;
import uk.co.gumtree.addressbook.bean.Contact;
import uk.co.gumtree.addressbook.enums.Gender;

import java.util.Optional;

public class AddressBookService {
    private static final Logger LOG = Logger.getLogger(AddressBookService.class);
    private final AddressBook addressBook;

    public AddressBookService(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public long getCountByGender(Gender gender) {
        return addressBook.getContacts()
                .stream()
                .filter(e -> e.getGender() == gender)
                .count();
    }

    public Contact getOldestContact() {
        return addressBook.getContacts()
                .stream()
                .sorted((e1, e2) -> e1.getDateOfBirth().compareTo(e2.getDateOfBirth()))
                .findFirst()
                .get();
    }

    public Contact getContactByName(String name) {
        return addressBook.getContacts()
                .stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .findFirst()
                .get();
    }

    public void addContact(Contact contact) {
        Optional<Contact> contactOptional = addressBook.getContacts()
                .stream()
                .filter(e -> e.getName().equalsIgnoreCase(contact.getName()))
                .findAny();

        if (contactOptional.isPresent()) {
            LOG.error("Unable to add contact as name (" + contact.getName() + ") already exists");
            return;
        }

        addressBook.addContact(contact);

    }

}
