package de.bindoc.container

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
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
class StatelessClientTest {

    lateinit var server: MockRestServiceServer

    @Autowired
    lateinit var subject: StatelessClient

    @Autowired
    lateinit var restTemplate: RestTemplate

    @MockBean
    lateinit var gatewayConfiguration: GatewayConfiguration

    @Before
    fun before() {
        val response = """
           {"start":"2018-08-14T12:49:27.550Z","duration":"PT0.724S"}
        """.trimIndent()
        server = MockRestServiceServer.bindTo(restTemplate).build()
        server.expect(requestTo(""))
            .andRespond(withSuccess(response, MediaType.APPLICATION_JSON_UTF8))
    }

    @Test
    fun getMessage() {
        Mockito.`when`(gatewayConfiguration.statelessUrl).then { "" }
        val calculation = subject.getMessage()
        println(calculation)
    }

}