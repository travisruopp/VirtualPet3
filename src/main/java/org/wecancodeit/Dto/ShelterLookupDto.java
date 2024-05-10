package org.wecancodeit.Dto;

import org.wecancodeit.Models.ShelterModel;

public class ShelterLookupDto {
    private String name;
    private Long id;
    public ShelterLookupDto() {
    }
    public ShelterLookupDto(ShelterModel shelterModel) {
        this.name = shelterModel.getName();
        this.id = shelterModel.getID();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    
}
