package de.bindoc.container

import org.hamcrest.Matchers.closeTo
import org.junit.Test

import org.junit.Assert.*

import java.time.Duration

class FakeCalculationServiceTest {

    val fakeCalculationService: FakeCalculationService = FakeCalculationService()

    @Test
    fun calculate() {
        (1..5).forEach {
            val calculation = fakeCalculationService.calculate(Duration.ofMillis(500))
            assertThat(calculation.duration.toMillis().toDouble(), closeTo(500.00, 75.0))
        }
    }
}