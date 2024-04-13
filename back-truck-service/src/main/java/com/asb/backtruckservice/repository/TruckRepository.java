package com.asb.backtruckservice.repository;

import com.asb.backtruckservice.model.GgpTruck;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

public interface TruckRepository extends CrudRepository<GgpTruck, Long> {
    @Query(value = """
            SELECT t.TRUCK_ID truckId, t.PLATE plate
            FROM GGP_TRUCK t
            """, nativeQuery = true)
    List<Object[]> findAllPates();
    @Query(value = """
            SELECT t.TRUCK_ID truckId, t.PLATE plate, t.PAPERS papers, t.MAINTENANCE maintenance,
                   t.MILEAGE mileage, t.TIRE tire, t.PRESSURE pressure, t.FUEL fuel, t.LIGHT light, t.HONK honk,
                   t.BRAKE brake, t.OIL oil, t.OBSERVATION observation, tp.TYPE type, tc.CAPACITY capacity
            FROM GGP_TRUCK t
            INNER JOIN GGP_TRUCK_CAPACITY tc ON t.truck_capacity_id = tc.truck_capacity_id
            INNER JOIN GGP_TRUCK_TYPE tp ON t.truck_type_id = tp.truck_type_id
            WHERE t.TRUCK_ID = (:truckId)
            """, nativeQuery = true)
    List<Object[]> findTruckById(Long truckId);
    Optional<GgpTruck> findFirstTruckIdByPlateContaining(String plate);
    @Modifying
    @Transactional
    @Query(value = """
            UPDATE ggp_truck
            SET mileage = :newMileage
            WHERE truck_id = :truckId
            """, nativeQuery = true)
    void updateMileageByTruckId(Long truckId, Long newMileage);
}
