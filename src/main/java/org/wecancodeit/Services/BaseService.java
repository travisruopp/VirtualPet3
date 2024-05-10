package org.wecancodeit.Services;

import org.springframework.stereotype.Service;
import org.wecancodeit.Models.*;
/**
 * Service Class that models the base service classes
 */
@Service
public class BaseService {

    /**
     * Method that checks if the contact is a valid contact
     * 
     * @param contact contact to check
     * 
     * @return if the contact is valid
     */
    public static boolean isValidContact(ContactModel contact) {
        return true;
    }

    /**
     * Method that checks if the organic pet is valid
     * 
     * @param organicPet organic pet model to check
     * 
     * @return if the organic pet model is valid
     */
    public static boolean isValidOrganicPet(OrganicPetModel organicPet) {
        return true;
    }

    /**
     * Method that checks if the robotic pet is valid
     * 
     * @param roboticPet robotic pet model to check
     * 
     * @return if the robotic pet model is valid
     */
    public static boolean isValidRoboticPet(RoboticPetModel roboticPet) {
        return true;
    }

    /**
     * Method to check id the Pet Maintenance is a valid pet maintenance model
     * 
     * @param petMaintenance pet maintenance task to check
     * 
     * @return if the pet maintenance is valid
     */
    public static boolean isValidPetMaintenance(PetMaintenanceModel petMaintenance) {
        return true;
    }

    /**
     * Method to check id the pet task schedule is a valid pet task
     * 
     * @param petTaskSchedule pet task schedule to check
     * 
     * @return if the pet task schedule is valid
     */
    public static boolean isValidPetTaskSchedule(PetTaskScheduleModel petTaskSchedule) {
        return true;
    }
}
