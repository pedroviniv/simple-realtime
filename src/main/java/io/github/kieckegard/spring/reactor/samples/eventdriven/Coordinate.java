/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.spring.reactor.samples.eventdriven;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public class Coordinate implements Serializable {
    
    private Double lat;
    private Double lng;

    public Coordinate(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    protected Coordinate() {}    

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.lat);
        hash = 41 * hash + Objects.hashCode(this.lng);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordinate other = (Coordinate) obj;
        if (!Objects.equals(this.lat, other.lat)) {
            return false;
        }
        if (!Objects.equals(this.lng, other.lng)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Coordinate{" + "lat=" + lat + ", lng=" + lng + '}';
    }
}
