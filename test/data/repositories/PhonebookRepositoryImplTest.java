package data.repositories;

import data.models.PhoneBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookRepositoryImplTest {
    private PhonebookRepository phonebookRepository;

    @BeforeEach
    public void setUp(){
        phonebookRepository = new PhonebookRepositoryImpl();
    }
    @Test
    public  void savePhoneBookTotalPhonebookIsOneTest(){
//        given I have a new phonebook repository
//        when I try to save a contact
//        assert equals count is 1
        PhoneBook amirah = new PhoneBook();
        phonebookRepository.save(amirah);
        assertEquals(1, phonebookRepository.count());
    }

    @Test
    public  void savePhoneBookFindByIdReturnSavedPhonebook(){
//        given I have a new repo
//        when I save to a new phonebook
//        when I find by id
//        assert that phonebook is equals to saved phonebook
        PhoneBook amirah = new PhoneBook();
        amirah.setOwnersPhoneNumber("9900");
        amirah.setOwnersName("Amirah");
        phonebookRepository.save(amirah);
        PhoneBook savedPhonebook = phonebookRepository.findById("9900");
        assertEquals(amirah, savedPhonebook);
        assertEquals("Amirah", savedPhonebook.getOwnersName());
    }

    @Test
    public  void updatePhoneBookFindByIdReturnSavedPhonebook(){
//        given I have a new repo
//        when I save to a new phonebook
//        when I update
//        assert that phonebook details have been updated
        PhoneBook amirah = new PhoneBook();
        amirah.setOwnersPhoneNumber("9900");
        amirah.setOwnersName("Amirah");
        phonebookRepository.save(amirah);
        PhoneBook updatedPhonebook = new PhoneBook();
        updatedPhonebook.setOwnersName("Rofiat");
        updatedPhonebook.setOwnersPhoneNumber("9900");
        phonebookRepository.save(updatedPhonebook);
        PhoneBook savedPhonebook = phonebookRepository.findById("9900");
        assertEquals(1, phonebookRepository.count());
        assertEquals("Rofiat", savedPhonebook.getOwnersName());
    }
}