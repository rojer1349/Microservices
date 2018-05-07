package de.bindoc.container

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class StatelessClient(
    val configuration: GatewayConfiguration,
    val restTemplate: RestTemplate
) {

    fun getMessage(): String = restTemplate.getForObject(configuration.statelessUrl, String::class.java)
            ?: throw IllegalStateException("could not retrieve message from stateless service")

}