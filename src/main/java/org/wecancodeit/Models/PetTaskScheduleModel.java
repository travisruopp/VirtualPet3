package org.wecancodeit.Models;

import java.util.Date;
import jakarta.persistence.*;

/**
 * Class that models the scheduled tasks
 */
@Entity
@Table(name = "t_Schedule")
public class PetTaskScheduleModel {

    @Id
    @GeneratedValue()
    private long id;

    private long volunteerID;
    private long petID;
    private long taskID;
    private Date nextScheduledTime;

    /**
     * Default Constructor
     */
    public PetTaskScheduleModel() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param volunteerID       Volunteer's ID
     * @param petID             Pet's ID
     * @param taskID            task's ID
     * @param nextScheduledTime Next time required to complete
     */
    public PetTaskScheduleModel(long volunteerID, long petID, long taskID, Date nextScheduledTime) {
        this.volunteerID = volunteerID;
        this.petID = petID;
        this.taskID = taskID;
        this.nextScheduledTime = nextScheduledTime;
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
     * Method to get the volunteer's id
     * 
     * @return volunteer's id
     */
    public long getVolunteerID() {
        return volunteerID;
    }

    /**
     * Method to get the pet's id
     * 
     * @return pet's id
     */
    public long getPetID() {
        return petID;
    }

    /**
     * Method to get the task's id
     * 
     * @return task id
     */
    public long getTaskID() {
        return taskID;
    }

    /**
     * Method to get the next scheduled time
     * 
     * @return Next scheduled time
     */
    public Date getNextScheduledTime() {
        return nextScheduledTime;
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "PetTaskScheduleModel [id=" + id + ", volunteerID=" + volunteerID + ", petID=" + petID + ", taskID="
                + taskID + ", nextScheduledTime=" + nextScheduledTime + "]";
    }

}
