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
public class RoboticPetService {
    @Resource
    private RoboticPetRepository roboticPetRepository;

    /**
     * Default Constructor
     */
    public RoboticPetService() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param roboticPetRepository robotic pet repository
     */
    public RoboticPetService(RoboticPetRepository roboticPetRepository) {
        this.roboticPetRepository = roboticPetRepository;
    }

    /**
     * Method to find all robotic pets
     * 
     * @return all robotic pets
     */
    public Iterable<RoboticPetModel> findAll() {
        Iterable<RoboticPetModel> roboticPets = new ArrayList<>();
        try {
            roboticPets = roboticPetRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return roboticPets;
    }

    /**
     * Method to find a robotic pet by an id
     * 
     * @param id robotic pet id
     * 
     * @return robotic pet
     */
    public RoboticPetModel findById(Long id) {
        RoboticPetModel roboticPet = null;
        try {
            Optional<RoboticPetModel> optRoboticPet = roboticPetRepository.findById(id);
            if (optRoboticPet.isPresent()) {
                roboticPet = optRoboticPet.get();
            }
        } catch (Exception ex) {
            throw ex;
        }
        return roboticPet;
    }

    
    /**
     * Method to find an robotic pet by model
     * 
     * @param model robotic pet breed
     * 
     * @return robotic pets with in the given filters
     */
    public Iterable<RoboticPetModel> findByModel(String petModel) {
        Iterable<RoboticPetModel> roboticPets = new ArrayList<>();
        try {
            roboticPets = roboticPetRepository.findByModel(petModel);
        } catch (Exception ex) {
            throw ex;
        }
        return roboticPets;
    }

    /**
     * Method to find an robotic pet by manufacturer
     * 
     * @param model robotic pet manufacturer
     * 
     * @return robotic pets with in the given filters
     */
    public Iterable<RoboticPetModel> findByManufacturer(String petManufacturer) {
        Iterable<RoboticPetModel> roboticPets = new ArrayList<>();
        try {
            roboticPets = roboticPetRepository.findByManufacturer(petManufacturer);
        } catch (Exception ex) {
            throw ex;
        }
        return roboticPets;
    }

    /**
     * Method to find an robotic pet by type
     * 
     * @param petType robotic pet type
     * 
     * @return robotic pets with in the given filters
     */
    public Iterable<RoboticPetModel> findByPetType(PetTypeEnum petType) {
        Iterable<RoboticPetModel> roboticPets = new ArrayList<>();
        try {
            roboticPets = roboticPetRepository.findByPetType(petType);
        } catch (Exception ex) {
            throw ex;
        }
        return roboticPets;
    }

    /**
     * Method to delete a robotic pet
     * 
     * @param id robotic pet id
     * 
     * @return if the robotic pet was deleted
     */
    public boolean deleteRoboticPet(Long id) {
        boolean result = false;
        try {
            roboticPetRepository.deleteById(id);
            Optional<RoboticPetModel> optRoboticPets = roboticPetRepository.findById(id);
            if (!optRoboticPets.isPresent()) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    /**
     * Method to add or update a robotic pet
     * 
     * @param roboticPet robotic pet to add or update
     * 
     * @return added or updated robotic pet
     */
    public RoboticPetModel saveRoboticPet(RoboticPetModel roboticPet) {
        try {
            if (BaseService.isValidRoboticPet(roboticPet)) {
                roboticPet = roboticPetRepository.save(roboticPet);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return roboticPet;
    }
}
