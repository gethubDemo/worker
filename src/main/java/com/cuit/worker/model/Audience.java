package com.cuit.worker.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "audience")
@Component
public class Audience {
    private String base64Secret;
    private String name;
    private int expireTime;
    private String token;
    private int userId;
    private  int role;
}
