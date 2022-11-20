package com.vclemoncha.powerconsolespring.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "pc")
public class ConfigProperties {
    private String dbDriverClassName;
    private String dbUrl;
    private String dbUsername;
    private String dbPassword;
    private String dbMapperXml;
}
