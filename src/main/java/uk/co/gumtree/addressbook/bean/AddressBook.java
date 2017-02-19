package uk.co.gumtree.addressbook.bean;

import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddressBook {
    private final List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<Contact>();
    }

    public List<Contact> getContacts() {
        return ImmutableList.copyOf(contacts);
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }
}
