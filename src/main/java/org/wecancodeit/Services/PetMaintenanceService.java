package org.wecancodeit.Services;

import java.util.*;
import org.springframework.stereotype.Service;
import org.wecancodeit.Repositories.*;
import org.wecancodeit.Models.*;
import jakarta.annotation.Resource;

/**
 * Service class that models the ways to search for pet maintenance tasks.
 */
@Service
public class PetMaintenanceService {

    @Resource
    private PetMaintenanceRepository petMaintenanceRepository;

    /**
     * Default Constructor
     */
    public PetMaintenanceService() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param petMaintenanceRepository the pet maintenance repository
     */
    public PetMaintenanceService(PetMaintenanceRepository petMaintenanceRepository) {
        this.petMaintenanceRepository = petMaintenanceRepository;
    }

    /**
     * Method to find all pet maintenances
     * 
     * @return all pet maintenances
     */
    public Iterable<PetMaintenanceModel> findAll() {
        Iterable<PetMaintenanceModel> petMaintenances = new ArrayList<>();
        try {
            petMaintenances = petMaintenanceRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return petMaintenances;
    }

    /**
     * Method to find a pet maintenance by an id
     * 
     * @param id pet maintenance id
     * 
     * @return pet maintenance
     */
    public PetMaintenanceModel findById(Long id) {
        PetMaintenanceModel petMaintenance = null;
        try {
            Optional<PetMaintenanceModel> optPetMaintenance = petMaintenanceRepository.findById(id);
            if (optPetMaintenance.isPresent()) {
                petMaintenance = optPetMaintenance.get();
            }
        } catch (Exception ex) {
            throw ex;
        }
        return petMaintenance;
    }

    /**
     * Method to find an pet maintenance by name
     * 
     * @param name pet maintenance name
     * 
     * @return pet maintenances with in the given filters
     */
    public Iterable<PetMaintenanceModel> findByName(String name) {
        Iterable<PetMaintenanceModel> petMaintenances = new ArrayList<>();
        try {
            petMaintenances = petMaintenanceRepository.findByName(name);
        } catch (Exception ex) {
            throw ex;
        }
        return petMaintenances;
    }
    /**
     * Method to delete a pet maintenance
     * 
     * @param id pet maintenance id
     * 
     * @return if the pet maintenance was deleted
     */
    public boolean deletePetMaintenance(Long id) {
        boolean result = false;
        try {
            petMaintenanceRepository.deleteById(id);
            Optional<PetMaintenanceModel> optPetMaintenances = petMaintenanceRepository.findById(id);
            if (!optPetMaintenances.isPresent()) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    /**
     * Method to add or update a pet maintenance
     * 
     * @param petMaintenance pet maintenance to add or update
     * 
     * @return added or updated pet maintenance
     */
    public PetMaintenanceModel savePetMaintenance(PetMaintenanceModel petMaintenance) {
        try {
            if (BaseService.isValidPetMaintenance(petMaintenance)) {
                petMaintenance = petMaintenanceRepository.save(petMaintenance);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return petMaintenance;
    }   
}
