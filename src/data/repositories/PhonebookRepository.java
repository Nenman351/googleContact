package data.repositories;

import data.models.PhoneBook;

public interface PhonebookRepository {

     PhoneBook findById(String phonenumber);

    PhoneBook save(PhoneBook phonebook);

    void delete(PhoneBook phonebook);

    int count();

}
