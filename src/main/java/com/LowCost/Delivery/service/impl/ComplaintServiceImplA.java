package com.LowCost.Delivery.service.impl;

import com.LowCost.Delivery.model.Complaint;
import com.LowCost.Delivery.model.ComplaintA;
import com.LowCost.Delivery.repository.ComplaintRepository;
import com.LowCost.Delivery.repository.ComplaintRepositoryA;
import com.LowCost.Delivery.service.ComplaintService;
import com.LowCost.Delivery.service.ComplaintServiceA;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplaintServiceImplA implements ComplaintServiceA {

    private final ComplaintRepositoryA repo;

    @Override
    public List<ComplaintA> getAll() {
        return repo.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public ComplaintA getById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found: " + id));
    }

    @Transactional
    @Override
    public void saveReply(String id, String reply) {
        ComplaintA c = getById(id);
        c.setAdminReply(reply);
        repo.save(c);
    }

    @Transactional
    @Override
    public void resolve(String id, String reply) {
        ComplaintA c = getById(id);
        c.setAdminReply(reply);
        c.setStatus("RESOLVED");
        c.setResolvedAt(LocalDateTime.now());
        repo.save(c);
    }
}
