package uk.co.gumtree.addressbook.service;

import org.apache.log4j.Logger;
import uk.co.gumtree.addressbook.bean.Contact;
import uk.co.gumtree.addressbook.enums.Gender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ContactFactory {
    public static final SimpleDateFormat DOB_FORMATTER = new SimpleDateFormat("d/M/yy");
    private static final Logger LOG = Logger.getLogger(ContactFactory.class);

    public static Optional<Contact> fromAddressBookFileLine(String line) {
        try {
            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Address book line must be of format '<name>,<gender>,<date of birth>'");
            }
            return Optional.of(buildContact(parts));
        }  catch (ParseException e) {
            LOG.error("Unable to import contact - " + line +", as date of birth should be in format (dd/MM/yy)", e);
        }  catch (NoSuchElementException e) {
            LOG.error("Unable to import contact - " + line +", as gender must be either (Male/Female)", e);
        } catch (Exception e) {
            LOG.error("Unable to import contact - " + line, e);
        }
        return Optional.empty();
    }

    private static Contact buildContact(String[] parts) throws ParseException {
        String name = parts[0].trim();
        Gender gender = Gender.fromName(parts[1].trim());
        Date dateOfBirth = DOB_FORMATTER.parse(parts[2].trim());
        return new Contact(name, gender, dateOfBirth);
    }

}
