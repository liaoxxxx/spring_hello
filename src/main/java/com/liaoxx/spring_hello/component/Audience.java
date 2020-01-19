package com.liaoxx.spring_hello.component;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "audience")
@Component
public class Audience {

    private String clientId;

    private String base64Secret;

    private String name;

    public String getClientId() {
        return clientId;
    }

    public String getBase64Secret() {
        return base64Secret;
    }

    public String getName() {
        return name;
    }

    public int getExpiresSecond() {
        return expiresSecond;
    }

    private int expiresSecond;
}
