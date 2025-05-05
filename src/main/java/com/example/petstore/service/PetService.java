package com.example.petstore.service;

import com.example.petstore.model.Pet;

import java.util.List;

public interface PetService {

    void createPets();
    List<Pet> getAllPets();
    void buy();
    void showHistory();
}
