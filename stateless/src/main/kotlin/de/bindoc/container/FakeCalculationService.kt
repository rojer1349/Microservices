package de.bindoc.container

import com.martensigwart.fakeload.FakeLoadExecutor
import com.martensigwart.fakeload.FakeLoadExecutors
import com.martensigwart.fakeload.FakeLoads
import org.springframework.stereotype.Service
import java.time.Duration
import java.time.Instant
import java.util.concurrent.TimeUnit

class FakeCalculationService {

    val executor = FakeLoadExecutors.newDefaultExecutor()

    fun calculate(duration: Duration): Calculation {
        val start = Instant.now()

        val fakeload = FakeLoads.create()
            .lasting(duration.toMillis(), TimeUnit.MILLISECONDS)
            .withCpu(80)

        executor.execute(fakeload)
        val end = Instant.now()

        return Calculation(start, Duration.between(start, end))
    }

}