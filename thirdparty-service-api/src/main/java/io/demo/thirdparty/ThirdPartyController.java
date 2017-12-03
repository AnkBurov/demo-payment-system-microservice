package io.demo.thirdparty;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("thirdparty-service")
public interface ThirdPartyController {

    @RequestMapping(
            value = "/thirdparty",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE)
    String getString();
}
