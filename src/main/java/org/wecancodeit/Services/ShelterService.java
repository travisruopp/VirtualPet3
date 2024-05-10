package org.wecancodeit.Services;

import java.util.*;
import org.springframework.stereotype.Service;
import org.wecancodeit.Dto.ShelterLookupDto;
import org.wecancodeit.Models.*;
import org.wecancodeit.Repositories.*;
import jakarta.annotation.Resource;

/**
 * Service Class that models the ways to search the shelters
 */
@Service
public class ShelterService {

    @Resource
    private ShelterRepository shelterRepository;

    /**
     * Default Constructor
     */
    public ShelterService() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param shelterRepository the shelter repository
     */
    public ShelterService(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    /**
     * Method to find all shelters
     * 
     * @return all shelters
     */
    public Iterable<ShelterModel> findAll() {
        Iterable<ShelterModel> shelters = new ArrayList<>();
        try {
            shelters = shelterRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return shelters;
    }

    /**
     * Method to find a shelter by an id
     * 
     * @param id shelter id
     * 
     * @return shelter
     */
    public ShelterModel findById(Long id) {
        ShelterModel shelter = null;
        try {
            Optional<ShelterModel> optShelters = shelterRepository.findById(id);
            if (optShelters.isPresent()) {
                shelter = optShelters.get();
            }
        } catch (Exception ex) {
            throw ex;
        }
        return shelter;
    }

    /**
     * Method to find an shelter by name
     * 
     * @param name shelter name
     * 
     * @return shelters with in the given filters
     */
    public Iterable<ShelterModel> findByName(String name) {
        Iterable<ShelterModel> shelters = new ArrayList<>();
        try {
            shelters = shelterRepository.findByName(name);
        } catch (Exception ex) {
            throw ex;
        }
        return shelters;
    }

    /**
     * Method to find an shelter by zip
     * 
     * @param zip shelter zip
     * 
     * @return shelters with in the given filters
     */
    public Iterable<ShelterModel> findByZip(String zip) {
        Iterable<ShelterModel> shelters = new ArrayList<>();
        try {
            if (zip != null && zip.length() > 2) {
                zip = zip.substring(0, 2);
                shelters = shelterRepository.findByZip(zip);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return shelters;
    }
    
    /**
     * Method to create the shelter look up functionality on UI
     * 
     * @return the shelter model data transfer objects
     */
    public Iterable<ShelterLookupDto> getLookup(){
        ArrayList<ShelterLookupDto> lookup = new ArrayList<>();
        try{
            Iterable<ShelterModel> shelters = shelterRepository.findAll();
            for (ShelterModel shelter: shelters){
                lookup.add(new ShelterLookupDto(shelter));
            }
        } catch (Exception ex) {
            throw ex;
        }
        return lookup;
    }

    /**
     * Method to delete a shelter
     * 
     * @param id shelter id
     * 
     * @return if the shelter was deleted
     */
    public boolean deleteShelter(Long id) {
        boolean result = false;
        try {
            shelterRepository.deleteById(id);
            Optional<ShelterModel> optShelters = shelterRepository.findById(id);
            if (!optShelters.isPresent()) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    /**
     * Method to add or update a shelter
     * 
     * @param shelter shelter to add or update
     * 
     * @return added or updated shelter
     */
    public ShelterModel saveShelter(ShelterModel shelter) {
        try {
            if (BaseService.isValidContact(shelter)) {
                shelter = shelterRepository.save(shelter);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return shelter;
    }

    
}
