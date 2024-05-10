package org.wecancodeit.Dto;

import java.util.ArrayList;

import org.wecancodeit.Models.Enums.*;
import org.wecancodeit.Models.*;


/**
 * Class that models the organic pets
 */
public class OrganicPetDto {
    private Long id;
    private String petName;
    private PetTypeEnum petType;
    private String imageURL;
    private String breed;
    private int petAge;
    private PetHealthEnum petHealth;
    private PetMoodEnum petMood;
    private PetTemperamentEnum petTemperament;
    private boolean petFixed;
    private ShelterModel shelterModel;
    private ArrayList<Long> maintenanceTaskIDs;
    private ArrayList<Long> scheduleTaskIDs;

    /**
     * Default Constructor
     */
    public OrganicPetDto() {
        super();
    }


    /**
     * Method to get the organic pet id
     * 
     * @return organic pet id
     */
    public Long getId() {
        return id;
    }

    /**
     * Method to set the organic pet id
     * 
     * @param id organic pet id
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Method to get the organic pet name
     * 
     * @return organic pet name
     */
    public String getPetName() {
        return petName;
    }

    /**
     * Method to set the organic pet name
     * 
     * @param petName organic pet name
     */
    public void setPetName(String petName) {
        this.petName = petName;
    }

    /**
     * Method to get the organic pet type
     * 
     * @return organic pet type
     */
    public PetTypeEnum getPetType() {
        return petType;
    }

    /**
     * Method to set the organic pet type
     * 
     * @param petType organic pet type
     */
    public void setPetType(PetTypeEnum petType) {
        this.petType = petType;
    }

    /**
     * Method to get the organic pet image URL
     * 
     * @return organic pet image url
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Method to set the organic pet image URL
     * 
     * @param imageURL organic pet image URL
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Method to get the organic pet breed
     * 
     * @return organic pet breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Method to set the organic pet breed
     * 
     * @param breed organic pet breed
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * Method to get the organic pet age
     * 
     * @return organic pet age
     */
    public int getPetAge() {
        return petAge;
    }

    /**
     * Method to set the organic pet age
     * 
     * @param petAge organic pet age
     */
    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    /**
     * Method to get the organic pet health
     * 
     * @return organic pet health
     */
    public PetHealthEnum getPetHealth() {
        return petHealth;
    }

    /**
     * Method to set the organic pet health
     * 
     * @param petHealth organic pet health
     */
    public void setPetHealth(PetHealthEnum petHealth) {
        this.petHealth = petHealth;
    }

    /**
     * Method to get the organic pet mood
     * 
     * @return organic pet mood
     */
    public PetMoodEnum getPetMood() {
        return petMood;
    }

    /**
     * Method to set the organic pet mood
     * 
     * @param petMood organic pet mood
     */
    public void setPetMood(PetMoodEnum petMood) {
        this.petMood = petMood;
    }

    /**
     * Method to get the organic pet temperament
     * 
     * @return organic pet temperament
     */
    public PetTemperamentEnum getPetTemperament() {
        return petTemperament;
    }

    /**
     * Method to set the organic pet temperament
     * 
     * @param petTemperament organic pet temperament
     */
    public void setPetTemperament(PetTemperamentEnum petTemperament) {
        this.petTemperament = petTemperament;
    }

    /**
     * Method to get if the organic pet is fixed
     * 
     * @return organic pet is fixed
     */
    public boolean isPetFixed() {
        return petFixed;
    }

    /**
     * Method to set if the organic pet is fixed
     * 
     * @param petFixed organic pet is fixed
     */
    public void setPetFixed(boolean petFixed) {
        this.petFixed = petFixed;
    }

    /**
     * Method to get the organic pet shelter model
     * 
     * @return organic pet shelter model
     */
    public ShelterModel getShelterModel() {
        return shelterModel;
    }

    /**
     * Method to set the organic pet shelter model
     * 
     * @param shelterModel organic pet shelter model
     */
    public void setShelterModel(ShelterModel shelterModel) {
        this.shelterModel = shelterModel;
    }

    /**
     * Method to get the organic pet maintenance task ids
     * 
     * @return organic pet maintenance task ids
     */
    public ArrayList<Long> getMaintenanceTaskIDs() {
        return maintenanceTaskIDs;
    }

    /**
     * Method to set the organic pet maintenance task ids
     * 
     * @param maintenanceTaskIDs organic pet maintenance task ids
     */
    public void setMaintenanceTaskIDs(ArrayList<Long> maintenanceTaskIDs) {
        this.maintenanceTaskIDs = maintenanceTaskIDs;
    }

    /**
     * Method to get the organic pet schedule task ids
     * 
     * @return organic pet schedule task ids
     */
    public ArrayList<Long> getScheduleTaskIDs() {
        return scheduleTaskIDs;
    }

    /**
     * Method to set the organic pet schedule task ids
     * 
     * @param scheduleTaskIDs organic pet schedule task ids
     */
    public void setScheduleTaskIDs(ArrayList<Long> scheduleTaskIDs) {
        this.scheduleTaskIDs = scheduleTaskIDs;
    }

    /**
     * Method to overload the organic pet data transfer object parameterized constructor
     * 
     * @param model organic pet model to migrate to a organic pet data transfer object
     */
    public OrganicPetDto (OrganicPetModel model) {
        this.id = model.getID();
        this.petName = model.getPetName();
        this.petType = model.getPetType();
        this.imageURL = model.getImageURL();
        this.breed = model.getBreed();
        this.petAge = model.getPetAge();
        this.petHealth = model.getPetHealth();
        this.petMood = model.getPetMood();
        this.petTemperament = model.getPetTemperament();
        this.petFixed = model.isPetFixed();
        this.maintenanceTaskIDs = model.getMaintenanceTaskIDs();
        this.scheduleTaskIDs = model.getScheduleTaskIDs();
        this.shelterModel = model.getShelterModel();
    }

    /**
     * Method to convert the organic pet data transfer object to a organic pet model
     * 
     * @return organic pet model
     */
    public OrganicPetModel convertToModel(){
        if (id == null) {
            id = 0l;
        }
        OrganicPetModel organicPet = new OrganicPetModel(
        this.getPetName(),
        this.getPetType(),
        this.getImageURL(),
        this.getBreed(),
        this.getPetAge(),
        this.getPetHealth(),
        this.getPetMood(),
        this.getPetTemperament(),
        this.isPetFixed(),
        this.getMaintenanceTaskIDs(),
        this.getScheduleTaskIDs());
        return organicPet;
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "OrganicPetDto [id=" + id + ", petName=" + petName + ", petType=" + petType + ", imageURL=" + imageURL
                + ", breed=" + breed + ", petAge=" + petAge + ", petHealth=" + petHealth + ", petMood=" + petMood
                + ", petTemperament=" + petTemperament + ", petFixed=" + petFixed + ", shelterModel=" + shelterModel
                + ", maintenanceTaskIDs=" + maintenanceTaskIDs + ", scheduleTaskIDs=" + scheduleTaskIDs + "]";
    }
}
