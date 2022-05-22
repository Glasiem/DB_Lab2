package com.glasiem.repository.queries;

import com.glasiem.entity.AgencyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgencyQueryRepo extends CrudRepository<AgencyEntity, Long> {

    @Query(value = "SELECT * FROM agency_entity x WHERE " +
            "(SELECT COUNT(generation_entity.id) FROM generation_entity WHERE generation_entity.agency_id = x.id) >= ?1",
            nativeQuery = true)
    List<AgencyEntity> findAgenciesByGenerationCount(Integer contents);
}
