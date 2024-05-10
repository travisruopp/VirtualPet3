package org.wecancodeit.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.Models.VolunteerModel;

/**
 * Interface that provides the volunteer repository
 */
public interface VolunteerRepository extends CrudRepository<VolunteerModel, Long>{

    Iterable<VolunteerModel> findByName(String name);

    // Iterable<VolunteerModel> findByNameZip(String name, String zip);
}
