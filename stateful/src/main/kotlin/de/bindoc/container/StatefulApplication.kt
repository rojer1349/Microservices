package de.bindoc.container

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class StatefulApplication

@RestController
class Controller(val stateService: StateService) {
  @GetMapping("/")
  fun getState() = stateService.state.isPersistent
}

fun main(args: Array<String>) {
  runApplication<StatefulApplication>(*args)
}
