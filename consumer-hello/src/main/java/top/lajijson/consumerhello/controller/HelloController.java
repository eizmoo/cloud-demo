package top.lajijson.consumerhello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String hello() {
        return restTemplate.getForEntity("http://SERVICE-HELLO/hello/config/info", String.class).getBody();
    }

    @RequestMapping(value = "infoEx", method = RequestMethod.GET)
    public String helloEx() {
        ServiceInstance instance = this.loadBalancerClient.choose("SERVICE-HELLO");
        URI helloInfoUri = URI.create(String.format("http://%s:%s/hello/config/info", instance.getHost(), instance.getPort()));
        log.info("Target service uri = {}", helloInfoUri.toString());
        return new RestTemplate().getForEntity(helloInfoUri, String.class).getBody();
    }


}
