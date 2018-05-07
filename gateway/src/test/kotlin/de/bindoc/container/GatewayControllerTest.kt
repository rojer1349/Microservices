package de.bindoc.container

import org.hamcrest.Matchers.`is`
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath


@SpringBootTest
@RunWith(SpringRunner::class)
@AutoConfigureMockMvc
class GatewayControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var statefulClient: StatefulClient

    @MockBean
    lateinit var statelessClient: StatelessClient

    @Test
    fun get() {
        Mockito.`when`(statefulClient.getState()).then { """{ "persistent": true } """ }
        Mockito.`when`(statelessClient.getMessage()).then { "Hello World" }

        mockMvc.perform(get("/"))
            .andExpect(jsonPath("$.stateless", `is`("Hello World")))
    }
}