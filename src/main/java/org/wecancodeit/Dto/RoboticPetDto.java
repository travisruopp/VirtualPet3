package org.wecancodeit.Dto;

import java.util.*;

import org.wecancodeit.Models.*;
import org.wecancodeit.Models.Enums.*;
/**
 * Class that models the robotic pet data transfer object
 */
public class RoboticPetDto {
    private Long id;
    private String petName;
    private PetTypeEnum petType;
    private String imageURL;
    private String model;
    private String manufacturer;
    private int energyLevel;
    private int oilLevel;
    private RoboticPetHealthEnum petHealth;
    private ShelterModel shelterModel;
    private ArrayList<Long> maintenanceTaskIDs;
    private ArrayList<Long> scheduleTaskIDs;

    /**
     * Default Constructor
     */
    public RoboticPetDto() {
    }

    /**
     * Method to get the robotic pet id
     * 
     * @return robotic pet id
     */
    public Long getId() {
        return id;
    }

    /**
     * Method to set the robotic pet id
     * 
     * @param id robotic pet id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Method to get the robotic pet name
     * 
     * @return robotic pet name
     */
    public String getPetName() {
        return petName;
    }

    /**
     * Method to set the robotic pet name
     * 
     * @param petName robotic pet name
     */
    public void setPetName(String petName) {
        this.petName = petName;
    }

    /**
     * Method to get the robotic pet type
     * 
     * @return robotic pet type
     */
    public PetTypeEnum getPetType() {
        return petType;
    }

    /**
     * Method to set the robotic pet type
     * 
     * @param petType robotic pet type
     */
    public void setPetType(PetTypeEnum petType) {
        this.petType = petType;
    }

    /**
     * Method to get the robotic pet image url
     * 
     * @return robotic pet image url
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Method to set the robotic pet image url
     * 
     * @param imageURL robotic pet image url
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Method to get the robotic pet model
     * 
     * @return robotic pet model
     */
    public String getModel() {
        return model;
    }

    /**
     * Method to set the robotic pet model
     * 
     * @param model robotic pet model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Method to get the robotic pet manufacturer
     * 
     * @return robotic pet manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Method to set the robotic pet manufacturer
     * 
     * @param manufacturer robotic pet manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Method to get the robotic pet energy level
     * @return
     */
    public int getEnergyLevel() {
        return energyLevel;
    }

    /**
     * Method to set the robotic pet energy level
     * 
     * @param energyLevel robotic pet energy level
     */
    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    /**
     * Method to get the robotic pet oil level
     * 
     * @return robotic pet oil level
     */
    public int getOilLevel() {
        return oilLevel;
    }

    /**
     * Method to set the robotic pet oil level
     * 
     * @param oilLevel robotic pet oil level
     */
    public void setOilLevel(int oilLevel) {
        this.oilLevel = oilLevel;
    }

    /**
     * Method to get the robotic pet health
     * 
     * @return robotic pet health
     */
    public RoboticPetHealthEnum getPetHealth() {
        return petHealth;
    }

    /**
     * Method to set the robotic pet health
     * 
     * @param petHealth robotic pet health
     */
    public void setPetHealth(RoboticPetHealthEnum petHealth) {
        this.petHealth = petHealth;
    }

    /**
     * Method to get the robotic pet shelter model
     * 
     * @return robotic pet shelter model
     */
    public ShelterModel getShelterModel() {
        return shelterModel;
    }

    /**
     * Method to set the robotic pet shelter model
     * 
     * @param shelterModel robotic pet shelter model
     */
    public void setShelterModel(ShelterModel shelterModel) {
        this.shelterModel = shelterModel;
    }

    /**
     * Method to get the robotic pet maintenance task ids
     * 
     * @return robotic pet maintenance task ids
     */
    public ArrayList<Long> getMaintenanceTaskIDs() {
        return maintenanceTaskIDs;
    }

    /**
     * Method to set the robotic pet maintenance task ids
     * 
     * @param maintenanceTaskIDs robotic pet maintenance task ids
     */
    public void setMaintenanceTaskIDs(ArrayList<Long> maintenanceTaskIDs) {
        this.maintenanceTaskIDs = maintenanceTaskIDs;
    }

    /**
     * Method to get the robotic pet schedule task ids
     * 
     * @return robotic pet schedule task ids
     */
    public ArrayList<Long> getScheduleTaskIDs() {
        return scheduleTaskIDs;
    }

    /**
     * Method to set the robotic pet schedule task ids
     * 
     * @param scheduleTaskIDs robotic pet schedule task ids
     */
    public void setScheduleTaskIDs(ArrayList<Long> scheduleTaskIDs) {
        this.scheduleTaskIDs = scheduleTaskIDs;
    }
    /**
     * Method to overload the robotic pet data transfer object parameterized constructor
     * 
     * @param model robotic pet model to migrate to a robotic pet data transfer object
     */
    public RoboticPetDto (RoboticPetModel model){
        this.id = model.getID();
        this.petName = model.getPetName();
        this.petType = model.getPetType();
        this.imageURL = model.getImageURL();
        this.model = model.getModel();
        this.manufacturer = model.getManufacturer();
        this.energyLevel = model.getEnergyLevel();
        this.oilLevel = model.getOilLevel();
        this.petHealth = model.getPetHealth();
        this.maintenanceTaskIDs = model.getMaintenanceTaskIDs();
        this.scheduleTaskIDs = model.getScheduleTaskIDs();
        this.shelterModel = model.getShelterModel();
    }

    /**
     * Method to convert the robotic pet data transfer object to a robotic pet model
     * 
     * @return robotic pet model
     */
    public RoboticPetModel convertToModel(){
        if (id == null) {
            id = 0l;
        }
        RoboticPetModel roboticPet = new RoboticPetModel(
        this.getPetName(),
        this.getPetType(),
        this.getImageURL(),
        this.getModel(),
        this.getManufacturer(),
        this.getEnergyLevel(),
        this.getOilLevel(),
        this.getPetHealth(),
        this.getMaintenanceTaskIDs(),
        this.getScheduleTaskIDs());
        return roboticPet;
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "RoboticPetDto [id=" + id + ", petName=" + petName + ", petType=" + petType + ", imageURL=" + imageURL
                + ", model=" + model + ", manufacturer=" + manufacturer + ", energyLevel=" + energyLevel + ", oilLevel="
                + oilLevel + ", petHealth=" + petHealth + ", shelterModel=" + shelterModel + ", maintenanceTaskIDs="
                + maintenanceTaskIDs + ", scheduleTaskIDs=" + scheduleTaskIDs + "]";
    }
}

