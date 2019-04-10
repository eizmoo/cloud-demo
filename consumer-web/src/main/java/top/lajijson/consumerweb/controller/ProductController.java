package top.lajijson.consumerweb.controller;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.lajijson.consumerweb.feign.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public String list() {
        return this.productService.list();
    }

    @GetMapping(value = "/{id}")
    public String detail(@PathVariable Integer id) {
        return this.productService.getOne(id);
    }

}
