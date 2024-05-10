package org.wecancodeit.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wecancodeit.Dto.OrganicPetDto;
import org.wecancodeit.Models.OrganicPetModel;
import org.wecancodeit.Models.Enums.PetTypeEnum;
import org.wecancodeit.Services.OrganicPetService;

import jakarta.annotation.Resource;
/**
 * Controller class that models the mapping of the organic pet services and
 * repository
 */
@RestController
@RequestMapping("/api/v1/organicPets/")
public class OrganicPetController {

    @Resource
    private final OrganicPetService organicPetService;

    /**
     * Parameterized Constructor
     * 
     * @param organicPetService organic pet services
     */
    public OrganicPetController(OrganicPetService organicPetService) {
        this.organicPetService = organicPetService;
    }

    /**
     * Method to map getting all organic pets
     * 
     * @return all organic pets
     */
    @GetMapping
    public Iterable<OrganicPetModel> getAllOrganicPets() {
        return organicPetService.findAll();
    }

    /**
     * Method to get a organic pet by id
     * 
     * @param id organic pet id
     * 
     * @return organic pet
     */
    @GetMapping("{id}")
    public OrganicPetDto getOrganicPet(@PathVariable Long id) {
        OrganicPetModel model = organicPetService.findById(id);
        OrganicPetDto dto = new OrganicPetDto(model);
        return dto;
    }

    /**
     * Method to get organicPets by breed
     * 
     * @param breed  breed of organic pet
     * 
     * @return list of organic pets within filter requirements
     */
    @GetMapping("breed/{breed}")
    public Iterable<OrganicPetModel> getByBreed(@PathVariable String breed) {
        return organicPetService.findByBreed(breed);
    }

    /**
     * Method to get organic pets by pet type
     * 
     * @param petType  pet type of organic pet
     * 
     * @return list of organic pets within filter requirements
     */
    @GetMapping("petType/{petType}")
    public Iterable<OrganicPetModel> getByPetType(@PathVariable PetTypeEnum petType) {
        return organicPetService.findByPetType(petType);
    }

    /**
     * Method to delete a organic pet
     * 
     * @param id organic pet id
     * 
     * @return if the deletion of the organic pet was successful
     */
    @DeleteMapping("{id}")
    public boolean deleteOrganicPet(@PathVariable Long id) {
        return organicPetService.deleteOrganicPet(id);
    }

    /**
     * Method to add a organic pet
     * 
     * @param organicPetModel organic pet to add
     * 
     * @return organic pet added
     */
    @PostMapping
    public OrganicPetModel addOrganicPet(@RequestBody OrganicPetDto organicPetDto) {
        OrganicPetModel organicPetModel = organicPetDto.convertToModel();
        return organicPetService.saveOrganicPet(organicPetModel);
    }

    /**
     * Method to update a organic pet
     * 
     * @param organicPetModel organic pet to update
     * 
     * @return organic pet updated
     */
    @PutMapping
    public OrganicPetModel saveOrganicPet(@RequestBody OrganicPetDto organicPetDto) {
        OrganicPetModel organicPetModel = organicPetDto.convertToModel();
        return organicPetService.saveOrganicPet(organicPetModel);
    }
}
