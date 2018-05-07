package de.bindoc.container;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StatefulApplicationConfiguration {

    @Value("${state.directory}")
    private String directory;


    public String getDirectory() {
        return directory;
    }

}
