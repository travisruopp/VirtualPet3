package org.wecancodeit.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.Models.*;
import org.wecancodeit.Models.Enums.PetTypeEnum;

/**
 * Interface that provides the robotic pet repository
 */
public interface RoboticPetRepository extends CrudRepository<RoboticPetModel, Long>{

    Iterable<RoboticPetModel> findByModel(String petModel);

    Iterable<RoboticPetModel> findByPetType(PetTypeEnum petType);

    Iterable<RoboticPetModel> findByManufacturer(String petManufacturer);
}
