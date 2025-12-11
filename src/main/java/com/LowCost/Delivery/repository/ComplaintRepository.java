package com.LowCost.Delivery.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LowCost.Delivery.model.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    // extra custom query lagle ekhane add koro
}

