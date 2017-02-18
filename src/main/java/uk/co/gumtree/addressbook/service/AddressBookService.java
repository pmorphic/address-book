package uk.co.gumtree.addressbook.service;

import uk.co.gumtree.addressbook.bean.AddressBook;
import uk.co.gumtree.addressbook.enums.Gender;

public class AddressBookService {
    private final AddressBook addressBook;

    public AddressBookService(AddressBook addressBook) {
        this.addressBook = addressBook;
    }


    public int getCountByGender(Gender gender) {
        return 0;
    }
}
