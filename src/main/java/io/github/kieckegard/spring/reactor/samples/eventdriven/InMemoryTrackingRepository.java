/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.spring.reactor.samples.eventdriven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Repository
public class InMemoryTrackingRepository implements TrackingRepository {

    private final List<Tracking> trackings = Collections.synchronizedList(new ArrayList<>());
    
    @Override
    public void persist(List<Tracking> tracking) {
        this.trackings.addAll(tracking);
    }
    
}
