package uk.co.gumtree.addressbook.bean;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressBook {
    private final List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<Contact>();
    }

    public List<Contact> getContacts() {
        return ImmutableList.copyOf(contacts);
    }

    public void addContact(Contact contact) {
        Optional<Contact> contactOptional = contacts.stream().filter(e -> e.getName().equalsIgnoreCase(contact.getName())).findAny();
        if (!contactOptional.isPresent()) {
            contacts.add(contact);
        }
    }
}
