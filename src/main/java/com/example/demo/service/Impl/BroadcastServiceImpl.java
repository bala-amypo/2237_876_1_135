package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.BroadcastService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BroadcastServiceImpl implements BroadcastService {

    private final BroadcastLogRepository logRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final EventUpdateRepository updateRepository;

    public BroadcastServiceImpl(BroadcastLogRepository logRepository,
                                SubscriptionRepository subscriptionRepository,
                                EventUpdateRepository updateRepository) {
        this.logRepository = logRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.updateRepository = updateRepository;
    }

    @Override
    public void broadcastUpdate(Long updateId) {
        EventUpdate update = updateRepository.findById(updateId)
                .orElseThrow(() -> new ResourceNotFoundException("Update not found"));

        List<Subscription> subscriptions =
                subscriptionRepository.findByEventId(update.getEvent().getId());

        for (Subscription sub : subscriptions) {
            BroadcastLog log = new BroadcastLog(update, sub.getUser(), "SENT");
            logRepository.save(log);
        }
    }

    @Override
    public List<BroadcastLog> getLogsForUpdate(Long updateId) {
        return logRepository.findByEventUpdateId(updateId);
    }

    @Override
    public void recordDelivery(Long updateId, Long subscriberId, boolean failed) {
        List<BroadcastLog> logs = logRepository.findByEventUpdateId(updateId);
        for (BroadcastLog log : logs) {
            if (log.getSubscriber().getId().equals(subscriberId)) {
                log.setDeliveryStatus(failed ? "FAILED" : "SENT");
                logRepository.save(log);
                return;
            }
        }
        throw new ResourceNotFoundException("Broadcast log not found");
    }
}
