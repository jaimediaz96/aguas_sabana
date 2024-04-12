package com.asb.back_micro_route_business_service.repository;

import com.asb.back_micro_route_business_service.dto.response.GetMicroRouteResponseDTO;
import com.asb.back_micro_route_business_service.model.GgpMicroRoute;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MicroRouteRepository extends CrudRepository<GgpMicroRoute ,Long> {

    @Query(value = """
           SELECT mr.micro_route_id ,r.route_name ,r.description_route,mr.micro_route_name,t.plate
           FROM ggp_micro_route mr
           INNER JOIN ggp_route r ON mr.route_id = r.route_id
           INNER JOIN ggp_truck t ON mr.truck_id = mr.truck_id
            INNER JOIN ggp_state_micro_route smr ON mr.state_micro_route_id = smr.state_micro_route_id
           WHERE mr.user_id = (:userId)
           AND smr.state = 'CREADA' 
           """,nativeQuery = true)
    List<Object[]> getMicroRouteData(@Param("userId")Long userId);



    @Query(value = """

            SELECT c.client_id , c.company_name, c.address , a.aforo_id, aft.name
            FROM ggp_micro_route mr
            INNER JOIN ggp_route r ON mr.route_id = r.route_id
            INNER JOIN ggp_truck t ON mr.truck_id = mr.truck_id
            INNER JOIN ggp_state_micro_route smr ON mr.state_micro_route_id = smr.state_micro_route_id
            INNER JOIN ggp_micro_route_client mrc ON mrc.micro_route_id = mr.micro_route_id
            INNER JOIN ggp_client c ON mrc.client_id = c.client_id
            INNER JOIN ggp_aforo_type aft ON c.aforo_type_id = aft.aforo_type_id
            INNER JOIN ggp_aforo a ON c.client_id = a.client_id
            WHERE mr.user_id = (:userId)
            AND smr.state = 'CREADA'
           """,nativeQuery = true)
    List<Object[]> getClientData(@Param("userId")Long userId);
}
