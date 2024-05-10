package org.wecancodeit.Models;

import java.util.ArrayList;
import org.wecancodeit.Models.Enums.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/**
 * Class that models the robotic pet
 */
@Entity
@Table(name = "t_RoboticPet")
public class RoboticPetModel extends PetModel {

    @Column(length = 50, nullable = false)
    private String model;

    @Column(length = 50, nullable = false)
    private String manufacturer;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int energyLevel;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int oilLevel;

    private RoboticPetHealthEnum petHealth;

    @ManyToOne
    private ShelterModel shelterModel;

    /**
     * Default Constructor
     */
    public RoboticPetModel() {
        super();
    }

    /**
     * Parameterized Constructor
     * 
     * @param petName            pet name
     * @param petType            pet type
     * @param imageURL           pet image url
     * @param model           pet model
     * @param manufacturer    pet manufacturer
     * @param energyLevel        pet energy level
     * @param oilLevel           pet oil level
     * @param petHealth          pet health
     * @param maintenanceTaskIDs maintenance task IDs
     * @param scheduleTaskIDs    scheduled task IDs
     */
    public RoboticPetModel(String petName, PetTypeEnum petType, String imageURL, String model,
            String manufacturer, int energyLevel, int oilLevel,
            RoboticPetHealthEnum petHealth, ArrayList<Long> maintenanceTaskIDs, ArrayList<Long> scheduleTaskIDs) {
        super(petName, petType, imageURL, maintenanceTaskIDs, scheduleTaskIDs);
        this.model = model;
        this.manufacturer = manufacturer;
        this.energyLevel = energyLevel;
        this.oilLevel = oilLevel;
        this.petHealth = petHealth;
    }

    public ShelterModel getShelterModel() {
        return shelterModel;
    }
    
    /**
     * Method to set the shelter model for the robotic pet
     * 
     * @param shelterModel shelter model
     */
    @JsonIgnore
    public void setShelterModel(ShelterModel shelterModel){
        this.shelterModel = shelterModel;
    }

    /**
     * Method to get the pet model
     * 
     * @return model #
     */
    public String getModel() {
        return model;
    }

    /**
     * Method to get the pet manufacturer
     * 
     * @return pet manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Method to get pet energy level
     * 
     * @return Energy Level
     */
    public int getEnergyLevel() {
        return energyLevel;
    }

    /**
     * Method to get the oil level
     * 
     * @return oil level
     */
    public int getOilLevel() {
        return oilLevel;
    }

    /**
     * Method to get the pet health
     * 
     * @return pet health
     */
    public RoboticPetHealthEnum getPetHealth() {
        return petHealth;
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return super.toString() + "RoboticPetModel [model=" + model + ", manufacturer=" + manufacturer
                + ", energyLevel="
                + energyLevel + ", oilLevel=" + oilLevel + ", petHealth=" + petHealth + "]";
    }
}
