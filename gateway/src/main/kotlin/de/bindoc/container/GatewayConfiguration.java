package de.bindoc.container;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Value("${gateway.stateful.url}")
    private String statefulUrl;

    @Value("${gateway.stateless.url}")
    private String statelessUrl;

    public String getStatefulUrl() {
        return statefulUrl;
    }

    public String getStatelessUrl() {
        return statelessUrl;
    }
}
