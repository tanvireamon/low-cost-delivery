package com.LowCost.Delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LowCost.Delivery.model.interoutercityentity;
@Repository
public interface interouterrepo extends JpaRepository<interoutercityentity, Long>  {

}
