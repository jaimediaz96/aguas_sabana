package com.asb.backincidentservice.repository;

import com.asb.backincidentservice.model.GgpIncidentType;
import org.springframework.data.repository.CrudRepository;

public interface IncidentTypeRepository extends CrudRepository<GgpIncidentType, Long> { }
