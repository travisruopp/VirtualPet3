package org.wecancodeit.Services;

import java.util.*;

import org.springframework.stereotype.Service;
import org.wecancodeit.Models.*;
import org.wecancodeit.Repositories.PetTaskScheduleRepository;

import jakarta.annotation.Resource;

/**
 * Service class that models the ways to search and edit pet task schedules
 */
@Service
public class PetTaskScheduleService {

    @Resource
    private PetTaskScheduleRepository petTaskScheduleRepository;

    /**
     * Default Constructor
     */
    public PetTaskScheduleService() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param petTaskScheduleRepository pet task schedule repository
     */
    public PetTaskScheduleService(PetTaskScheduleRepository petTaskScheduleRepository) {
        this.petTaskScheduleRepository = petTaskScheduleRepository;
    }

    /**
     * Method to find all pet tasks scheduled
     * 
     * @return all pet tasks scheduled
     */
    public Iterable<PetTaskScheduleModel> findAll() {
        Iterable<PetTaskScheduleModel> petTaskSchedules = new ArrayList<>();
        try {
            petTaskSchedules = petTaskScheduleRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return petTaskSchedules;
    }

    /**
     * Method to find a pet task scheduled by pet task scheduled id
     * 
     * @param id pet task scheduled id
     * 
     * @return pet tasks scheduled
     */
    public PetTaskScheduleModel findById(Long id) {
        PetTaskScheduleModel petTaskSchedule = null;
        try {
            Optional<PetTaskScheduleModel> optPetTaskSchedules = petTaskScheduleRepository.findById(id);
            if (optPetTaskSchedules.isPresent()) {
                petTaskSchedule = optPetTaskSchedules.get();
            }
        } catch (Exception ex) {
            throw ex;
        }
        return petTaskSchedule;
    }

    /**
     * Method to find a pet task scheduled by volunteer id 
     * 
     * @param volunteerID volunteer id 
     * 
     * @return pet tasks scheduled
     */
    public Iterable<PetTaskScheduleModel> findByVolunteerID(Long volunteerID) {
        Iterable<PetTaskScheduleModel> petTaskSchedule = null;
        try {
            petTaskSchedule = petTaskScheduleRepository.findByVolunteerID(volunteerID);
        } catch (Exception ex) {
            throw ex;
        }
        return petTaskSchedule;
    }

    /**
     * Method to find a pet task scheduled by pet id
     * 
     * @param petID pet id
     * 
     * @return pet tasks scheduled
     */
    public Iterable<PetTaskScheduleModel> findByPetID(Long petID) {
        Iterable<PetTaskScheduleModel> petTaskSchedule = null;
        try {
            petTaskSchedule = petTaskScheduleRepository.findByPetID(petID);
        } catch (Exception ex) {
            throw ex;
        }
        return petTaskSchedule;
    }

    /**
     * Method to find a pet task scheduled by task id
     * 
     * @param taskID task id
     * 
     * @return pet tasks scheduled
     */
    public Iterable<PetTaskScheduleModel> findByTaskID(Long taskID) {
        Iterable<PetTaskScheduleModel> petTaskSchedule = null;
        try {
            petTaskSchedule = petTaskScheduleRepository.findByTaskID(taskID);
        } catch (Exception ex) {
            throw ex;
        }
        return petTaskSchedule;
    }

    /**
     * Method to delete a pet task schedule
     * 
     * @param id pet task schedule id
     * 
     * @return if the pet task scheduled was deleted
     */
    public boolean deletePetTaskSchedule(Long id) {
        boolean result = false;
        try {
            petTaskScheduleRepository.deleteById(id);
            Optional<PetTaskScheduleModel> optPetTaskSchedules = petTaskScheduleRepository.findById(id);
            if (!optPetTaskSchedules.isPresent()) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    /**
     * Method to add or update a pet task schedule
     * 
     * @param petTaskSchedule pet task schedule to add or update
     * 
     * @return added or updated pet task schedule
     */
    public PetTaskScheduleModel savePetTaskSchedule(PetTaskScheduleModel petTaskSchedule) {
        try {
            if (BaseService.isValidPetTaskSchedule(petTaskSchedule)) {
                petTaskSchedule = petTaskScheduleRepository.save(petTaskSchedule);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return petTaskSchedule;
    }
}
