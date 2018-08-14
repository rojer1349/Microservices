package de.bindoc.container

import org.hamcrest.Matchers.closeTo
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.Duration
import java.time.temporal.TemporalUnit

@SpringBootTest
@RunWith(SpringRunner::class)
class FakeCalculationServiceTest {

    @Autowired
    lateinit var fakeCalculationService: FakeCalculationService

    @Test
    fun calculate() {
        (1..5).forEach {
            val calculation = fakeCalculationService.calculate(Duration.ofMillis(500))
            assertThat(calculation.duration.toMillis().toDouble(), closeTo(500.00, 75.0))
        }

    }
}