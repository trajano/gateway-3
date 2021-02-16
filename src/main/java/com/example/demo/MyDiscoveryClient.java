package com.example.demo;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MyDiscoveryClient implements ReactiveDiscoveryClient {

    private final Map<String, Set<ServiceInstance>> services = new ConcurrentHashMap<>();

    @PostConstruct
    public void hello() {
        services.put("sample", Set.of(new DefaultServiceInstance(
                "instanceId",
                "sample",
                "foo.com",
                8080,
                false
        )));
    }

    @Override
    public String description() {
        return "My Discovery Client";
    }

    @Override
    public Flux<ServiceInstance> getInstances(String serviceId) {
        System.out.println(serviceId);
        return Flux.fromIterable(services.getOrDefault(serviceId, Set.of()));
    }

    @Override
    public Flux<String> getServices() {
        return Flux.fromIterable(services.keySet());
    }

}
