package com.asb.backincidentservice.repository;

import com.asb.backincidentservice.model.GgpIncident;
import org.springframework.data.repository.CrudRepository;

public interface IncidentRepository extends CrudRepository<GgpIncident, Long> { }
