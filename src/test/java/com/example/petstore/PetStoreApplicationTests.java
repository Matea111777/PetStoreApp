package com.example.petstore;

import com.example.petstore.model.Pet;
import com.example.petstore.model.Type;
import com.example.petstore.model.User;
import com.example.petstore.repository.PetRepository;
import com.example.petstore.repository.UserRepository;
import com.example.petstore.service.PetService;
import com.example.petstore.service.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
class PetStoreApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetService petService;

    @Autowired
    private UserService userService;
    @Test
    void testUserCanBuyPetSuccessfully() {

        User user = new User("Lara", "Smith", "lara@example.com", new BigDecimal("10"));
        userRepository.save(user);

        Pet cat=new Pet("Mila",Type.Cat,"Orange cat",LocalDate.of(2022,4,4),new BigDecimal("3"));
        petRepository.save(cat);


        petService.buy();


        Pet updatedCat = petRepository.findById(cat.getId()).orElseThrow();
        assertNotNull(updatedCat.getOwner());
        assertEquals("Lara", updatedCat.getOwner().getFirstName());
    }
    @Test
    void testBuyFailsIfPetIsTooExpensive() {
        User user = new User("Lara", "Smith", "lara@example.com", new BigDecimal("1"));
        userRepository.save(user);

        Pet cat = new Pet("Mila", Type.Cat, "Orange cat", LocalDate.of(2022, 4, 4), new BigDecimal("5"));
        petRepository.save(cat);

        petService.buy();

        Pet updatedPet = petRepository.findById(cat.getId()).orElseThrow();

        assertNull(updatedPet.getOwner()); // not enough budget
    }
}