package com.glasiem.repository.queries;

import com.glasiem.entity.GenerationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenerationQueryRepo extends CrudRepository<GenerationEntity, Long> {

    @Query(value = "SELECT * FROM generation_entity WHERE generation_entity.agency_id IN(" +
            "SELECT agency_entity.id FROM agency_entity WHERE agency_entity.id IN(" +
            "SELECT generation_entity.agency_id FROM generation_entity WHERE generation_entity.id IN(" +
            "SELECT vtuber_entity.generation_id FROM vtuber_entity WHERE vtuber_entity.name = ?1)))", nativeQuery = true)
    List<GenerationEntity> findGenerationsByVTuberName(String contents);
}
