/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.spring.reactor.samples.eventdriven;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;

/**
 *
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Service
public class ReactorTrackingPublisherService implements TrackingPublisherService {
    
    private final FluxProcessor<List<Tracking>, List<Tracking>> fluxProcessor;
    private final FluxSink<List<Tracking>> sink;

    @Autowired
    public ReactorTrackingPublisherService(FluxProcessor fluxProcessor, FluxSink<List<Tracking>> sink) {
        this.fluxProcessor = fluxProcessor;
        this.sink = sink;
    }
    
    @Override
    public void publish(List<Tracking> data) {
        this.sink.next(data);
    }
    
    @Override
    public Flux<Tracking> subscribe(String subId) {
        
        return this.fluxProcessor
                .flatMap(Flux::fromIterable)
                .filter(tracking -> tracking.getAggregateId().equals(subId));
    }
    
}
