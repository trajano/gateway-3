package com.example.demo;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class MyDiscoveryClient implements DiscoveryClient {
    @PostConstruct
    public void hello() {
        System.out.println("Hello world");
    }
    @Override
    public String description() {
        return "My Discovery Client";
    }

    @Override
    public List<ServiceInstance> getInstances(String serviceId) {
        System.out.println(serviceId);
        return List.of();
    }

    @Override
    public List<String> getServices() {
        System.out.println("getServices");
        return List.of();
    }
}
