package org.wecancodeit.Dto;

import org.wecancodeit.Models.AdopterModel;
import org.wecancodeit.Models.ShelterModel;
import org.wecancodeit.Models.Enums.*;

public class AdopterDto {
    private long id;
    private String name;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;
    private String imageURL;
    private PetTypeEnum preferredPetType;
    private AdoptionStatusEnum adoptionStatus;
    private String notes;
    private ShelterModel shelterModel;

    public AdopterDto() {
        super();
    }
    public AdopterDto(AdopterModel model){
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
        this.preferredPetType = model.getPreferredPetType();
        this.adoptionStatus = model.getAdoptionStatus();
        this.notes = model.getNotes();
        this.shelterModel = model.getShelterModel();
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddressLine1() {
        return addressLine1;
    }
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    public String getAddressLine2() {
        return addressLine2;
    }
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public PetTypeEnum getPreferredPetType() {
        return preferredPetType;
    }
    public void setPreferredPetType(PetTypeEnum preferredPetType) {
        this.preferredPetType = preferredPetType;
    }
    public AdoptionStatusEnum getAdoptionStatus() {
        return adoptionStatus;
    }
    public void setAdoptionStatus(AdoptionStatusEnum adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public ShelterModel getShelterModel() {
        return shelterModel;
    }
    public void setShelterModel(ShelterModel shelterModel) {
        this.shelterModel = shelterModel;
    }

    public AdopterModel convertToModel() {
        AdopterModel adopter = new AdopterModel(
                this.getName(),
                this.getAddressLine1(),
                this.getAddressLine2(),
                this.getCity(),
                this.getState(),
                this.getZip(),
                this.getPhoneNumber(),
                this.getEmail(),
                this.getImageURL(),
                this.getPreferredPetType(),
                this.getAdoptionStatus(),
                this.getNotes());
        return adopter;
    }
}
