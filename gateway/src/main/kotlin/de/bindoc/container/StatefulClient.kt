package de.bindoc.container

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.time.Instant

@Service
class StatefulClient(
    val configuration: GatewayConfiguration,
    val restTemplate: RestTemplate
) {

    fun getState(): State {
        val state = restTemplate.getForObject(configuration.statefulUrl, State::class.java)
                ?: throw IllegalStateException("Could not retrieve state from stateful service")
        return state
    }

}

data class State(
    val lastModified: Instant,
    val persistent: Boolean
)