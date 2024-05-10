package org.wecancodeit.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.Models.PetMaintenanceModel;

/**
 * Interface that provides the pet maintenance repository
 */
public interface PetMaintenanceRepository extends CrudRepository<PetMaintenanceModel, Long>{

    Iterable<PetMaintenanceModel> findByName(String name);
}
