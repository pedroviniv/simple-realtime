/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.spring.reactor.samples.eventdriven;

import java.util.List;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 *
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Service
public class TrackingService {
    
    private TrackingRepository trackingRepository;    
    private TrackingPublisherService trackingPublisherService;

    public TrackingService(TrackingRepository trackingRepository, TrackingPublisherService trackingPublisherService) {
        this.trackingRepository = trackingRepository;
        this.trackingPublisherService = trackingPublisherService;
    }
    
    public void persist(List<Tracking> tracking) {
        
        this.trackingRepository.persist(tracking);
        this.trackingPublisherService.publish(tracking);
    }
    
    public Flux<Tracking> subscribe(String aggregateId) {
        
        final Flux<Tracking> tracking = this.trackingPublisherService.subscribe(aggregateId);
        return tracking;
    }
    
}
