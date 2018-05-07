package de.bindoc.container

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class StatelessApplication


@RestController
class Controller {

    @GetMapping("/")
    fun show(): String = "Hello World"

}



fun main(args: Array<String>) {
  runApplication<StatelessApplication>(*args)
}
