package com.LowCost.Delivery.service.impl;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.LowCost.Delivery.model.Complaint;
import com.LowCost.Delivery.repository.ComplaintRepository;
import com.LowCost.Delivery.service.ComplaintService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;

    @Override
    public Complaint saveComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }
}
