package de.bindoc.container

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.time.Duration
import java.time.Instant

@Service
class StatelessClient(
    val configuration: GatewayConfiguration,
    val restTemplate: RestTemplate
) {

    fun getMessage(): Calculation = restTemplate.getForObject(configuration.statelessUrl, Calculation::class.java)
            ?: throw IllegalStateException("could not retrieve message from stateless service")

}
data class Calculation(val start: Instant, val duration: Duration)
