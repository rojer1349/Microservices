package de.bindoc.container

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class StatefulClient(
    val configuration: GatewayConfiguration,
    val restTemplate: RestTemplate
) {

    fun getState(): String {
        val state = restTemplate.getForObject(configuration.statefulUrl, String::class.java)
                ?: throw IllegalStateException("Could not retrieve state from stateful service")
        return state
    }

}