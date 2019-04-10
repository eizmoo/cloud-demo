package top.lajijson.serviceproduct.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lajijson.serviceproduct.entity.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class ProductController {

    @Value("${server.port}")
    private int serverPort;

    private static ArrayList<Product> products = Lists.newArrayList(
            new Product(1, "茄子", new BigDecimal(5)),
            new Product(2, "豆角", new BigDecimal(3)),
            new Product(3, "鸡蛋", new BigDecimal(4))

    );


    @RequestMapping("/server/info")
    public String serverInfo() {
        return "port:" + serverPort;
    }

    @GetMapping("/product/")
    public String list() {
        return JSON.toJSONString(products);
    }

    @GetMapping("/product/{id}")
    public String getOne(@PathVariable Integer id) {
        return products.stream().filter(p -> p.getId().equals(id)).limit(1).collect(Collectors.toList()).get(0).toString();
    }


}
