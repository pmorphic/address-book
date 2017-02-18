package uk.co.gumtree.addressbook.bean;

import uk.co.gumtree.addressbook.enums.Gender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact {
    static final SimpleDateFormat DOB_FORMATTER = new SimpleDateFormat("d/M/yy");

    private String name;
    private Gender gender;
    private Date dateOfBirth;

    public Contact(String addressBookLine) throws ParseException {
        String[] parts = addressBookLine.split(",");
        this.name = parts[0].trim();
        this.gender = Gender.fromName(parts[1].trim());
        this.dateOfBirth = DOB_FORMATTER.parse(parts[2].trim());
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
