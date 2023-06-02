package com.jchat.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI swaggerUi() {
        OpenAPI openAPI = new OpenAPI();

        List<Server> servers = List.of(new Server().url("http://localhost:8080"), new Server().url("jchat-server.up.railway.app"));

        openAPI.setServers(servers);

        return openAPI;
    }
}
