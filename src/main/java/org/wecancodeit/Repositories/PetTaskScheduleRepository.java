package org.wecancodeit.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.Models.*;

/**
 * Interface that provides the pet scheduled task repository
 */
public interface PetTaskScheduleRepository extends CrudRepository<PetTaskScheduleModel, Long>{

    Iterable<PetTaskScheduleModel> findByVolunteerID(Long volunteerID);

    Iterable<PetTaskScheduleModel> findByPetID(Long petID);

    Iterable<PetTaskScheduleModel> findByTaskID(Long taskID);
}
