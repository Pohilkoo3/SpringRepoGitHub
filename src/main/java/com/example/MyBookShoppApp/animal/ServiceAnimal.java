package com.example.MyBookShoppApp.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ServiceAnimal
{
    @Autowired
    private AnimalRepository repository;

    public Page<Animal> getAllAnimals(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit, Sort.by("name").ascending());
        Page<Animal> animalPage = repository.findAll(nextPage);
        return animalPage;
    }



}
