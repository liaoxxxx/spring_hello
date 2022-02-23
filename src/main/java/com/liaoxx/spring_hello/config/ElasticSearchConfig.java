package com.liaoxx.spring_hello.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "spring.elasticsearch.rest")
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {



    //
    // @Value("${spring.data.elasticsearch.uri}")
    private  String uris="127.0.0.1:9200";

    @Value("${spring.data.elasticsearch.client.reactive.username}")
    private String  username;


    @Value("${spring.data.elasticsearch.client.reactive.username}")
    private  String password;

    @Override
    @Bean(destroyMethod = "close")
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(uris)
                .withBasicAuth(username, password)
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
