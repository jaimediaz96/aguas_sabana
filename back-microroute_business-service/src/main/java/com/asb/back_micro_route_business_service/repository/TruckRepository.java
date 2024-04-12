package com.asb.back_micro_route_business_service.repository;

import com.asb.back_micro_route_business_service.model.GgpTruck;
import org.springframework.data.repository.CrudRepository;

public interface TruckRepository extends CrudRepository<GgpTruck , Long> {
}
