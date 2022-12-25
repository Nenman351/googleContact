package services;

import data.models.Contact;
import data.models.PhoneBook;
import data.repositories.PhonebookRepository;
import data.repositories.PhonebookRepositoryImpl;

public class PhoneBookServiceImpl implements PhoneBookService{
    PhonebookRepository phonebookRepository = new PhonebookRepositoryImpl();
    @Override
    public void register(String ownersName, String ownersPhoneNumber) {
//        create anew phonebook
//        save it
        PhoneBook savedPhonebook = phonebookRepository.findById(ownersPhoneNumber);
        if(savedPhonebook != null)throw new IllegalArgumentException("User Exist");
//        if (userExist(ownersPhoneNumber)) throw IllegalArgumentException("User exist");
        PhoneBook newPhonebook = new PhoneBook();
        newPhonebook.setOwnersPhoneNumber(ownersPhoneNumber);
        newPhonebook.setOwnersName(ownersName);
        phonebookRepository.save(newPhonebook);
    }

    @Override
    public void addContact(String ownersPhoneNumber, String firstName, String lastName, String phoneNumber) {

    }

    @Override
    public Contact findContact(String ownersPhoneNumber, String phoneNumberToSearchFor) {
        return null;
    }

    @Override
    public int countNumberOfUsers() {
        return phonebookRepository.count();
    }
}
