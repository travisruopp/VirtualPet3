package org.wecancodeit.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wecancodeit.Dto.AdopterDto;
import org.wecancodeit.Models.AdopterModel;
import org.wecancodeit.Services.AdopterService;

import jakarta.annotation.Resource;

/**
 * Controller class that models the mapping of the adopter services and
 * repository
 */
@RestController
@RequestMapping("/api/v1/adopters/")
public class AdopterController {

    @Resource
    private final AdopterService adopterService;

    /**
     * Parameterized Constructor
     * 
     * @param adopterService adopter services
     */
    public AdopterController(AdopterService adopterService) {
        this.adopterService = adopterService;
    }

    /**
     * Method to map getting all adopters
     * 
     * @return all adopters
     */
    @GetMapping
    public Iterable<AdopterModel> getAllAdopters() {
        return adopterService.findAll();
    }

    // /**
    //  * Method to map getting all adopters by shelter ID
    //  * 
    //  * @return all adopters by shelter ID
    //  */
    // @GetMapping("{shelterId}")
    // public Iterable<AdopterModel> getAllAdoptersByShelter(@PathVariable long shelterID) {
    //     return adopterService.findAllByShelter(shelterID);
    // }

    /**
     * Method to get a adopter by id
     * 
     * @param id adopter id
     * 
     * @return adopter
     */
    @GetMapping("{id}")
    public AdopterDto getAdopter(@PathVariable Long id) {
        AdopterModel model = adopterService.findById(id);
        AdopterDto dto = new AdopterDto(model);
        return dto;
    }

    /**
     * Method to get adopters by name and zip
     * 
     * @param name name of adopter
     * 
     * @return list of adopters within filter requirements
     */
    @GetMapping("name/{name}")
    public Iterable<AdopterModel> getByName(@PathVariable String name) {
        return adopterService.findByName(name);
    }

    /**
     * Method to get adopters by preferred pet type
     * 
     * @param preferredPetType adopter's preferred pet type
     * 
     * @return list of adopters within filter requirements
     */
    @GetMapping("preferredPetType/{preferredPetType}")
    public Iterable<AdopterModel> findByPreferredPetType(@PathVariable String preferredPetType) {
        return adopterService.findByPreferredPetType(preferredPetType);
    }

    /**
     * Method to delete a adopter
     * 
     * @param id adopter id
     * 
     * @return if the deletion of the adopter was successful
     */
    @DeleteMapping("{id}")
    public boolean deleteAdopter(@PathVariable Long id) {
        return adopterService.deleteAdopter(id);
    }

    /**
     * Method to add a adopter
     * 
     * @param adopterModel adopter to add
     * 
     * @return adopter added
     */
    @PostMapping
    public AdopterModel addAdopter(@RequestBody AdopterDto adopterDto) {
        AdopterModel adopterModel = adopterDto.convertToModel();
        return adopterService.saveAdopter(adopterModel);
    }

    /**
     * Method to update a adopter
     * 
     * @param adopterModel adopter to update
     * 
     * @return adopter updated
     */
    @PutMapping
    public AdopterModel saveAdopter(@RequestBody AdopterDto adopterDto) {
        AdopterModel adopterModel = adopterDto.convertToModel();
        return adopterService.saveAdopter(adopterModel);
    }
}
