package org.wecancodeit.Dto;

import java.util.Collection;

import org.wecancodeit.Models.*;

/**
 * Class that models the pet volunteer
 */
public class VolunteerDto {

    private Long id;
    private String name;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;
    private String imageURL;
    private Collection<ShelterModel> shelterModels;


    /**
     * Default Constructor
     */
    public VolunteerDto() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param id           volunteer id
     * @param name         volunteer's name
     * @param addressLine1 volunteer's address line 1
     * @param addressLine2 volunteer's address line 2
     * @param city         volunteer's city
     * @param state        volunteer's state (abbreviated)
     * @param zip          volunteer's zip code
     * @param phoneNumber  volunteer's phone number
     * @param email        volunteer's email
     * @param imageURL     volunteer's image url
     */
    public VolunteerDto(Long id, String name, String addressLine1, String addressLine2, String city, String state,
            String zip, String phoneNumber, String email, String imageURL) {
        this.id = id;
        this.name = name;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.imageURL = imageURL;
    }

    /**
     * Method to get the volunteer id
     * 
     * @return volunteer id
     */
    public Long getId() {
        return id;
    }

    /**
     * method to set the volunteer id
     * 
     * @param id volunteer id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Method to get volunteer name
     * 
     * @return volunteer name
     */
    public String getName() {
        return name;
    }

    /**
     * method to set the volunteer name
     * 
     * @param name volunteer name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the volunteer Address Line 1
     * 
     * @return volunteer address line 1
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Method to set the volunteer address line 1
     * 
     * @param addressLine1 volunteer address line 1
     */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * Method to set address line 2
     * 
     * @return address line 2
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Method to set volunteer address line 2
     * 
     * @param addressLine2 volunteer address line 2
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * Method to get volunteer city
     * 
     * @return volunteer city
     */
    public String getCity() {
        return city;
    }

    /**
     * Method to set the volunteer city
     * 
     * @param city volunteer city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Method to get volunteer state
     * 
     * @return volunteer state
     */
    public String getState() {
        return state;
    }

    /**
     * Method to set volunteer state
     * 
     * @param state volunteer state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Method to get volunteer zip
     * 
     * @return volunteer zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Method to set the volunteer zip
     * 
     * @param zip volunteer zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Method to get the volunteer phone number
     * 
     * @return volunteer phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method to set the volunteer phone number
     * 
     * @param phoneNumber volunteer phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Method to get the volunteer email
     * 
     * @return volunteer email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method to set the volunteer email
     * 
     * @param email volunteer email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method to get the volunteer image url
     * 
     * @return volunteer image url
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Method to set the volunteer image url
     * 
     * @param imageURL image url
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Collection<ShelterModel> getShelterModels() {
        return shelterModels;
    }

    public void setShelterModels(Collection<ShelterModel> shelterModels) {
        this.shelterModels = shelterModels;
    }


    /**
     * Method to overload the volunteer data transfer object parameterized
     * constructor
     * 
     * @param model volunteer model to migrate to a volunteer data transfer object
     */
    public VolunteerDto(VolunteerModel model) {
        this.id = model.getID();
        this.name = model.getName();
        this.addressLine1 = model.getAddressLine1();
        this.addressLine2 = model.getAddressLine2();
        this.city = model.getCity();
        this.state = model.getState();
        this.zip = model.getZip();
        this.phoneNumber = model.getPhoneNumber();
        this.email = model.getEmail();
        this.imageURL = model.getImageURL();
        this.shelterModels = model.getShelterModels();
    }

    /**
     * Method to convert the volunteer data transfer object to a volunteer model
     * 
     * @return volunteer model
     */
    public VolunteerModel convertToModel() {
        if (id == null) {
            id = 0l;
        }
        VolunteerModel volunteer = new VolunteerModel(
                this.getName(),
                this.getAddressLine1(),
                this.getAddressLine2(),
                this.getCity(),
                this.getState(),
                this.getZip(),
                this.getPhoneNumber(),
                this.getEmail(),
                this.getImageURL());
        return volunteer;
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "VolunteerDto [id=" + id + ", name=" + name + ", addressLine1=" + addressLine1 + ", addressLine2="
                + addressLine2 + ", city=" + city + ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber
                + ", email=" + email + ", imageURL=" + imageURL + "]";
    }

   
}
