package org.wecancodeit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.Models.*;
import org.wecancodeit.Services.*;
import org.wecancodeit.Models.Enums.*;

import jakarta.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private final AdopterService adopterService;

    @Resource
    private final OrganicPetService organicPetService;

    @Resource
    private final PetMaintenanceService petMaintenanceService;

    @Resource
    private final PetTaskScheduleService petTaskScheduleService;

    @Resource
    private final RoboticPetService roboticPetService;

    @Resource
    private final ShelterService shelterService;

    @Resource
    private final VolunteerService volunteerService;

    public Populator(AdopterService adopterService, OrganicPetService organicPetService,
            PetMaintenanceService petMaintenanceService, PetTaskScheduleService petTaskScheduleService,
            RoboticPetService roboticPetService, ShelterService shelterService, VolunteerService volunteerService) {
        this.adopterService = adopterService;
        this.organicPetService = organicPetService;
        this.petMaintenanceService = petMaintenanceService;
        this.petTaskScheduleService = petTaskScheduleService;
        this.roboticPetService = roboticPetService;
        this.shelterService = shelterService;
        this.volunteerService = volunteerService;
    }

    @Override
    public void run(String... args) throws Exception {
        VolunteerModel volunteerModel = new VolunteerModel("Sam Dude", "123333 Forest lane", null, "Portland", "OR",
                "12345", "0000000000", "thedude@yahoo.com", "dude.jpg");
        volunteerModel.setID(1l);
        volunteerService.saveVolunteer(volunteerModel);

        VolunteerModel volunteerModel2 = new VolunteerModel("Person", "123333 Tree lane", null, "Portland", "MA",
                "88888", "0000000000", "person@yahoo.com", "dude.jpg");
        volunteerModel2.setID(2l);
        volunteerService.saveVolunteer(volunteerModel2);

        VolunteerModel volunteerModel3 = new VolunteerModel("Nice Lady", "123333 Looking Glass lane", null, "Portland", "WI",
                "12345", "0000000000", "NicePerson@yahoo.com", "lady.jpg");
        volunteerModel3.setID(3l);
        volunteerService.saveVolunteer(volunteerModel3);

        VolunteerModel volunteerModel4 = new VolunteerModel("Young Adult", "123333 Young'n lane", null, "Portland", "ID",
                "44444", "0000000000", "Baby@yahoo.com", "young.jpg");
        volunteerModel4.setID(4l);
        volunteerService.saveVolunteer(volunteerModel4);

        VolunteerModel volunteerModel5 = new VolunteerModel("Angry Dude", "123333 Fire lane", null, "Portland", "TX",
                "15555", "0000000000", "rage@yahoo.com", "dude.jpg");
        volunteerModel5.setID(5l);
        volunteerService.saveVolunteer(volunteerModel5);

        ShelterModel shelterModel = new ShelterModel("Happy Pets", "1234 Apple Street", "Building 4", "Appleton", "WI",
                "54952", "9209999999", "Support@happypets.com",
                "https://www.happypets.shop/cdn/shop/files/HappyPet_-_Logo-_400_x_100_-_white__2_-removebg-preview_360x.png?v=1620804637",
                "www.happypets.shop");
        shelterModel.setID(1l);
        shelterModel.getVolunteers().add(volunteerModel5);
        shelterModel.getVolunteers().add(volunteerModel);
        shelterService.saveShelter(shelterModel);

        ShelterModel shelterModel2 = new ShelterModel("Sad Robots", "777 Lucky Street", null, "Chicago", "IL", "60540",
                "8155555555", "shelter@sadrobots.com", "sadrobots.jpg", "www.sadrobots.com");
        shelterModel2.setID(2l);
        shelterModel2.getVolunteers().add(volunteerModel5);
        shelterModel2.getVolunteers().add(volunteerModel3);
        shelterService.saveShelter(shelterModel2);

        ShelterModel shelterModel3 = new ShelterModel("The Pet Place", "848 That Street", null, "Here", "CA", "24512",
                "1234567890", "shelter@thepetplace.com", "image.jpg", "www.ThePetPlace.com");
        shelterModel3.setID(3l);
        shelterModel3.getVolunteers().add(volunteerModel5);
        shelterModel3.getVolunteers().add(volunteerModel2);
        shelterService.saveShelter(shelterModel3);

        ShelterModel shelterModel4 = new ShelterModel("Sparky Pets", "000 Roller Lane", null, "Boston", "MA", "55555",
                "0987456321", "pets@sparkypets.com", "sparks.png", "www.sparkypets.com");
        shelterModel4.setID(4l);
        shelterModel4.getVolunteers().add(volunteerModel5);
        shelterModel4.getVolunteers().add(volunteerModel4);
        shelterService.saveShelter(shelterModel4);

        ShelterModel shelterModel5 = new ShelterModel("Soft Pets", "000 Blanket Lane", null, "Boston", "OR", "55555",
                "0987456321", "welcome@softpets.com", "sparks.png", "www.softpets.com");
        shelterModel5.setID(5l);
        shelterService.saveShelter(shelterModel5);

        AdopterModel adopterModel = new AdopterModel("John Smith", "4444 Main Street", null, "Harrison", "WI", "54952",
                "9200000000", "johnsmith@gmail.com", "image.jpg", PetTypeEnum.CAT, AdoptionStatusEnum.NONE, "No Notes");
        adopterModel.setID(1l);
        adopterModel.setShelterModel(shelterModel5);
        adopterService.saveAdopter(adopterModel);

        AdopterModel adopterModel2 = new AdopterModel("Mary George", "565 First Street", "Apartment CAT", "Catsville",
                "WI", "54544", "9208888888", "ILOVECATS@CATLOVER.com", "CATSPLEASE.jpg", PetTypeEnum.CAT,
                AdoptionStatusEnum.PENDING, "Has too many cats");
        adopterModel2.setID(2l);
        adopterModel2.setShelterModel(shelterModel4);
        adopterService.saveAdopter(adopterModel2);

        AdopterModel adopterModel3 = new AdopterModel("Betty Crocker", "315 Bakers Lane", null, "Nummy", "PA", "45645",
                "8888888888", "IBakeALot@baking.com", "cookies.jpg", PetTypeEnum.DOG, AdoptionStatusEnum.REQUESTED,
                null);
        adopterModel3.setID(3l);
        adopterModel3.setShelterModel(shelterModel3);
        adopterService.saveAdopter(adopterModel3);

        AdopterModel adopterModel4 = new AdopterModel("John Barker", "315 Tupelo Lane", null, "Nummy", "IL", "45645",
                "7777777777", "DOG@dogs.com", "cookies.jpg", PetTypeEnum.ROBOTIC_DOG, AdoptionStatusEnum.APPROVED,
                null);
        adopterModel4.setID(4l);
        adopterModel4.setShelterModel(shelterModel2);
        adopterService.saveAdopter(adopterModel4);

        AdopterModel adopterModel5 = new AdopterModel("Mic Switch", "3555 Gravel Lane", null, "WOOF", "CO", "45645",
                "8888888888", "Loud_Noises@radio.com", "cookies.jpg", PetTypeEnum.ROBOTIC_CAT, AdoptionStatusEnum.DENIED,
                null);
        adopterModel5.setID(5l);
        adopterModel5.setShelterModel(shelterModel);
        adopterService.saveAdopter(adopterModel5);

        AdopterModel adopterModel6 = new AdopterModel("West Wing", "757 White House Lane", null, "Big House", "VA", "45645",
                "8888888888", "MrSpecial@housing.com", "cookies.jpg", PetTypeEnum.ROBOTIC_CAT, AdoptionStatusEnum.NONE,
                null);
        adopterModel6.setID(6l);
        adopterModel6.setShelterModel(shelterModel);
        adopterService.saveAdopter(adopterModel6);

        OrganicPetModel organicPetModel = new OrganicPetModel("Susan", PetTypeEnum.DOG, "RandomCatIMAGE.jpg", "Street",
                4, PetHealthEnum.HEALTHY, PetMoodEnum.EXCITED, PetTemperamentEnum.SUSPICIOUS, true, null, null);
        organicPetModel.setID(1l);
        organicPetModel.setShelterModel(shelterModel);
        organicPetService.saveOrganicPet(organicPetModel);

        OrganicPetModel organicPetModel2 = new OrganicPetModel("Spot", PetTypeEnum.DOG, "DOGGO.jpg", "Dog", 2,
                PetHealthEnum.HUNGRY, PetMoodEnum.FEARFUL, PetTemperamentEnum.QUICKLY_ROUSED, false, null, null);
        organicPetModel2.setID(2l);
        organicPetModel2.setShelterModel(shelterModel2);
        organicPetService.saveOrganicPet(organicPetModel2);
    
        OrganicPetModel organicPetModel3 = new OrganicPetModel("Boo", PetTypeEnum.DOG, "DOGGO.jpg", "Dog", 2,
                PetHealthEnum.HUNGRY, PetMoodEnum.FEARFUL, PetTemperamentEnum.QUICKLY_ROUSED, false, null, null);
        organicPetModel3.setID(3l);
        organicPetModel3.setShelterModel(shelterModel3);
        organicPetService.saveOrganicPet(organicPetModel3);

        OrganicPetModel organicPetModel4 = new OrganicPetModel("Spike", PetTypeEnum.CAT, "KITTY.jpg", "Street", 2,
                PetHealthEnum.HEALTHY, PetMoodEnum.HAPPY, PetTemperamentEnum.CALM, false, null, null);
        organicPetModel4.setID(4l);
        organicPetModel4.setShelterModel(shelterModel4);
        organicPetService.saveOrganicPet(organicPetModel4);

        OrganicPetModel organicPetModel5 = new OrganicPetModel("Quack", PetTypeEnum.CAT, "MEOW.jpg", "Mixed", 4,
                PetHealthEnum.HEALTHY, PetMoodEnum.SAD, PetTemperamentEnum.EASY_GOING, true, null, null);
        organicPetModel5.setID(5l);
        organicPetModel5.setShelterModel(shelterModel5);
        organicPetService.saveOrganicPet(organicPetModel5);

        OrganicPetModel organicPetModel6 = new OrganicPetModel("Moo", PetTypeEnum.CAT, "Whiskers.jpg", "Pretty", 2,
                PetHealthEnum.DEAD, PetMoodEnum.DEPRESSED, PetTemperamentEnum.UNHAPPY, false, null, null);
        organicPetModel6.setID(6l);
        organicPetModel6.setShelterModel(shelterModel);
        organicPetService.saveOrganicPet(organicPetModel6);

        OrganicPetModel organicPetModel7 = new OrganicPetModel("Phone", PetTypeEnum.DOG, "DOGGO.jpg", "Dog", 2,
                PetHealthEnum.SICK, PetMoodEnum.CALM, PetTemperamentEnum.EASY_GOING, false, null, null);
        organicPetModel7.setID(7l);
        organicPetModel7.setShelterModel(shelterModel2);
        organicPetService.saveOrganicPet(organicPetModel7);

        OrganicPetModel organicPetModel8 = new OrganicPetModel("Pen", PetTypeEnum.DOG, "DOGGO.jpg", "Dog", 2,
                PetHealthEnum.HEALTHY, PetMoodEnum.ANXIOUS, PetTemperamentEnum.EXHIBITIONIST, true, null, null);
        organicPetModel8.setID(8l);
        organicPetModel8.setShelterModel(shelterModel3);
        organicPetService.saveOrganicPet(organicPetModel8);

        OrganicPetModel organicPetModel9 = new OrganicPetModel("Hope", PetTypeEnum.DOG, "DOGGO.jpg", "Woof", 2,
                PetHealthEnum.HEALTHY, PetMoodEnum.DEPRESSED, PetTemperamentEnum.CAREFREE, false, null, null);
        organicPetModel9.setID(9l);
        organicPetModel9.setShelterModel(shelterModel4);
        organicPetService.saveOrganicPet(organicPetModel9);

        OrganicPetModel organicPetModel10 = new OrganicPetModel("Rubber", PetTypeEnum.DOG, "DOGGO.jpg", "Dog", 8,
                PetHealthEnum.DEAD, PetMoodEnum.FEARFUL, PetTemperamentEnum.CONTENTED, true, null, null);
        organicPetModel10.setID(10l);
        organicPetModel10.setShelterModel(shelterModel5);
        organicPetService.saveOrganicPet(organicPetModel10);

        RoboticPetModel roboticPetModel = new RoboticPetModel("Mr. Roboto", PetTypeEnum.ROBOTIC_DOG, "Robot.jpg",
                "Truck", "Jeep", 5, 5, RoboticPetHealthEnum.MALFUNCTION, null, null);
        roboticPetModel.setID(1l);
        roboticPetModel.setShelterModel(shelterModel);
        roboticPetService.saveRoboticPet(roboticPetModel);

        RoboticPetModel roboticPetModel2 = new RoboticPetModel("Vroom", PetTypeEnum.ROBOTIC_DOG, "Robot.jpg",
                "Small", "Gear", 5, 5, RoboticPetHealthEnum.DESTROYED, null, null);
        roboticPetModel2.setID(2l);
        roboticPetModel2.setShelterModel(shelterModel2);
        roboticPetService.saveRoboticPet(roboticPetModel2);

        RoboticPetModel roboticPetModel3 = new RoboticPetModel("Slick", PetTypeEnum.ROBOTIC_CAT, "Robot.jpg",
                "Kitty", "Gear", 8, 8, RoboticPetHealthEnum.NORMAL, null, null);
        roboticPetModel3.setID(3l);
        roboticPetModel3.setShelterModel(shelterModel3);
        roboticPetService.saveRoboticPet(roboticPetModel3);

        RoboticPetModel roboticPetModel4 = new RoboticPetModel("Phoney", PetTypeEnum.ROBOTIC_CAT, "Robot.jpg",
                "Spark", "Oily", 8, 6, RoboticPetHealthEnum.LOW_BATTERY, null, null);
        roboticPetModel4.setID(4l);
        roboticPetModel4.setShelterModel(shelterModel4);
        roboticPetService.saveRoboticPet(roboticPetModel4);

        RoboticPetModel roboticPetModel5 = new RoboticPetModel("Cell", PetTypeEnum.ROBOTIC_DOG, "Robot.jpg",
                "Folder", "Look", 2, 7, RoboticPetHealthEnum.NORMAL, null, null);
        roboticPetModel5.setID(5l);
        roboticPetModel5.setShelterModel(shelterModel5);
        roboticPetService.saveRoboticPet(roboticPetModel5);

        RoboticPetModel roboticPetModel6 = new RoboticPetModel("Beep", PetTypeEnum.ROBOTIC_DOG, "Robot.jpg",
                "Small", "Gear", 5, 5, RoboticPetHealthEnum.MALFUNCTION, null, null);
        roboticPetModel6.setID(6l);
        roboticPetModel6.setShelterModel(shelterModel);
        roboticPetService.saveRoboticPet(roboticPetModel6);

        RoboticPetModel roboticPetModel7 = new RoboticPetModel("Game", PetTypeEnum.ROBOTIC_CAT, "Meow.jpg",
                "Big", "Box", 5, 5, RoboticPetHealthEnum.LOW_BATTERY, null, null);
        roboticPetModel7.setID(7l);
        roboticPetModel7.setShelterModel(shelterModel2);
        roboticPetService.saveRoboticPet(roboticPetModel7);

        RoboticPetModel roboticPetModel8 = new RoboticPetModel("Beep", PetTypeEnum.ROBOTIC_DOG, "Robot.jpg",
                "Tiny", "Bot", 5, 5, RoboticPetHealthEnum.NORMAL, null, null);
        roboticPetModel8.setID(8l);
        roboticPetModel8.setShelterModel(shelterModel3);
        roboticPetService.saveRoboticPet(roboticPetModel8);

        RoboticPetModel roboticPetModel9 = new RoboticPetModel("Helper", PetTypeEnum.ROBOTIC_DOG, "Robot.jpg",
                "Happy", "bite", 5, 5, RoboticPetHealthEnum.DESTROYED, null, null);
        roboticPetModel9.setID(9l);
        roboticPetModel9.setShelterModel(shelterModel4);
        roboticPetService.saveRoboticPet(roboticPetModel9);

        RoboticPetModel roboticPetModel10 = new RoboticPetModel("Water", PetTypeEnum.ROBOTIC_DOG, "Robot.jpg",
                "Small", "Gear", 5, 5, RoboticPetHealthEnum.NORMAL, null, null);
        roboticPetModel10.setID(10l);
        roboticPetModel10.setShelterModel(shelterModel5);
        roboticPetService.saveRoboticPet(roboticPetModel10);

        PetMaintenanceModel petMaintenanceModel = new PetMaintenanceModel("Clean Litter Box", 5, PetTypeEnum.CAT,
                PetTaskEnum.CLEAN_LITTER_BOX);
        petMaintenanceModel.setID(1l);
        petMaintenanceService.savePetMaintenance(petMaintenanceModel);

        PetMaintenanceModel petMaintenanceModel2 = new PetMaintenanceModel("Clean Cages", 6, PetTypeEnum.DOG,
                PetTaskEnum.CLEAN_ENCLOSURE);
        petMaintenanceModel2.setID(2l);
        petMaintenanceService.savePetMaintenance(petMaintenanceModel2);

        PetMaintenanceModel petMaintenanceModel3 = new PetMaintenanceModel("Oil Pets", 8, PetTypeEnum.ROBOTIC_DOG,
                PetTaskEnum.OIL_PET);
        petMaintenanceModel3.setID(3l);
        petMaintenanceService.savePetMaintenance(petMaintenanceModel3);

        PetMaintenanceModel petMaintenanceModel4 = new PetMaintenanceModel("Charge Pets", 6, PetTypeEnum.ROBOTIC_CAT,
                PetTaskEnum.CHARGE_PET);
        petMaintenanceModel4.setID(4l);
        petMaintenanceService.savePetMaintenance(petMaintenanceModel4);

        PetMaintenanceModel petMaintenanceModel5 = new PetMaintenanceModel("Water Pet", 6, PetTypeEnum.DOG,
                PetTaskEnum.WATER_PET);
        petMaintenanceModel5.setID(5l);
        petMaintenanceService.savePetMaintenance(petMaintenanceModel5);

        PetTaskScheduleModel petTaskScheduleModel = new PetTaskScheduleModel(1l,3l,1l,null);
        petTaskScheduleModel.setID(1l);
        petTaskScheduleService.savePetTaskSchedule(petTaskScheduleModel);

        PetTaskScheduleModel petTaskScheduleModel2 = new PetTaskScheduleModel(2l,5l,2l,null);
        petTaskScheduleModel2.setID(2l);
        petTaskScheduleService.savePetTaskSchedule(petTaskScheduleModel2);

        PetTaskScheduleModel petTaskScheduleModel3 = new PetTaskScheduleModel(3l,7l,3l,null);
        petTaskScheduleModel3.setID(3l);
        petTaskScheduleService.savePetTaskSchedule(petTaskScheduleModel3);
    }

}
