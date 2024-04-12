package com.asb.backrefuelservice.repository;

import com.asb.backrefuelservice.model.GgpRefuel;
import org.springframework.data.repository.CrudRepository;

public interface RefuelRepository extends CrudRepository<GgpRefuel, Long> { }
