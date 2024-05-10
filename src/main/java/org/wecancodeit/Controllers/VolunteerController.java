package org.wecancodeit.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wecancodeit.Dto.VolunteerDto;
import org.wecancodeit.Models.VolunteerModel;
import org.wecancodeit.Services.VolunteerService;
import jakarta.annotation.Resource;

/**
 * Controller class that models the mapping of the volunteer services and
 * repository
 */
@RestController
@RequestMapping("/api/v1/volunteers/")
public class VolunteerController {
    @Resource
    private final VolunteerService volunteerService;

    /**
     * Parameterized Constructor
     * 
     * @param volunteerService volunteer services
     */
    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    /**
     * Method to map getting all volunteers
     * 
     * @return all volunteers
     */
    @GetMapping
    public Iterable<VolunteerModel> getAllVolunteers() {
        return volunteerService.findAll();
    }

    /**
     * Method to get a volunteer by id
     * 
     * @param id volunteer id
     * 
     * @return volunteer
     */
    @GetMapping("{id}")
    public VolunteerDto getVolunteer(@PathVariable Long id) {
        VolunteerModel model = volunteerService.findById(id);
        VolunteerDto dto = new VolunteerDto(model);
        return dto;
    }

    /**
     * Method to get volunteers by name and zip
     * 
     * @param name name of volunteer
     * @param zip  zip of volunteer
     * 
     * @return list of volunteers within filter requirements
     */
    @GetMapping("name/{name}")
    public Iterable<VolunteerModel> getByName(@PathVariable String name) {
        return volunteerService.findByName(name);
    }

    /**
     * Method to delete a volunteer
     * 
     * @param id volunteer id
     * 
     * @return if the deletion of the volunteer was successful
     */
    @DeleteMapping("{id}")
    public boolean deleteVolunteer(@PathVariable Long id) {
        return volunteerService.deleteVolunteer(id);
    }

    /**
     * Method to add a volunteer
     * 
     * @param volunteerModel volunteer to add
     * 
     * @return volunteer added
     */
    @PostMapping
    public VolunteerModel addVolunteer(@RequestBody VolunteerDto volunteerDto) {
        VolunteerModel volunteerModel = volunteerDto.convertToModel();
        return volunteerService.saveVolunteer(volunteerModel);
    }

    /**
     * Method to update a volunteer
     * 
     * @param volunteerModel volunteer to update
     * 
     * @return volunteer updated
     */
    @PutMapping
    public VolunteerModel saveVolunteer(@RequestBody VolunteerDto volunteerDto) {
        VolunteerModel volunteerModel = volunteerDto.convertToModel();
        return volunteerService.saveVolunteer(volunteerModel);
    }
}
