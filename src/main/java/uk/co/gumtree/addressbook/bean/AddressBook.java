package uk.co.gumtree.addressbook.bean;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private final List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<Contact>();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

}
