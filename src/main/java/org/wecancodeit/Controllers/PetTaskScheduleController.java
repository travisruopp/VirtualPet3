package org.wecancodeit.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wecancodeit.Models.PetTaskScheduleModel;
import org.wecancodeit.Services.PetTaskScheduleService;
import jakarta.annotation.Resource;

/**
 * Controller class that models the mapping of the pet task schedule services and
 * repository
 */
@RestController
@RequestMapping("/api/v1/petTaskSchedules/")
public class PetTaskScheduleController {
    @Resource
    private final PetTaskScheduleService petTaskScheduleService;

    /**
     * Parameterized Constructor
     * 
     * @param petTaskScheduleService pet task schedule services
     */
    public PetTaskScheduleController(PetTaskScheduleService petTaskScheduleService) {
        this.petTaskScheduleService = petTaskScheduleService;
    }

    /**
     * Method to map getting all pet task schedules
     * 
     * @return all pet task schedules
     */
    @GetMapping
    public Iterable<PetTaskScheduleModel> getAllPetTaskSchedules() {
        return petTaskScheduleService.findAll();
    }

    /**
     * Method to get a pet task schedule by volunteer id
     * 
     * @param volunteerID volunteer id
     * 
     * @return pet task schedule
     */
    @GetMapping("volunteer/{volunteerID}")
    public Iterable<PetTaskScheduleModel> getPetTaskScheduleByVolunteerID(@PathVariable Long volunteerID) {
        return petTaskScheduleService.findByVolunteerID(volunteerID);
    }

    /**
     * Method to get a pet task schedule by pet id
     * 
     * @param petID pet id
     * 
     * @return pet task schedule
     */
    @GetMapping("pet/{petID}")
    public Iterable<PetTaskScheduleModel> getPetTaskScheduleByPetID(@PathVariable Long petID) {
        return petTaskScheduleService.findByPetID(petID);
    }

    /**
     * Method to get a pet task schedule by task id
     * 
     * @param taskID task id
     * 
     * @return pet task schedule
     */
    @GetMapping("task/{taskID}")
    public Iterable<PetTaskScheduleModel> getPetTaskScheduleByTaskID(@PathVariable Long taskID) {
        return petTaskScheduleService.findByTaskID(taskID);
    }

    /**
     * Method to get a pet task schedule by id
     * 
     * @param id pet task schedule id
     * 
     * @return pet task schedule
     */
    @GetMapping("{id}")
    public PetTaskScheduleModel getPetTaskSchedule(@PathVariable Long id) {
        return petTaskScheduleService.findById(id);
    }

    /**
     * Method to delete a pet task schedule
     * 
     * @param id pet task schedule id
     * 
     * @return if the deletion of the pet task schedule was successful
     */
    @DeleteMapping("{id}")
    public boolean deletePetTaskSchedule(@PathVariable Long id) {
        return petTaskScheduleService.deletePetTaskSchedule(id);
    }

    /**
     * Method to add a pet task schedule
     * 
     * @param petTaskScheduleModel pet task schedule to add
     * 
     * @return pet task schedule added
     */
    @PostMapping
    public PetTaskScheduleModel addPetTaskSchedule(@RequestBody PetTaskScheduleModel petTaskScheduleModel) {
        return petTaskScheduleService.savePetTaskSchedule(petTaskScheduleModel);
    }

    /**
     * Method to update a pet task schedule
     * 
     * @param petTaskScheduleModel pet task schedule to update
     * 
     * @return pet task schedule updated
     */
    @PutMapping
    public PetTaskScheduleModel savePetTaskSchedule(@RequestBody PetTaskScheduleModel petTaskScheduleModel) {
        return petTaskScheduleService.savePetTaskSchedule(petTaskScheduleModel);
    }
}
