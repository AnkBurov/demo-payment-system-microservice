package io.demo.thirdparty;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ThirdPartyControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getString() throws Exception {
        //todo попробовать с mockmvc
        String string = restTemplate.getForObject("/thirdparty", String.class);
        Assert.assertEquals("Third party value", string);
    }
}
