package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class MyDiscoveryClient implements ReactiveDiscoveryClient {
    private final DiscoveryLocatorProperties discoveryLocatorProperties;

    public MyDiscoveryClient(final DiscoveryLocatorProperties discoveryLocatorProperties) {
        this.discoveryLocatorProperties = discoveryLocatorProperties;
    }

    @PostConstruct
    public void hello() {
        System.out.println("Hello world" + discoveryLocatorProperties);
    }

    @Override
    public String description() {
        return "My Discovery Client";
    }

    @Override
    public Flux<ServiceInstance> getInstances(String serviceId) {
        System.out.println("getInstances()" + serviceId);
        return Flux.just();
    }

    @Override
    public Flux<String> getServices() {
        System.out.println("getServices()");
        return Flux.just();
    }

}
