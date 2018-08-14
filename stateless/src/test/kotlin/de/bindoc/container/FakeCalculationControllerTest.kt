package de.bindoc.container

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print

@WebMvcTest(FakeCalculationController::class)
@RunWith(SpringRunner::class)
class FakeCalculationControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun calculate() {
        mockMvc.perform(get("/"))
            .andDo(print())
    }
}