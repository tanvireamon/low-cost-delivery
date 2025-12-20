//package com.LowCost.Delivery.repository;

package com.LowCost.Delivery.repository;

import com.LowCost.Delivery.model.LocalDeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalDeliveryRepository extends JpaRepository<LocalDeliveryEntity, Long> {
}

