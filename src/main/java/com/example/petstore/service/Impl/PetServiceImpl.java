package com.example.petstore.service.Impl;

import com.example.petstore.model.Pet;
import com.example.petstore.model.PurchaseHistory;
import com.example.petstore.model.Type;
import com.example.petstore.model.User;
import com.example.petstore.repository.HistoryRepository;
import com.example.petstore.repository.PetRepository;
import com.example.petstore.repository.UserRepository;
import com.example.petstore.service.PetService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {

    private final UserRepository userRepo;
    private final PetRepository petRepo;
    private final HistoryRepository historyRepo;

    private final Random random = new Random();

    public PetServiceImpl(UserRepository userRepo, PetRepository petRepo, HistoryRepository historyRepo) {
        this.userRepo = userRepo;
        this.petRepo = petRepo;
        this.historyRepo = historyRepo;
    }

    @Override
    public void createPets() {
        if (petRepo.count() >= 20) return;

        for (int i = 0; i < 20; i++) {
            Pet pet = new Pet();
            pet.setName("Pet" + i);
            pet.setDescription("Lovely pet " + i);

            LocalDate dob = LocalDate.now().minusYears(random.nextInt(10)); // 0-9 years
            pet.setDateOfBirth(dob);

            if (i % 2 == 0) {
                pet.setType(Type.Cat);
            } else {
                pet.setType(Type.Dog);
                pet.setRating(random.nextInt(11)); // 0-10
            }

            petRepo.save(pet);
        }
    }

    @Override
    public List<Pet> getAllPets() {
      return petRepo.findAll();
    }

    @Override
    public void buy() {
        int successCount = 0;
        int failureCount = 0;

        List<User> users = userRepo.findAll();

        for (User user : users) {
            List<Pet> availablePets = new ArrayList<>();
            for (Pet pet : petRepo.findAll()) {
                if (pet.getOwner() == null) {
                    availablePets.add(pet);
                }
            }
            for (Pet pet : availablePets) {
                if (user.getBudget().compareTo(pet.getPrice()) >= 0) {
                    user.setBudget(user.getBudget().subtract(pet.getPrice()));
                    pet.setOwner(user);
                    petRepo.save(pet);
                    successCount++;
                    break;
                } else {
                    failureCount++;
                }
            }
        }
        PurchaseHistory historyLog = new PurchaseHistory(LocalDateTime.now(), successCount, failureCount);
        historyRepo.save(historyLog);
    }
    @Override
    public void showHistory() {
        historyRepo.findAll().forEach(h -> {
            System.out.printf("Date: %s | Success: %d | Failed: %d%n",
                    h.getExecutionTime(), h.getSuccessfulPurchases(), h.getFailedPurchases());
        });
    }
}





