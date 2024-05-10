package org.wecancodeit.Models;

import org.wecancodeit.Models.Enums.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/**
 * Class that models the pet maintenance tasks
 */
@Entity
@Table(name = "t_Maintenance")
public class PetMaintenanceModel {

    @Id
    @GeneratedValue()
    private long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Min(0)
    @Max(1464)
    private int frequency;

    private PetTypeEnum petType;
    private PetTaskEnum effectedProperty;

    /**
     * Default Constructor
     */
    public PetMaintenanceModel() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param name maintenance name
     * @param frequency frequency required
     * @param petType type of pet
     * @param effectedProperty effected property of pet
     */
    public PetMaintenanceModel(String name, int frequency, PetTypeEnum petType,
            PetTaskEnum effectedProperty) {
        this.name = name;
        this.frequency = frequency;
        this.petType = petType;
        this.effectedProperty = effectedProperty;
    }

    /**
     * Method to get the id
     * 
     * @return id
     */
    public long getID() {
        return id;
    }

    /**
     * Method to set the id
     * 
     * @param id id
     */
    public void setID(long id) {
        this.id = id;
    }

    /**
     * Method to get the name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get the frequency
     * 
     * @return frequency
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * Method to get the pet type
     * 
     * @return pet type
     */
    public PetTypeEnum getPetType() {
        return petType;
    }

    /**
     * Method to get the effected property
     * 
     * @return effected property
     */
    public PetTaskEnum getEffectedProperty() {
        return effectedProperty;
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "PetMaintenanceModel [id=" + id + ", name=" + name + ", frequency=" + frequency + ", petType=" + petType
                + ", effectedProperty=" + effectedProperty + "]";
    }

}
