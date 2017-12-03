package io.demo.paymentsystem.healthcheck

import io.demo.paymentsystem.bodyNotNull
import io.demo.paymentsystem.ok
import io.demo.thirdparty.ThirdPartyController
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HealthCheckControllerTest {

    @MockBean
    private lateinit var thirdPartyController: ThirdPartyController

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    fun checkHealth() {
        restTemplate.getForEntity("/health", String::class.java)
                .ok()
                .bodyNotNull()
    }

    @Test
    fun getThirdPartyValue() {
        val expected = "Third party value"
        Mockito.`when`(thirdPartyController.string)
                .thenReturn(expected)
        restTemplate.getForEntity("/health/third", String::class.java)
                .ok()
                .bodyNotNull()
                .let { Assert.assertEquals(expected, it) }
    }
}