package uk.co.gumtree.addressbook.bean;

import uk.co.gumtree.addressbook.enums.Gender;
import uk.co.gumtree.addressbook.service.ContactFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact {
    private String name;
    private Gender gender;
    private Date dateOfBirth;

    public Contact(String name, Gender gender, Date dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact{");
        sb.append("name='").append(name).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", dateOfBirth=").append(ContactFactory.DOB_FORMATTER.format(dateOfBirth));
        sb.append('}');
        return sb.toString();
    }

}
