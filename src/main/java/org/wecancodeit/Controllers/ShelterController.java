package org.wecancodeit.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wecancodeit.Dto.ShelterLookupDto;
import org.wecancodeit.Models.ShelterModel;
import org.wecancodeit.Services.ShelterService;

import jakarta.annotation.Resource;
/**
 * Controller class that models the mapping of the shelter services and
 * repository
 */
@RestController
@RequestMapping("/api/v1/shelters/")
public class ShelterController {

    @Resource
    private final ShelterService shelterService;

    /**
     * Parameterized Constructor
     * 
     * @param shelterService shelter services
     */
    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    /**
     * Method to map getting all shelters
     * 
     * @return all shelters
     */
    @GetMapping
    public Iterable<ShelterModel> getAllShelters() {
        return shelterService.findAll();
    }

    /**
     * Method to get a shelter by id
     * 
     * @param id shelter id
     * 
     * @return shelter
     */
    @GetMapping("{id}")
    public ShelterModel getShelter(@PathVariable Long id) {
        return shelterService.findById(id);
    }

    /**
     * Method to get shelters by name
     * 
     * @param name  name of shelter
     * 
     * @return list of shelters within filter requirements
     */
    @GetMapping("name/{name}")
    public Iterable<ShelterModel> getByName(@PathVariable String name) {
        return shelterService.findByName(name);
    }

    /**
     * Method to get shelters by zip
     * 
     * @param zip  zip of shelter
     * 
     * @return list of shelters within filter requirements
     */
    @GetMapping("zip/{zip}")
    public Iterable<ShelterModel> getByZip(@PathVariable String zip) {
        return shelterService.findByZip(zip);
    }

    @GetMapping("shelterLookup")
    public Iterable<ShelterLookupDto> getLookup(){
        return shelterService.getLookup();
    }
    /**
     * Method to delete a shelter
     * 
     * @param id shelter id
     * 
     * @return if the deletion of the shelter was successful
     */
    @DeleteMapping("{id}")
    public boolean deleteShelter(@PathVariable Long id) {
        return shelterService.deleteShelter(id);
    }

    /**
     * Method to add a shelter
     * 
     * @param shelterModel shelter to add
     * 
     * @return shelter added
     */
    @PostMapping
    public ShelterModel addShelter(@RequestBody ShelterModel shelterModel) {
        return shelterService.saveShelter(shelterModel);
    }

    /**
     * Method to update a shelter
     * 
     * @param shelterModel shelter to update
     * 
     * @return shelter updated
     */
    @PutMapping
    public ShelterModel saveShelter(@RequestBody ShelterModel shelterModel) {
        return shelterService.saveShelter(shelterModel);
    }

}
