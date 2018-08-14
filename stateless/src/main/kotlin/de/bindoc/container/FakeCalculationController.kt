package de.bindoc.container

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Duration

@RestController
class FakeCalculationController {

    private val fakeCalculationService: FakeCalculationService = FakeCalculationService()

    @GetMapping("/")
    fun calculate(): Calculation = fakeCalculationService.calculate(Duration.ofMillis(700))

}