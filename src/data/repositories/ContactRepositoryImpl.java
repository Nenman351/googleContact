package data.repositories;

import data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository{

    private List<Contact> contacts = new ArrayList<>();

    @Override
    public Contact findById(String phoneNumber) {
        for (Contact contact1: contacts){
            String storedContact = contact1.getPhoneNumber();
            boolean contactMatches = storedContact.equals(phoneNumber);
            if (contactMatches) return contact1;
        }
        return null;
    }

    @Override
    public Contact save(Contact contact) {
        Contact savedContact = findById(contact.getPhoneNumber());
        if(savedContact == null)contacts.add(contact);
        else
            updateSavedContact(contact, savedContact);
        return contact;
    }

    private void updateSavedContact(Contact contact, Contact savedContact){
        savedContact.setFirstName(contact.getFirstName());
        savedContact.setLastName(contact.getLastName());
        savedContact.setPhoneNumber(contact.getPhoneNumber());
    }

    @Override
    public void delete(Contact contact) {

    }

    @Override
    public int count() {
        return contacts.size();
    }
}
