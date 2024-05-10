package org.wecancodeit.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wecancodeit.Dto.RoboticPetDto;
import org.wecancodeit.Models.RoboticPetModel;
import org.wecancodeit.Models.Enums.PetTypeEnum;
import org.wecancodeit.Services.RoboticPetService;

import jakarta.annotation.Resource;
/**
 * Controller class that models the mapping of the robotic pet services and
 * repository
 */
@RestController
@RequestMapping("/api/v1/roboticPets/")
public class RoboticPetController {

    @Resource
    private final RoboticPetService roboticPetService;

    /**
     * Parameterized Constructor
     * 
     * @param roboticPetService robotic pet services
     */
    public RoboticPetController(RoboticPetService roboticPetService) {
        this.roboticPetService = roboticPetService;
    }

    /**
     * Method to map getting all robotic pets
     * 
     * @return all robotic pets
     */
    @GetMapping
    public Iterable<RoboticPetModel> getAllRoboticPets() {
        return roboticPetService.findAll();
    }

    /**
     * Method to get a robotic pet by id
     * 
     * @param id robotic pet id
     * 
     * @return robotic pet
     */
    @GetMapping("{id}")
    public RoboticPetDto getRoboticPet(@PathVariable Long id) {
        RoboticPetModel model =  roboticPetService.findById(id);
        RoboticPetDto dto = new RoboticPetDto(model);
        return dto;
    }

    /**
     * Method to get roboticPets by model
     * 
     * @param model  model of robotic pet
     * 
     * @return list of robotic pets within filter requirements
     */
    @GetMapping("model/{model}")
    public Iterable<RoboticPetModel> getByModel(@PathVariable String model) {
        return roboticPetService.findByModel(model);
    }

    /**
     * Method to get roboticPets by manufacturer
     * 
     * @param manufacturer  manufacturer of robotic pet
     * 
     * @return list of robotic pets within filter requirements
     */
    @GetMapping("manufacturer/{manufacturer}")
    public Iterable<RoboticPetModel> getByManufacturer(@PathVariable String manufacturer) {
        return roboticPetService.findByManufacturer(manufacturer);
    }

    /**
     * Method to get robotic pets by pet type
     * 
     * @param petType  pet type of robotic pet
     * 
     * @return list of robotic pets within filter requirements
     */
    @GetMapping("petType/{petType}")
    public Iterable<RoboticPetModel> getByPetType(@PathVariable PetTypeEnum petType) {
        return roboticPetService.findByPetType(petType);
    }

    /**
     * Method to delete a robotic pet
     * 
     * @param id robotic pet id
     * 
     * @return if the deletion of the robotic pet was successful
     */
    @DeleteMapping("{id}")
    public boolean deleteRoboticPet(@PathVariable Long id) {
        return roboticPetService.deleteRoboticPet(id);
    }

    /**
     * Method to add a robotic pet
     * 
     * @param roboticPetModel robotic pet to add
     * 
     * @return robotic pet added
     */
    @PostMapping
    public RoboticPetModel addRoboticPet(@RequestBody RoboticPetDto roboticPetDto) {
        RoboticPetModel roboticPetModel = roboticPetDto.convertToModel();
        return roboticPetService.saveRoboticPet(roboticPetModel);
    }

    /**
     * Method to update a robotic pet
     * 
     * @param roboticPetModel robotic pet to update
     * 
     * @return robotic pet updated
     */
    @PutMapping
    public RoboticPetModel saveRoboticPet(@RequestBody RoboticPetDto roboticPetDto) {
        RoboticPetModel roboticPetModel = roboticPetDto.convertToModel();
        return roboticPetService.saveRoboticPet(roboticPetModel);
    }
}
