package de.bindoc.container

import org.hamcrest.Matchers.`is`
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import java.time.Instant


@WebMvcTest(GatewayController::class)
@RunWith(SpringRunner::class)
class GatewayControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var statefulClient: StatefulClient

    @MockBean
    lateinit var statelessClient: StatelessClient

    @Test
    fun get() {
        Mockito.`when`(statefulClient.getState()).then { State(Instant.now(), false) }
        Mockito.`when`(statelessClient.getMessage()).then { "Hello World" }

        mockMvc.perform(get("/"))
            .andDo(print())
            .andExpect(jsonPath("$.stateless", `is`("Hello World")))
    }
}