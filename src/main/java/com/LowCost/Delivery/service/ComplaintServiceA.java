package com.LowCost.Delivery.service;

import com.LowCost.Delivery.model.Complaint;
import com.LowCost.Delivery.model.ComplaintA;

import java.util.List;

public interface ComplaintServiceA {
    List<ComplaintA> getAll();
    ComplaintA getById(String id);
    void saveReply(String id, String reply);
    void resolve(String id, String reply);
}
