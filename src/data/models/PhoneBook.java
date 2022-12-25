package data.models;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private String ownersName;
    private  String ownersPhoneNumber;
    private List<Contact> contacts = new ArrayList<>();

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }

    public String getOwnersPhoneNumber() {
        return ownersPhoneNumber;
    }

    public void setOwnersPhoneNumber(String ownersPhoneNumber) {
        this.ownersPhoneNumber = ownersPhoneNumber;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
