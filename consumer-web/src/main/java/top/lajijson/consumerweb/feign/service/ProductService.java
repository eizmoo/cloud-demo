package top.lajijson.consumerweb.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.lajijson.consumerweb.feign.service.fallback.ProductServiceFallback;

@FeignClient(name = "SERVICE-PRODUCT", fallback = ProductServiceFallback.class)
public interface ProductService {

    @RequestMapping("/server/info")
    String serverInfo();

    @GetMapping(value = "/product/")
    String list();

    @GetMapping(value = "/product/{id}")
    String getOne(@PathVariable("id") Integer id);

}
