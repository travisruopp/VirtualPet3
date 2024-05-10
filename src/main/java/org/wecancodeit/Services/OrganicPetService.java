package org.wecancodeit.Services;

import java.util.*;
import org.springframework.stereotype.Service;
import org.wecancodeit.Models.*;
import org.wecancodeit.Models.Enums.PetTypeEnum;
import org.wecancodeit.Repositories.*;
import jakarta.annotation.Resource;

/**
 * Service Class that models the ways to search pets
 */
@Service
public class OrganicPetService{

    @Resource
    private OrganicPetRepository organicPetRepository;

    /**
     * Default Constructor
     */
    public OrganicPetService() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param organicPetRepository organic pet repository
     */
    public OrganicPetService(OrganicPetRepository organicPetRepository) {
        this.organicPetRepository = organicPetRepository;
    }

    /**
     * Method to find all organic pets
     * 
     * @return all organic pets
     */
    public Iterable<OrganicPetModel> findAll() {
        Iterable<OrganicPetModel> organicPets = new ArrayList<>();
        try {
            organicPets = organicPetRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return organicPets;
    }

    /**
     * Method to find a organic pet by an id
     * 
     * @param id organic pet id
     * 
     * @return organic pet
     */
    public OrganicPetModel findById(Long id) {
        OrganicPetModel organicPet = null;
        try {
            Optional<OrganicPetModel> optOrganicPet = organicPetRepository.findById(id);
            if (optOrganicPet.isPresent()) {
                organicPet = optOrganicPet.get();
            }
        } catch (Exception ex) {
            throw ex;
        }
        return organicPet;
    }

    /**
     * Method to find an organic pet by breed
     * 
     * @param breed organic pet breed
     * 
     * @return organic pets with in the given filters
     */
    public Iterable<OrganicPetModel> findByBreed(String breed) {
        Iterable<OrganicPetModel> organicPets = new ArrayList<>();
        try {
            organicPets = organicPetRepository.findByBreed(breed);
        } catch (Exception ex) {
            throw ex;
        }
        return organicPets;
    }
    
    /**
     * Method to find an organic pet by type
     * 
     * @param petType organic pet type
     * 
     * @return organic pets with in the given filters
     */
    public Iterable<OrganicPetModel> findByPetType(PetTypeEnum petType) {
        Iterable<OrganicPetModel> organicPets = new ArrayList<>();
        try {
            organicPets = organicPetRepository.findByPetType(petType);
        } catch (Exception ex) {
            throw ex;
        }
        return organicPets;
    }

    /**
     * Method to delete a organic pet
     * 
     * @param id organic pet id
     * 
     * @return if the organic pet was deleted
     */
    public boolean deleteOrganicPet(Long id) {
        boolean result = false;
        try {
            organicPetRepository.deleteById(id);
            Optional<OrganicPetModel> optOrganicPets = organicPetRepository.findById(id);
            if (!optOrganicPets.isPresent()) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    /**
     * Method to add or update a organic pet
     * 
     * @param organicPet organic pet to add or update
     * 
     * @return added or updated organic pet
     */
    public OrganicPetModel saveOrganicPet(OrganicPetModel organicPet) {
        try {
            if (BaseService.isValidOrganicPet(organicPet)) {
                organicPet = organicPetRepository.save(organicPet);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return organicPet;
    }
}
