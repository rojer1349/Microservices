package de.bindoc.container

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StateController(val stateService: StateService) {
    @GetMapping("/")
    fun getState(): State = stateService.state
}