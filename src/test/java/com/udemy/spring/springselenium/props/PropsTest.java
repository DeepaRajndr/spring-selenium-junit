package com.udemy.spring.springselenium.props;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

@SpringBootTest
public class PropsTest {
    @Autowired
    private ResourceLoader loader;
    @Test
    public void propsTest() throws IOException {
        Properties properties = PropertiesLoaderUtils.loadProperties(loader.getResource("my.properties"));
        System.out.println(
                properties
        );
    }

}
