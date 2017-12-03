package io.demo.paymentsystem.controller

import io.demo.thirdparty.ThirdPartyController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/health")
class HealthCheckController(private val thirdPartyController: ThirdPartyController) {

    @GetMapping
    fun checkHealth() = "ok"

    @GetMapping("/third")
    fun getThirdPartyValue(): String? {
        return thirdPartyController.string
    }
}