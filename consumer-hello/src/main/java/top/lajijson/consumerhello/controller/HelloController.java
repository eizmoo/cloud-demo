package top.lajijson.consumerhello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String hello() {
        return restTemplate.getForEntity("http://SERVICE-HELLO/hello/config/info", String.class).getBody();
    }


}
