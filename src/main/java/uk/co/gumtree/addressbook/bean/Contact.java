package uk.co.gumtree.addressbook.bean;

import uk.co.gumtree.addressbook.enums.Gender;

import java.text.ParseException;
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
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append('}');
        return sb.toString();
    }

}
