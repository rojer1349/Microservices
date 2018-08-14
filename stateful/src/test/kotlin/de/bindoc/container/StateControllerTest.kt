package de.bindoc.container

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import java.time.Instant

@WebMvcTest(StateController::class)
@RunWith(SpringRunner::class)
class StateControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var stateService: StateService

    @Test
    fun getState() {
        val now = Instant.now()
        Mockito.`when`(stateService.state).then { State.Persistent(now) }
        mockMvc.perform(get("/"))
            .andDo(print())
    }
}