package com.asb.backprovisionservice.repository;

import com.asb.backprovisionservice.model.GgpProvision;
import org.springframework.data.repository.CrudRepository;

public interface ProvisionRepository extends CrudRepository<GgpProvision, Long> { }
