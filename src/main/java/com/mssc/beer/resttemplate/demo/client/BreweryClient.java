package com.mssc.beer.resttemplate.demo.client;

import com.mssc.beer.resttemplate.demo.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@ConfigurationProperties(value = "sfg.beer",ignoreInvalidFields = false)
@Component
public class BreweryClient {
    private final String BEER_PATH_V1="/api/v1/beer/";
    private String apiHost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplate=restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost)
    {
        this.apiHost=apiHost;
    }

    public BeerDto getBeerById(UUID uuid)
    {
        return restTemplate.getForObject(apiHost+BEER_PATH_V1+UUID.randomUUID(),BeerDto.class);
    }

}
