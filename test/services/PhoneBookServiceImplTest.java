package services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookServiceImplTest {

    @Test
    public void registerUserTest(){
        PhoneBookService phoneBookService = new PhoneBookServiceImpl();
        phoneBookService.register("Amirah Jeshe", "1234");
        assertEquals(1, phoneBookService.countNumberOfUsers());
    }

    @Test
    public void registerDuplicateUserFailsTest(){
        PhoneBookService phoneBookService = new PhoneBookServiceImpl();
        phoneBookService.register("Amirah Jeshe", "1234");
        assertThrows(IllegalArgumentException.class, ()->phoneBookService.register("Henry Omemma","1234"));
        assertEquals(1, phoneBookService.countNumberOfUsers());
    }

}