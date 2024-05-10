package org.wecancodeit.Services;

import java.util.*;
import org.springframework.stereotype.Service;
import org.wecancodeit.Models.*;
import org.wecancodeit.Repositories.VolunteerRepository;
import jakarta.annotation.Resource;

/**
 * Service class that models the ways to search and edit the volunteers
 */
@Service
public class VolunteerService {

    @Resource
    private VolunteerRepository volunteerRepository;

    /**
     * Default Constructor
     */
    public VolunteerService() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param volunteerRepository volunteer repository
     */
    public VolunteerService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    /**
     * Method to find all Volunteers
     * 
     * @return All Volunteers
     */
    public Iterable<VolunteerModel> findAll(){
        Iterable<VolunteerModel> volunteers = new ArrayList<>();
        try {
            volunteers = volunteerRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return volunteers;
    }

    /**
     * Method to find volunteers by ID
     * 
     * @param id volunteer id
     * 
     * @return the volunteer
     */
    public VolunteerModel findById(Long id){
        VolunteerModel volunteer = null;
        try {
            Optional<VolunteerModel> optVolunteer = volunteerRepository.findById(id);
            if (optVolunteer.isPresent()) {
                volunteer = optVolunteer.get();
            }
        } catch (Exception ex) {
            throw ex;
        }
        return volunteer;
    }

    /**
     * Method to find an volunteer by name
     * 
     * @param name volunteer name
     * 
     * @return volunteers with in the given filters
     */
    public Iterable<VolunteerModel> findByName(String name) {
        Iterable<VolunteerModel> volunteers = new ArrayList<>();
        try {
            // if (zip !=null && zip.length()> 2) {
            //      zip = zip.substring(0,2);
            //      volunteers = volunteerRepository.findByNameZip(name, zip);
            // } else {
                volunteers = volunteerRepository.findByName(name);
            // }
        } catch (Exception ex) {
            throw ex;
        }
        return volunteers;
    }

    /**
     * Method to delete an volunteer by ID
     * 
     * @param id volunteer ID
     * 
     * @return if the volunteer was deleted
     */
    public boolean deleteVolunteer(Long id){
        boolean result = false;
        try {
            volunteerRepository.deleteById(id);
            Optional<VolunteerModel> optVolunteer = volunteerRepository.findById(id);
            if (!optVolunteer.isPresent()) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    /**
     * Method to update and add an volunteer
     * 
     * @param volunteer the volunteer to add or update
     * 
     * @return the added or updated volunteer
     */
    public VolunteerModel saveVolunteer(VolunteerModel volunteer){
        try {
            if(BaseService.isValidContact(volunteer)) {
                volunteer = volunteerRepository.save(volunteer);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return volunteer;
    }

 
}
