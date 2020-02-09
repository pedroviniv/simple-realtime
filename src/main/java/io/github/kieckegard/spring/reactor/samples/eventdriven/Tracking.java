/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.spring.reactor.samples.eventdriven;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public class Tracking implements Serializable {
    
    @JsonProperty("aggregate_id")
    private String aggregateId;
    
    @JsonProperty("date_time")
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime dateTime;
    
    private Coordinate coordinates;

    public Tracking() {
    }

    public static class Builder {

        private String aggregateId;
        private LocalDateTime dateTime;
        private Coordinate coordinates;

        private Builder() {
        }

        public Builder aggregateId(final String value) {
            this.aggregateId = value;
            return this;
        }

        public Builder dateTime(final LocalDateTime value) {
            this.dateTime = value;
            return this;
        }

        public Builder coordinates(final Coordinate value) {
            this.coordinates = value;
            return this;
        }

        public Tracking build() {
            return new io.github.kieckegard.spring.reactor.samples.eventdriven.Tracking(aggregateId, dateTime, coordinates);
        }
    }

    public static Tracking.Builder builder() {
        return new Tracking.Builder();
    }

    private Tracking(final String aggregateId, final LocalDateTime dateTime, final Coordinate coordinates) {
        this.aggregateId = aggregateId;
        this.dateTime = dateTime;
        this.coordinates = coordinates;
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Tracking{" + "aggregateId=" + aggregateId + ", dateTime=" + dateTime + ", coordinates=" + coordinates + '}';
    }
}
