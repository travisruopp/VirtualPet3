package org.wecancodeit.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.Models.OrganicPetModel;
import org.wecancodeit.Models.Enums.PetTypeEnum;

/**
 * Interface that provides the organic pet repository
 */
public interface OrganicPetRepository extends CrudRepository<OrganicPetModel, Long>{

    Iterable<OrganicPetModel> findByBreed(String breed);

    Iterable<OrganicPetModel> findByPetType(PetTypeEnum petType);

    

}
