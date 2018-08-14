package de.bindoc.container

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GatewayController(
    val statefulClient: StatefulClient,
    val statelessClient: StatelessClient
) {

    @GetMapping("/")
    fun get(): Response {
        return Response(
            stateful = statefulClient.getState(),
            stateless = statelessClient.getMessage()
        )
    }

    data class Response(
        val stateful: State,
        val stateless: Calculation
    )
}