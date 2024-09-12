package com.unchk.unchk.env;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
@ConfigurationProperties(prefix = "env.custome.variable")
public class CustomeVariable {

    public String path;
}
