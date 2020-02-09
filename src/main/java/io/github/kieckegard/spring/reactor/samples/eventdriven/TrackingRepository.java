/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.spring.reactor.samples.eventdriven;

import java.util.List;

/**
 *
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public interface TrackingRepository {
    
    void persist(List<Tracking> tracking);
}
