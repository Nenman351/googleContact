package data.repositories;

import data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactRepositoryImplTest {
    private ContactRepository contactRepository;

    @BeforeEach
    public void setUp(){
        contactRepository = new ContactRepositoryImpl();
    }

    @Test
    public void saveContactIsOneTest(){
        Contact NEN = new Contact();
        contactRepository.save(NEN);
        assertEquals(1, contactRepository.count());
    }

    @Test
    public void saveContactFindByIdReturnSavedContactTest(){
        Contact Nen = new Contact();
        Nen.setPhoneNumber("8800");
        Nen.setFirstName("Nen");
        Nen.setLastName("omale");
        contactRepository.save(Nen);
        Contact savedContact = contactRepository.findById("8800");
        assertEquals(Nen, savedContact);
        assertEquals("Nen", savedContact.getFirstName());
        assertEquals("omale", savedContact.getLastName());
    }

    @Test
    public void updateContactFindByIdReturnSavedContact(){
        Contact Nen = new Contact();
        Nen.setFirstName("Nen");
        Nen.setLastName("omale");
        Nen.setPhoneNumber("8800");
        contactRepository.save(Nen);
        Contact updatedContact = new Contact();
        updatedContact.setFirstName("Hannah");
        updatedContact.setLastName("omale");
        updatedContact.setPhoneNumber("8800");
        contactRepository.save(updatedContact);
        Contact savedContact = contactRepository.findById("8800");
        assertEquals(1,contactRepository.count());
        assertEquals("Hannah", savedContact.getFirstName());
    }

}