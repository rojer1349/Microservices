package de.bindoc.container

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class GatewayApplication {
    @Bean
    fun restTemplate() = RestTemplate()
}

@RestController
class Controller(
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
        val stateful: String,
        val stateless: String
    )
}

fun main(args: Array<String>) {
    runApplication<GatewayApplication>(*args)
}