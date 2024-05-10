package org.wecancodeit.Models;

import org.wecancodeit.Models.Enums.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

/**
 * Class that models the adopters
 */
@Entity
@Table(name = "t_Adopters")
public class AdopterModel extends ContactModel {
    private PetTypeEnum preferredPetType;
    private AdoptionStatusEnum adoptionStatus;
    private String notes;

    @ManyToOne
    private ShelterModel shelterModel;

    /**
     * Default Constructor
     */
    public AdopterModel() {
        super();
    }

    /**
     * Parameterized Constructor
     * 
     * @param name             adopter name
     * @param addressLine1     adopter address line 1
     * @param addressLine2     adopter address line 2
     * @param city             adopter city
     * @param state            adopter state (abbreviated)
     * @param zip              adopter zip
     * @param phoneNumber      adopter phone number US Only
     * @param email            adopter email
     * @param imageURL         adopter image URL
     * @param preferredPetType adopter preferred pet type
     * @param adoptionStatus
     * @param notes
     */
    public AdopterModel(String name, String addressLine1, String addressLine2, String city, String state, String zip,
            String phoneNumber, String email, String imageURL, PetTypeEnum preferredPetType,
            AdoptionStatusEnum adoptionStatus, String notes) {
        super(name, addressLine1, addressLine2, city, state, zip, phoneNumber, email, imageURL);
        this.preferredPetType = preferredPetType;
        this.adoptionStatus = adoptionStatus;
        this.notes = notes;
    }

/**
 * Method to set the shelter for the adopter
 * 
 * @param shelterModel shelter to set
 */
    @JsonIgnore
    public void setShelterModel(ShelterModel shelterModel){
        this.shelterModel = shelterModel;
    }

    /**
     * Method to get the preferred pet type
     * 
     * @return preferred pet type
     */
    public PetTypeEnum getPreferredPetType() {
        return preferredPetType;
    }

    /**
     * Method to get the adoption status
     * 
     * @return adoption status
     */
    public AdoptionStatusEnum getAdoptionStatus() {
        return adoptionStatus;
    }

    /**
     * Method to get the notes on the adopter
     * 
     * @return notes on adopter
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Method to get the shelter model
     * 
     * @return shelter model
     */
    public ShelterModel getShelterModel() {
        return shelterModel;
    }
    

    /**
     * Override for the toString
     */
    @Override
    public String toString() {
        return super.toString() + "AdopterModel [preferredPetType=" + preferredPetType + ", adoptionStatus=" + adoptionStatus + ", notes="
                + notes + ", shelterModel=" + shelterModel + "]";
    }
}
