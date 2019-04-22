package top.lajijson.consumerhello.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "infoZuul", method = RequestMethod.GET)
    public String hello() {
        long beginTime = System.currentTimeMillis();
        String response = restTemplate.getForEntity("http://SERVICE-HELLO/hello/config/info", String.class).getBody();
        long endTime = System.currentTimeMillis();
        log.info("time:{}", endTime - beginTime);
        return response;
    }

    @RequestMapping(value = "infoHttp", method = RequestMethod.GET)
    public String hello1() {
        long beginTime = System.currentTimeMillis();
        String response = sendGet("http://127.0.0.1:8121/hello/config/info");
        long endTime = System.currentTimeMillis();
        log.info("time:{}", endTime - beginTime);
        return response;
    }

    public static String sendGet(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String returnValue = "";
        try {
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                returnValue= EntityUtils.toString(response.getEntity(),"utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return returnValue;
    }


}
