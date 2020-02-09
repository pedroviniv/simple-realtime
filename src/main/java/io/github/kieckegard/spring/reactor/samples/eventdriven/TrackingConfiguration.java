/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.spring.reactor.samples.eventdriven;

import java.util.List;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;

/**
 *
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Configuration
public class TrackingConfiguration {
    
    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public FluxProcessor provideProcessor() {
        return DirectProcessor.create().serialize();
    }
    
    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public FluxSink<List<Tracking>> provideSink(FluxProcessor processor) {
        return processor.sink();
    }
}
