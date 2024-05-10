package org.wecancodeit.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.Models.AdopterModel;

/**
 * Interface that provides the adopter repository
 */
public interface AdopterRepository extends CrudRepository<AdopterModel, Long>{

    Iterable<AdopterModel> findByName(String name);

    // Iterable<AdopterModel> findByNameZip(String name, String zip);

    Iterable<AdopterModel> findByPreferredPetType(String preferredPetType);
    
    // Iterable<AdopterModel> findByPreferredPetTypeZip(String preferredPetType, String zip);

    // public Iterable<AdopterModel> findAllByShelter(long shelterID);
}
