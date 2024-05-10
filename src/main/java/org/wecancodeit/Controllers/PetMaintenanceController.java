package org.wecancodeit.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wecancodeit.Models.PetMaintenanceModel;
import org.wecancodeit.Services.PetMaintenanceService;
import jakarta.annotation.Resource;

/**
 * Controller class that models the mapping of the pet maintenance services and
 * repository
 */
@RestController
@RequestMapping("/api/v1/petMaintenances/")
public class PetMaintenanceController {
    @Resource
    private final PetMaintenanceService petMaintenanceService;

    /**
     * Parameterized Constructor
     * 
     * @param petMaintenanceService pet maintenance services
     */
    public PetMaintenanceController(PetMaintenanceService petMaintenanceService) {
        this.petMaintenanceService = petMaintenanceService;
    }

    /**
     * Method to map getting all pet maintenances
     * 
     * @return all pet maintenances
     */
    @GetMapping
    public Iterable<PetMaintenanceModel> getAllPetMaintenances() {
        return petMaintenanceService.findAll();
    }

    /**
     * Method to get a pet maintenance by id
     * 
     * @param id pet maintenance id
     * 
     * @return pet maintenance
     */
    @GetMapping("{id}")
    public PetMaintenanceModel getPetMaintenance(@PathVariable Long id) {
        return petMaintenanceService.findById(id);
    }

    /**
     * Method to get pet maintenances by name
     * 
     * @param name name of pet maintenance
     * 
     * @return list of pet maintenances within filter requirements
     */
    @GetMapping("name/{name}")
    public Iterable<PetMaintenanceModel> getByName(@PathVariable String name) {
        return petMaintenanceService.findByName(name);
    }

    /**
     * Method to delete a pet maintenance
     * 
     * @param id pet maintenance id
     * 
     * @return if the deletion of the pet maintenance was successful
     */
    @DeleteMapping("{id}")
    public boolean deletePetMaintenance(@PathVariable Long id) {
        return petMaintenanceService.deletePetMaintenance(id);
    }

    /**
     * Method to add a pet maintenance
     * 
     * @param petMaintenanceModel pet maintenance to add
     * 
     * @return pet maintenance added
     */
    @PostMapping
    public PetMaintenanceModel addPetMaintenance(@RequestBody PetMaintenanceModel petMaintenanceModel) {
        return petMaintenanceService.savePetMaintenance(petMaintenanceModel);
    }

    /**
     * Method to update a pet maintenance
     * 
     * @param petMaintenanceModel pet maintenance to update
     * 
     * @return pet maintenance updated
     */
    @PutMapping
    public PetMaintenanceModel savePetMaintenance(@RequestBody PetMaintenanceModel petMaintenanceModel) {
        return petMaintenanceService.savePetMaintenance(petMaintenanceModel);
    }
}

