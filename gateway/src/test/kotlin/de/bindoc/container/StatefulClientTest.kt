package de.bindoc.container

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo
import org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess
import org.springframework.web.client.RestTemplate

@SpringBootTest
@RunWith(SpringRunner::class)
class StatefulClientTest {

    lateinit var server: MockRestServiceServer

    @Autowired
    lateinit var subject: StatefulClient

    @Autowired
    lateinit var restTemplate: RestTemplate

    @MockBean
    lateinit var gatewayConfiguration: GatewayConfiguration

   // response: {"lastModified":"2018-08-14T10:50:37.815Z","persistent":true}

    @Before
    fun setup() {
        val response = """
           {"lastModified":"2018-08-14T10:50:37.815Z","persistent":true}
        """.trimIndent()
        server = MockRestServiceServer.bindTo(restTemplate).build()
        server.expect(requestTo(""))
            .andRespond(withSuccess(response, MediaType.APPLICATION_JSON_UTF8))
    }

    @Test
    fun getState() {
        Mockito.`when`(gatewayConfiguration.statefulUrl).then { "" }
        val state = subject.getState()
        assert(state.persistent)
    }
}