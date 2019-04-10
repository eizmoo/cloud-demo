package top.lajijson.consumerweb.feign.service.fallback;

import org.springframework.stereotype.Component;
import top.lajijson.consumerweb.feign.service.ProductService;

import java.util.Collections;

@Component
public class ProductServiceFallback implements ProductService {

    @Override
    public String serverInfo() {
        return "null";
    }

    @Override
    public String list() {
        return Collections.emptyList().toString();
    }

    @Override
    public String getOne(Integer id) {
        return "error";
    }
}
