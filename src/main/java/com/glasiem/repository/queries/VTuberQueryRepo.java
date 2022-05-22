package com.glasiem.repository.queries;

import com.glasiem.entity.VTuberEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VTuberQueryRepo extends CrudRepository<VTuberEntity, Long>{

    @Query(value = "SELECT * FROM vtuber_entity WHERE vtuber_entity.generation_id IN(" +
            "SELECT generation_entity.id FROM generation_entity WHERE generation_entity.agency_id IN(" +
            "SELECT agency_entity.id FROM agency_entity WHERE agency_entity.name = ?1))", nativeQuery = true)
    List<VTuberEntity> findVTubersByAgencyName(String contents);

    @Query(value = "SELECT COUNT(vtuber_entity.id) FROM vtuber_entity WHERE vtuber_entity.generation_id IN(" +
            "SELECT generation_entity.id FROM generation_entity WHERE generation_entity.agency_id IN(" +
            "SELECT agency_entity.id FROM agency_entity WHERE agency_entity.name = ?1))", nativeQuery = true)
    Integer findVTubersCountByAgencyName(String contents);

    @Query(value = "SELECT * FROM vtuber_entity x WHERE((" +
            "SELECT COUNT(DISTINCT media_entity.contents) FROM media_entity " +
            "WHERE media_entity.contents IN (" +
            "SELECT media_entity.contents FROM media_entity WHERE media_entity.vtuber_id = x.id)" +
            "AND media_entity.contents IN (" +
            "SELECT media_entity.contents FROM media_entity WHERE media_entity.vtuber_id IN (" +
            "SELECT vtuber_entity.id FROM vtuber_entity WHERE vtuber_entity.name = ?1)))" +
            "= " +
            "(SELECT COUNT(DISTINCT media_entity.contents) FROM media_entity " +
            "WHERE media_entity.vtuber_id IN (" +
            "SELECT vtuber_entity.id FROM vtuber_entity WHERE vtuber_entity.name = ?1)))" +
            "AND" +
            "((SELECT COUNT(DISTINCT media_entity.contents) FROM media_entity WHERE media_entity.contents IN (" +
            "SELECT media_entity.contents FROM media_entity WHERE media_entity.vtuber_id = x.id)" +
            "AND media_entity.contents IN (SELECT media_entity.contents FROM media_entity WHERE media_entity.vtuber_id IN (" +
            "SELECT vtuber_entity.id FROM vtuber_entity WHERE vtuber_entity.name = ?1)))" +
            "= " +
            "(SELECT COUNT(DISTINCT media_entity.contents) " +
            "FROM media_entity WHERE media_entity.contents IN (" +
            "SELECT media_entity.contents FROM media_entity WHERE media_entity.vtuber_id = x.id)))", nativeQuery = true)
    List<VTuberEntity> findVTubersByMediaSet1(String contents);

    @Query(value = "SELECT * FROM vtuber_entity x WHERE((" +
            "SELECT COUNT(DISTINCT media_entity.contents) FROM media_entity " +
            "WHERE media_entity.contents IN (" +
            "SELECT media_entity.contents FROM media_entity WHERE media_entity.vtuber_id = x.id)" +
            "AND media_entity.contents IN (" +
            "SELECT media_entity.contents FROM media_entity WHERE media_entity.vtuber_id IN (" +
            "SELECT vtuber_entity.id FROM vtuber_entity WHERE vtuber_entity.name = ?1)))" +
            "= " +
            "(SELECT COUNT(DISTINCT media_entity.contents) FROM media_entity " +
            "WHERE media_entity.vtuber_id IN (" +
            "SELECT vtuber_entity.id FROM vtuber_entity WHERE vtuber_entity.name = ?1)))", nativeQuery = true)
    List<VTuberEntity> findVTubersByMediaSet2(String contents);

    @Query(value = "SELECT * FROM vtuber_entity x WHERE((" +
            "SELECT COUNT(DISTINCT media_entity.contents) FROM media_entity WHERE media_entity.contents IN (" +
            "SELECT media_entity.contents FROM media_entity WHERE media_entity.vtuber_id = x.id)" +
            "AND media_entity.contents IN (SELECT media_entity.contents FROM media_entity WHERE media_entity.vtuber_id IN (" +
            "SELECT vtuber_entity.id FROM vtuber_entity WHERE vtuber_entity.name = ?1)))" +
            "= " +
            "(SELECT COUNT(DISTINCT media_entity.contents) " +
            "FROM media_entity WHERE media_entity.contents IN (" +
            "SELECT media_entity.contents FROM media_entity WHERE media_entity.vtuber_id = x.id)))", nativeQuery = true)
    List<VTuberEntity> findVTubersByMediaSet3(String contents);

}
