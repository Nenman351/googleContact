package data.repositories;

import data.models.PhoneBook;

import java.util.ArrayList;
import java.util.List;

public class PhonebookRepositoryImpl implements PhonebookRepository{
    private List<PhoneBook> phonebooks = new ArrayList<>();

    @Override
    public PhoneBook findById(String phonenumber) {
        for (PhoneBook phonebook: phonebooks){
            String storedPhoneNumber = phonebook.getOwnersPhoneNumber();
            boolean phoneNumberMatches = storedPhoneNumber.equals(phonenumber);
            if (phoneNumberMatches) return phonebook;
        }
        return null;
    }

    @Override
    public PhoneBook save(PhoneBook phoneBook) {
//        check
//        if it exists
//        I update
        PhoneBook savedPhonebook = findById (phoneBook.getOwnersPhoneNumber());
        if (savedPhonebook == null)phonebooks.add(phoneBook);
        else
            updateSavedPhoneBook(phoneBook, savedPhonebook);
        return phoneBook;
    }

    private void updateSavedPhoneBook(PhoneBook phoneBook, PhoneBook savedPhonebook){
        savedPhonebook.setOwnersName(phoneBook.getOwnersName());
        savedPhonebook.setContacts(phoneBook.getContacts());
        savedPhonebook.setOwnersPhoneNumber(phoneBook.getOwnersPhoneNumber());
    }

    @Override
    public void delete(PhoneBook phoneBook) {

    }

    @Override
    public int count() {
        return phonebooks.size();
    }
}
