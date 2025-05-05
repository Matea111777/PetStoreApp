package com.example.petstore.web;

import com.example.petstore.model.Pet;
import com.example.petstore.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @PostMapping("/create-pets")
    public void createPets() {
        petService.createPets();
    }
    @GetMapping("/list-pets")
    public List<Pet> listPets() {
        return petService.getAllPets();
    }
    @PostMapping("/buy-pets")
    public void buyPets() {
        petService.buy();
    }

    @GetMapping("/history")
    public void history() {
         petService.showHistory();
    }

}
