package de.bindoc.container;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StatefulApplicationConfigurationTest {

    @Autowired
    StatefulApplicationConfiguration configuration;

    @Test
    public void loadedConfig() {
        assertThat(configuration.getDirectory(), is("/tmp/"));
    }

}