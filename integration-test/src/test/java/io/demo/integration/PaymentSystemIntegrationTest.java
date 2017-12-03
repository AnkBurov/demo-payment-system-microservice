package io.demo.integration;

import com.palantir.docker.compose.DockerComposeRule;
import com.palantir.docker.compose.configuration.ProjectName;
import com.palantir.docker.compose.connection.DockerPort;
import com.palantir.docker.compose.connection.waiting.HealthChecks;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

public class PaymentSystemIntegrationTest {

    private static final int PORT = 8080;
    private static final String PAYMENT_SYSTEM = "payment-system";

    private RestTemplate restTemplate = new RestTemplate();

    @ClassRule
    public static DockerComposeRule docker = DockerComposeRule.builder()
            .file("../docker-compose.yml")
            .saveLogsTo("logs")
            .projectName(ProjectName.random())
            .build();

//    @Test
    public void checkFeign() throws Exception {
        DockerPort paymentSystem = docker.containers().container(PAYMENT_SYSTEM)
                .port(PORT);
        String url = String.format("http://%s:%s//health/third", paymentSystem.getIp(), paymentSystem.getExternalPort());
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Third party value", responseEntity.getBody());
    }
}
