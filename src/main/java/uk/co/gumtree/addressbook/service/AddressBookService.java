package uk.co.gumtree.addressbook.service;

import uk.co.gumtree.addressbook.bean.AddressBook;
import uk.co.gumtree.addressbook.bean.Contact;
import uk.co.gumtree.addressbook.enums.Gender;

public class AddressBookService {
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

}
