package top.lajijson.serviceuser.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.lajijson.serviceuser.entity.User;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserEndpoint {

    @Value("${server.port}")
    private int serverPort;

    @RequestMapping(value = "/{loginName}", method = RequestMethod.GET)
    public String detail(@PathVariable String loginName) {
        String memos = "I come form " + this.serverPort;
        return new User(loginName, memos, loginName).toString();
    }
}
