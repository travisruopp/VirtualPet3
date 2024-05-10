package org.wecancodeit.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.Models.ShelterModel;

/**
 * Interface that provides the shelter repository
 */
public interface ShelterRepository extends CrudRepository<ShelterModel, Long>{

    Iterable<ShelterModel> findByName(String name);

    Iterable<ShelterModel> findByZip(String zip);
}
