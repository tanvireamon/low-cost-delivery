package com.LowCost.Delivery.service;




import java.util.List;

import com.LowCost.Delivery.model.Complaint;

public interface ComplaintService {

    Complaint saveComplaint(Complaint complaint);

    List<Complaint> getAllComplaints(); // optional, admin panel e dekhate chaile
}
