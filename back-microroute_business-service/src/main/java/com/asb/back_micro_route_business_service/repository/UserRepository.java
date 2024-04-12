package com.asb.back_micro_route_business_service.repository;

import com.asb.back_micro_route_business_service.model.GgpUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<GgpUser, Long> {
}
