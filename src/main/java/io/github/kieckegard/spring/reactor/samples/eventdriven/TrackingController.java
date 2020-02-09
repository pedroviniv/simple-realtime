/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.spring.reactor.samples.eventdriven;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 *
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@RestController
@RequestMapping("/tracking")
public class TrackingController {
    
    private TrackingService trackingService;

    @Autowired
    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }
    
    @PostMapping
    public void save(@RequestBody List<Tracking> tracking) {
        
        this.trackingService.persist(tracking);
    }
    
    @GetMapping(value = "/{sub_id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tracking> subscribe(@PathVariable("sub_id") final String subId) {
        
        return this.trackingService.subscribe(subId);
    }
}
