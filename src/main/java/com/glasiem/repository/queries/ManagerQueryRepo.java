package com.glasiem.repository.queries;

import com.glasiem.entity.ManagerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerQueryRepo extends CrudRepository<ManagerEntity,Long> {

    @Query(value = "SELECT manager_entity.name From manager_entity WHERE manager_entity.agency_id IN (" +
            "SELECT agency_entity.id FROM agency_entity WHERE agency_entity.id IN(" +
            "SELECT generation_entity.agency_id FROM generation_entity WHERE generation_entity.id IN(" +
            "SELECT vtuber_entity.generation_id FROM vtuber_entity WHERE vtuber_entity.name = ?1))", nativeQuery = true)
    String findManagerByVTuberName(String contents);
}
